package main

import (
  "fmt"
  "reflect"
  "testing"
)

type Person struct {
  Name string
  Profile Profile
}

type Profile struct {
  Age int
  City string
}

func assertContains(t *testing.T, haystack []string, needle string)  {
  t.Helper()
  contains := false

  for _, x := range haystack {
      if x == needle {
          contains = true
      }
  }

  if !contains {
      t.Errorf("expected %+v to contain %q but it didn't", haystack, needle)
  }
}

func TestWalk(t *testing.T) {
  testCases := []struct{
    Name string
    Input interface{}
    ExpectedCalles []string
  } {
    {
      "Struct with one string field",
      struct {
        Name string
      }{"Chris"},
      []string{"Chris"},
    },
    {
      "Struct with two string fields",
      struct {
        Name string
        City string
      }{"Chris", "London"},
      []string{"Chris", "London"},
    },
    {
      "Struct with non string field",
      struct {
        Name string
        Age  int
      }{"Chris", 33},
      []string{"Chris"},
    },
    {
      "Nested fields",
      Person {
        "Chris",
        Profile {33, "London"},
      },
      []string{"Chris", "London"},
    },
    {
      "Pointers to things",
      &Person{
        "Chris",
        Profile{33, "London"},
      },
      []string{"Chris", "London"},
    },
    {
      "Slices",
      []Profile {
        {33, "London"},
        {34, "Reykjavík"},
      },
      []string{"London", "Reykjavík"},
    },
    {
      "Arrays",
      [2]Profile {
        {33, "London"},
        {34, "Reykjavík"},
     },
      []string{"London", "Reykjavík"},
    },
    {
      "Maps",
      map[string]string{
        "Foo": "Bar",
        "Baz": "Boz",
      },
      []string{"Bar", "Boz"},
    },
  }

  fmt.Printf("testCases: %+v\n", testCases)

  for _, testCase := range testCases {
    fmt.Println("+++")
    fmt.Printf("Name: %s\n", testCase.Name)
    fmt.Printf("Input: %s\n", testCase.Input)
    fmt.Printf("ExpectedCalles: %s\n", testCase.ExpectedCalles)

    t.Run(testCase.Name, func(t *testing.T) {
      var got []string
      walk(testCase.Input, func(input string) {
        got = append(got, input)
      })

      if !reflect.DeepEqual(got, testCase.ExpectedCalles) {
        t.Errorf("got %v, want %v", got, testCase.ExpectedCalles)
      }
    })
    fmt.Println("---")
  }

  t.Run("with maps", func(t *testing.T) {
    aMap := map[string]string {
      "Foo": "Bar",
      "Baz": "Boz",
    }

    var got []string

    walk(aMap, func(input string) {
      got = append(got, input)
    })

    assertContains(t, got, "Bar")
    assertContains(t, got, "Boz")
  })

  t.Run("with channels", func(t *testing.T) {
    aChannel := make(chan Profile)

    go func() {
      aChannel <- Profile{33, "Berlin"}
      aChannel <- Profile{34, "Katowice"}
      close(aChannel)
    }()

    var got []string
    want := []string{"Berlin", "Katowice"}

    walk(aChannel, func(input string) {
      got = append(got, input)
    })

    if !reflect.DeepEqual(got, want) {
      t.Errorf("got %v, want %v", got, want)
    }
  })

  t.Run("with function", func(t *testing.T) {
    aFunction := func() (Profile, Profile) {
      return Profile{33, "Berlin"}, Profile{34, "Katowice"}
    }

    var got []string
    want := []string{"Berlin", "Katowice"}

    walk(aFunction, func(input string) {
      got = append(got, input)
    })

    if !reflect.DeepEqual(got, want) {
      t.Errorf("got %v, want %v", got, want)
    }
  })
}
