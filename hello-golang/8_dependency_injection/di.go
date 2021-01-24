package main

import (
	"fmt"
	// "os"
	"io"
	"net/http"
)

// `fmt.Fprintf` allows you to pass in an io.Writer which we know both `os.Stdout` and `bytes.Buffer` implement
func Greet(writer io.Writer, name string) {
	fmt.Fprintf(writer, "Hello, %s", name)
}

func MyGreeterHandler(w http.ResponseWriter, r *http.Request) {
	Greet(w, "world")
}

func main() {
	// Greet(os.Stdout, "Elodie")
	http.ListenAndServe(":5000", http.HandlerFunc(MyGreeterHandler))
}
