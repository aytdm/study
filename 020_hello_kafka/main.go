package main

import (
	"context"
	"fmt"
	"log"
	"os"
	"strconv"
	"time"

	"github.com/segmentio/kafka-go"
)

// the topic and broker address are initialized as constants
const (
	topic          = "hello-kafka"
	brokerAddress1 = "localhost:9092"
	brokerAddress2 = "localhost:9093"
	brokerAddress3 = "localhost:9094"
)

func main() {
	// create a new context
	ctx := context.Background()
	// produce messages in a new go routine, since
	// both the produce and consume functions are
	// blocking
	go produce(ctx)
	consume(ctx)
}

func produce(ctx context.Context) {
	// initialize a counter
	i := 0

	// initialize a logger
	l := log.New(os.Stdout, "kafka writer: ", 0)

	// intialize the writer with the broker addresses, and the topic
	w := kafka.NewWriter(kafka.WriterConfig{
		Brokers: []string{brokerAddress1, brokerAddress2, brokerAddress3},
		Topic:   topic,
		Async:   true,
		Logger:  l,
	})

	for {
		// each kafka message has a key and value. The key is used
		// to decide which partition (and consequently, which broker)
		// the message gets published on
		err := w.WriteMessages(ctx, kafka.Message{
			Headers: []kafka.Header{
				{
					Key:   topic + strconv.Itoa(i),
					Value: []byte(strconv.FormatInt(time.Now().Unix(), 10)),
				},
			},
			Key: []byte(strconv.Itoa(i)),
			// create an arbitrary message payload for the value
			Value: []byte("this is message" + strconv.Itoa(i)),
		})
		if err != nil {
			panic("could not write message " + err.Error())
		}

		// log a confirmation once the message is written
		fmt.Println("writes:", i)
		i++
		// sleep for a second
		time.Sleep(time.Second)
	}
}

func consume(ctx context.Context) {
	// initialize a logger
    l := log.New(os.Stdout, "kafka reader: ", 0)

	// initialize a new reader with the brokers and topic
	// the groupID identifies the consumer and prevents
	// it from receiving duplicate messages
	r := kafka.NewReader(kafka.ReaderConfig{
		Brokers: []string{brokerAddress1, brokerAddress2, brokerAddress3},
		Topic:   topic,
		GroupID: "my-group",
		Logger:  l,
	})
	for {
		// the `FetchMessage` method reads and return the next message from the r
		msg, err := r.FetchMessage(ctx)
		if err != nil {
			panic("could not read message " + err.Error())
		}
		// after receiving the message, log its value
		fmt.Println("received: ", string(msg.Value))

		err = r.CommitMessages(ctx, msg)
		if err != nil {
			fmt.Printf("fetch process commit failed: %v", err)
		}
	}
}
