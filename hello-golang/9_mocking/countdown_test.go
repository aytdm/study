package main

import (
  "testing"
  "bytes"
  "reflect"
  "time"
)

const write = "write"
const sleep = "sleep"

type SpySleeper struct {
  Calls int
}

type CountdownOperationsSpy struct {
  Calls []string
}

type SpyTime struct {
  durationSlept time.Duration
}

func (s *SpyTime) Sleep(duration time.Duration) {
  s.durationSlept = duration
}

func (s *CountdownOperationsSpy) Sleep() {
  s.Calls = append(s.Calls, sleep)
}

func (s *CountdownOperationsSpy) Write(p []byte) (n int, err error) {
  s.Calls = append(s.Calls, write)
  return
}

func TestConfigurableSleeper(t *testing.T) {
  sleepTime := 5 * time.Second

  spyTime := &SpyTime{}
  sleeper := ConfigurableSleeper{sleepTime, spyTime.Sleep}
  sleeper.Sleep()

  if spyTime.durationSlept != sleepTime {
    t.Errorf("should have slept for %v but slept for %v", sleepTime, spyTime.durationSlept)
  }
}

func TestCountdown(t *testing.T) {
  t.Run("prints 2 to Go!", func(t *testing.T) {
    buffer := &bytes.Buffer{}

    Countdown(buffer, &CountdownOperationsSpy{})

    got := buffer.String()
    want := `3
2
1
Go!`

    if got != want {
      t.Errorf("got %q want %q", got, want)
    }
  })

  t.Run("sleep before every print", func(t *testing.T) {
    spySleepPrinter := &CountdownOperationsSpy{}
    Countdown(spySleepPrinter, spySleepPrinter)

    want := []string{
      sleep,
      write,
      sleep,
      write,
      sleep,
      write,
      sleep,
      write,
    }

    if !reflect.DeepEqual(want, spySleepPrinter.Calls) {
      t.Errorf("wanted calls %v got %v", want, spySleepPrinter.Calls)
    }
  })
}
