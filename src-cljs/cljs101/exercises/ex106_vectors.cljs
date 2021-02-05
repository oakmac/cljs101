(ns cljs101.exercises.ex106-vectors
  (:require
    [clojure.string :as str]))

(declare my-friends my-enemies
         first-fruit second-fruit third-fruit unknown-fruit
         lunch-line2 lunch-line3 first-eater num-hungry-students
         grocery-list favorite-numbers toys-collection updated-grocery-list)

;;
;; Vectors are numerically-indexed lists of things
;; - like Arrays in other languages
;; - indexes start at 0 (like almost all languages)
;; - Vectors may contain items of any type
;;   - in other words: all of the items inside a Vector do not have to be of the same type
;;
;; Vectors are implemented as Persistent Data Structures in ClojureScript
;; - you can compare two Vectors to see if they are equal
;; - "changing" a Vector to create a new one is a very fast operation due to structural sharing
;;   - example: the subvec function has O(1) performance
;;
;; Vectors can be made using literal syntax with []
;; (we have already seen some of these in the Maps exercise)
;;
;; Some example Vectors:

(def people ["Jimmy" "Sally" "Roger"]) ;; => three Strings

(def points [{:x 5 :y 8} {:x 6 :y 9} {:x 7 :y 10}]) ;; => three Maps

;; this Vector contains two Strings, a number, a Map, and the boolean true
(def mixed-items
  ["Jimmy"
   45
   {:x 5, :y 8}
   true
   "Roger"])

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Define a Vector "my-friends" with a few of your friend's names as Strings


;; Define a second Vector "my-enemies" as an empty Vector
;; (Clojure programmers don't have enemies, only friends <3)


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; There are multiple ways to retrieve items from a Vector.

(def fruits ["apple" "banana" "cherry"])

(nth fruits 1) ;; => "banana"
(get fruits 1) ;; => "banana"

;; A Vector may be used as a function to retrieve items from itself!
(fruits 1) ;; => "banana"

;; Optionally provide a default value if the index does not exist:
(nth fruits 54 "not found!") ;; => "not found!"
(get fruits 54 "not found!") ;; => "not found!"
(fruits 54 "not found!") ;; => "not found!"

;; Be careful accessing a Vector if you are unsure of the index:
; (nth fruits 54) ;; => vector-index-out-of-bounds runtime error

;; Define first-fruit, second-fruit, third-fruit, unknown-fruit here using different
;; Vector access functions. For unknown-fruit, use an invalid index with the default
;; String "fruit not found!"


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Adding items to a Vector

(def primes [2 3 5 7])

;; the conj function adds elements at the end of a Vector
;; note that conj does not "change" the original Vector, it returns a new one
;; this is a fast operation, even for very large Vectors
(def more-primes (conj primes 11)) ;; => [2 3 5 7 11]
(def even-more-primes (conj primes 11 13 17)) ;; => [2 3 5 7 11 13 17]

;; you may also use assoc on Vectors
(def incorrect-primes1 (assoc primes 0 24)) ;; => [24 3 5 7]
(def incorrect-primes2 (assoc primes 1 24)) ;; => [2 24 5 7]

;; you may assoc at the end of a Vector:
(def correct-primes (assoc primes 4 11)) ;; => [2 3 5 7 11]

;; but like nth above, be careful if you assoc with an index that is out of range
; (assoc primes 71 "boo!") ;; => runtime error - index out of bounds

;; equality works for Vectors:
(= more-primes correct-primes) ;; => true

(def lunch-line ["Suzie" "Billy" "Jonny"])

;; Define lunch-line2 by adding Sally to the end of the line

;; Define lunch-line3 by adding Ethan behind Sally

;; Define first-eater by who is first in the lunch line

;; How many students are waiting in the lunch line after Ethan joins?
;; Define num-hungry-students
;; Hint: the count function works on Vectors


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Selecting part of a Vector

;; subvec returns part of a Vector from start (inclusive) to end (exclusive)
;; (subvec your-vector start-idx end-idx)
(subvec [:a :b :c :d :e :f] 0 1) ;; => [:a]
(subvec [:a :b :c :d :e :f] 1 4) ;; => [:b :c :d]

;; without a third argument, subvec selects to the end of the Vector:
(subvec [:a :b :c :d :e :f] 2) ;; => [:c :d :e :f]

;; This operation is very fast even for large Vectors due to the structural sharing
;; used in Persistent Data Structures.

(def combined-items
  [3 76 81 2
   "chocolate" "salt" "milk" "onions" "apples"
   {:type "spaceship", :color "silver"}
   {:type "car", :color "blue"}
   {:type "teddy bear", :name "Brown Bear"}])

;; All of my lists got combined together!
;; Thankfully the items are still in the correct order.
;; Define grocery-list, favorite-numbers, and toys-collection below using subvec


;; Oh! Looks like I already have onions.
;; Can you replace "onions" with "carrots" on my updated-grocery-list please?
;; Hint: use assoc


;; Thank you 🙏
