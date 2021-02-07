(ns cljs101.exercises.ex102-strings
  (:require
    [clojure.string :as str]))

(declare fav-pizza-topping fav-ice-cream fav-band
         the-old-pond another-year
         num-letters-in-samantha reverse-samantha proper-samantha loud-samantha tha-suffix?)

;;
;; - ClojureScript Strings are JavaScript Strings
;; - Strings are always wrapped in double quote characters: "hello"
;; - JavaScript does not have characters, only single-length Strings
;; - Strings can be multi-line with no special escape sequence
;; - Strings in JavaScript are immutable
;;   - this allows for fast comparison
;; - the clojure.string namespace has many useful functions for operating on Strings
;;

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Write some simple strings below: fav-pizza-topping, fav-ice-cream, fav-band
;;


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Write a few famous Haikus as multi-line strings below:
;;
;; the-old-pond:
;; An old silent pond
;; A frog jumps into the pond
;; Splash! Silence again.
;;
;; another-year:
;; another year is gone
;; a traveler's shade on my head
;; straw sandals at my feet


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Let's use a few simple String functions
;;

(str/reverse "abc") ; => "cba"
(count "xyz")       ; => 3
(str/blank? "")     ; => true
(str/blank? "candy bar") ; => false
(str/capitalize "texas") ; => "Texas"
(str/upper-case "xyz")   ; => "XYZ"
(str/ends-with? "banana" "ana") ; => true

(def samantha "samantha")

;; Define num-letters-in-samantha using count

;; Define reverse-samantha using clojure.string/reverse

;; Define proper-samantha using clojure.string/capitalize

;; Define loud-samantha using clojure.string/upper-case

;; Define tha-suffix? using clojure.string/ends-with?
