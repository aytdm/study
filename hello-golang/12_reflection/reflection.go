package main

import (
  "fmt"
  "reflect" // https://godoc.org/reflect
)

func getValue(x interface{}) reflect.Value {
  val := reflect.ValueOf(x)

  if val.Kind() == reflect.Ptr {
    val = val.Elem()
  }

  return val
}

func walk(x interface{}, fn func(input string)) {
  val := getValue(x)

  walkValue := func(value reflect.Value) {
    walk(value.Interface(), fn)
  }

  switch val.Kind() {
  case reflect.String:
    fmt.Printf("field: %s\n", val)
    fn(val.String())
  case reflect.Slice, reflect.Array:
    for i := 0; i < val.Len(); i++ {
      walkValue(val.Index(i))
    }
  case reflect.Struct:
    for i := 0; i < val.NumField(); i++ {
      walkValue(val.Field(i))
    }
  case reflect.Map:
    for _, key := range val.MapKeys() {
      walkValue(val.MapIndex(key))
    }
  case reflect.Chan:
    for v, ok := val.Recv(); ok; v, ok = val.Recv() {
      walk(v.Interface(), fn)
    }
  case reflect.Func:
    valFuncResult := val.Call(nil)
    for _, res := range valFuncResult {
      walk(res.Interface(), fn)
    }
  }
}
