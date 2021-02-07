(ns cljs101.exercises.ex107-sets
  (:require
    [clojure.set :as set]))

(declare katie-is-a-student? samantha-is-a-student?
         students-with-betty students-without-jimmy)

;;
;; Sets are collections of unique values, just like in Math class.
;; - Sets can contain items of any type: Strings, Numbers, Maps, Vectors, other Sets, etc
;;
;; Sets can be made using literal syntax #{}
;;
;; Some example Sets:

(def cardinal-directions #{:north :south :west :east})

(def bingo-numbers #{23 14 2 28 46 16})

(def set-with-mixed-values
  #{"Amanda"
    49
    "amanda"
    {:x 25, :y 88}
    false
    [:a :b :c]
    #{}})

;; if you try to create a literal Set with duplicate values you will get a compiler error
; (def illegal-set #{"a" "a" "b"}) ; => compiler error: Duplicate key

;; you can create a Set using the set function
(def cardinal-directions2 (set [:south :east :west :north]))

(= cardinal-directions cardinal-directions2) ; => true

;; there is no "order" of items in a Set
(def letters1 #{"a" "b" "c"})
(def letters2 #{"b" "c" "a"})

(= letters1 letters2) ; => true

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Does a Set contain an item?

(def students #{"Jimmy" "Billy" "Sally" "Katie"})

;; there are several ways to tell if an item is in a Set:
(get students "Jimmy") ; => true
(contains? students "Jimmy") ; => true

;; like Vectors and Maps, Sets can be used as a function to check their values:
(students "Jimmy") ; => true
(students "John")  ; => false

;; Define katie-is-a-student? and samantha-is-a-student? by checking the students set


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; "change" a Set

(def some-letters #{"a" "b" "c"})

;; you can "add" an item to a Set using conj
(def more-letters (conj some-letters "d"))

(= more-letters #{"a" "b" "c" "d"}) ; => true

;; if you conj an item into a Set that already contains that item, it does nothing
;; and there is no error
(= some-letters (conj some-letters "b")) ; => true

;; "remove" an item from a Set using disj
(def less-letters (disj some-letters "a"))
(= less-letters #{"b" "c"}) ; => true

;; Define students-with-betty and students-without-jimmy


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Set operations

;; FIXME:
;; https://clojuredocs.org/clojure.set/union
;; https://clojuredocs.org/clojure.set/difference
;; https://clojuredocs.org/clojure.set/intersection
;; https://clojuredocs.org/clojure.set/subset_q
;; https://clojuredocs.org/clojure.set/superset_q
