package main

import (
  "fmt"
  "net/http"
  "time"
)

var tenSecondTimeout = 10 * time.Second

func Racer(targetA, targetB string) (winner string, error error) {
  return ConfigurableRacer(targetA, targetB, tenSecondTimeout)
}

func ConfigurableRacer(targetA, targetB string, timeout time.Duration) (winner string, error error) {
  select {
  case <-ping(targetA):
    return targetA, nil
  case <-ping(targetB):
    return targetB, nil
  case <-time.After(timeout):
    return "", fmt.Errorf("timed out waiting for %s and %s", targetA, targetB)
  }
}

func ping(url string) chan struct{} {
  ch := make(chan struct{})

  go func() {
    http.Get(url)
    close(ch)
  }()

  return ch
}
