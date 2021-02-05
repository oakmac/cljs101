(ns cljs101.exercises.ex102-strings-test
  (:require
    [clojure.string :as str]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex102-strings
      :refer [fav-pizza-topping fav-ice-cream fav-band
              the-old-pond another-year
              num-letters-in-samantha reverse-samantha proper-samantha loud-samantha tha-suffix?]]))

;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; NOTE FOR STUDENTS: this file is for the test suite
;; Please do your work in src-cljs/cljs101/exercises/ex102_strings.cljs
;; Thank you 😊
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

(deftest simple-strings-test
  (is (not (str/blank? fav-pizza-topping)))
  (is (not (str/blank? fav-ice-cream)))
  (is (not (str/blank? fav-band))))


(def haiku1
  "An old silent pond
A frog jumps into the pond
Splash! Silence again.")

(def haiku2
  "another year is gone
a traveler's shade on my head
straw sandals at my feet")

(deftest haiku-test
  (is (= the-old-pond haiku1))
  (is (= another-year haiku2)))


(def s "samantha")
(deftest string-functions-test
  (is (= num-letters-in-samantha (count s)))
  (is (= reverse-samantha (str/reverse s)))
  (is (= proper-samantha (str/capitalize s)))
  (is (= loud-samantha (str/upper-case s)))
  (is (= tha-suffix? (str/ends-with? s "tha"))))
