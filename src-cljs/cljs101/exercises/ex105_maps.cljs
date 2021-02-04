(ns cljs101.exercises.ex105-maps
  (:require
    [clojure.string :as str]))

(declare me my-friend
         board-with-pawn black-will-draw white-will-win)

;;
;; The ubiquitious Hash Table data structure is found in almost all programming languages:
;;   - JavaScript Object
;;   - Python Dictionary
;;   - Ruby Hash
;;   - etc
;;
;; - In ClojureScript we have Maps. Maps are used everywhere in Clojure programs
;;   and are the backbone data structure for most programs.
;;
;; - Maps in ClojureScript are implemented as fully Persistent Data Structures (PDS)
;;   - this gives them different runtime properties than you might assume
;;   - roughly: slower to write, faster to read
;;   - notably: equality comparison is near-instant (even for very large Maps!)
;;   - making a small change to a large Map is a fast operation (shallow copy)
;;

;; Maps can be made using literal syntax with {}
;; (we have already seen some of these in the Keywords exercise)

(def an-empty-map {})

(def some-point {:x 10, :y 12})

(def course-instructor
  {:fname "Chris"
   :lname "Oakman"
   :cool-factor 1000000})

;; In ClojureScript, May keys can be any value. They are not limited to just Keywords.

(def wild-map
  {"fruit" "banana" ;; String key
   7 "seven"        ;; Number key
   {:x 3, :y 2} [7 8 9] ;; Map as a key
   :username "user7892" ;; Keyword as a key
   [25, 12] "rocket"})  ;; Vector as a key

(= (get wild-map [25, 12]) "rocket") ;; --> true
(= (get wild-map 7) "seven") ;; --> true
(= (get wild-map {:x 4, :y 2}) [7 8 9]) ;; --> true

;; Maps can also be created with the (hash-map) function
;; NOTE 1: the literal syntax using {} is more common
;; NOTE 2: notice the even number of arguments to hash-map; this makes sense as a Map consists of key -> value pairs

(def wild-map2
  (hash-map "fruit" "banana"
            7 "seven"
            {:x 3, :y 2} [7 8 9]
            :username "user7892"
            [25, 12] "rocket"))

;; Maps can be tested for equality
(= wild-map wild-map2) ;; --> true
(= wild-map course-instructor) ;; --> false

;; "change" a map using assoc (associate)
(def another-point (assoc some-point :x 5))

(= another-point {:x 5, :y 12}) ;; --> true

;; the opposite of assoc is dissoc (dissociate)
(def abc-map {:a "a", :b "b", :c "c"})
(def ab-map  {:a "a", :b "b"})

(= ab-map (dissoc abc-map :c)) ;; --> true

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Define a Map "me" that has the following keys => value type
;; - :fname => String
;; - :lname => String
;; - :cool-factor => Number

;; Define a second Map "my-friend" with similar keys



;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; The following Map represents a Chessboard with two Kings on it using algebraic
;; notation to represent the squares.

(def only-kings-board
  {"b5" "wK"
   "c7" "bK"})

;; Define board-with-pawn using only-kings-board and put a White Pawn ("wP") on the b4 square

;; If it is Black's turn to move on board-with-pawn, he can surely draw the game
;; by keeping opposition from the White King!
;; NOTE: this is chess nerd terminology - you do not need to understand opposition
;;       to do this exercise

;; Define black-will-draw from board-with-pawn with the Black King on b7

;; Define white-will-win from board-with-pawn with the White King on a6
