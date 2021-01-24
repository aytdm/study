package main

import (
  "context"
  "fmt"
  "net/http"
)

type Store interface {
  Fetch(crx context.Context) (string, error)
}

func Server(store Store) http.HandlerFunc {
  return func(w http.ResponseWriter, r *http.Request) {
    data, err := store.Fetch(r.Context())

    if err != nil {
      return // TODO long error however you like
    }
    fmt.Fprint(w, data)
  }
}
