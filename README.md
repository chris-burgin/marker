# Marker 
[![Clojars Project](https://img.shields.io/clojars/v/marker.svg)](https://clojars.org/marker)
[![Build Status](https://travis-ci.org/chrisburgin95/marker.svg?branch=master)](https://travis-ci.org/chrisburgin95/marker)

A Clojure library that makes it easy to colorize your outputs.

![logo](./img/screenshot.png)

## Usage

```clj
(:require [marker.core :refer [marker]])
```

### Example 1
```clj
(def purple (marker.core/marker :purple))
(def blue (marker.core/marker :blue))

(println (blue "Hope you enjoy using") (purple "Marker!"))
```

### Example 2
```clj
(println (marker :blue "This text is blue!"))
```

## Colors

```clj
:black
:red
:green
:yellow
:blue
:purple
:cyan
:color-off
```

## License

Distributed under the MIT License.
