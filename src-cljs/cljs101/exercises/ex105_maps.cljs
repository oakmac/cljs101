(ns cljs101.exercises.ex105-maps)

(declare me my-friend
         board-with-pawn black-will-draw white-will-win
         game-state2 game-state3 game-state4
         suzie-options current-options new-search-options)

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
(= wild-map wild-map2)         ;; --> true
(= wild-map course-instructor) ;; --> false

;; "change" a map using assoc (associate)
(def another-point (assoc some-point :x 5))

(= another-point {:x 5, :y 12}) ;; --> true

;; the opposite of assoc is dissoc (dissociate)
(def abc-map {:a "a", :b "b", :c "c"})
(def ab-map  {:a "a", :b "b"})

(= ab-map (dissoc abc-map :c))      ;; --> true
(= {:a "a"} (dissoc abc-map :b :c)) ;; --> true

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


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Let's model a 2d space shooter game using a Map.
;; The keys of the Map will be [x, y] points on the game board and the values
;; will be a Map of what is located at that position.

(def game-state1
  {[2 3] {:type "spaceship"
          :player "player1"
          :color "blue"}
   [8 12] {:type "spaceship"
           :player "player2"
           :color "red"}
   [4 7] {:type "power-up"
          :ability "speed-boost"
          :color "orange"}})

;; Player1 fires a missile at Player2!
;; Define game-state2 with :type = "missle", :velocity = 1.5, :player = "player1" at point [3, 4]
;; Missles are always black and do not need a :color value


;; Player1 has disconnected!
;; Define game-state3 by removing all items related to player1


;; Player2 takes a move towards the Power Up.
;; Move player2 to coordinates [7 11] for game-state4


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; The merge function is a useful way to combine Maps together.
;; You can merge together multiple Maps with similar or different keys and they
;; will be combined into a single Map.
;; If the Maps being combined have the same keys, the last Map passed to merge will "win"
;;
;; Example:
(def m1 {:a "a", :b "b"})
(def m2 {:b "BBBB"})
(def m3 (merge m1 m2)) ;; --> {:a "a", :b "BBBB"} (m2's :b key "wins")
(def m4 (merge m2 m1)) ;; --> {:a "a", :b "b"}    (m1's :b key "wins")

(def m5 {:b "bee!" :c "cee!"})
(def m6 (merge m1 m2 m5)) ;; --> {:a "a", :b "bee!", :c "cee!"}
(def m7 (merge m1 m5 m2 {:a "aaa!"})) ;; --> {:a "aaa!", :b "BBBB", :c "cee!"}


;; Here are the default options for a Dashboard page of an application:
(def default-options
  {:dashboard/dark-mode? false
   :dashboard/left-menu-hidden? false
   :dashboard/num-rows 50
   :dashboard/page-num 1
   :dashboard/save-modal-showing? false
   :dashboard/search-txt ""
   :dashboard/sort-by-column "createdAt"
   :dashboard/sort-direction "asc"})

;; When a user makes a change on their Dashboard page we persist their settings
;; so the page is the same the next time they visit.

;; Suzie likes dark mode, was searching for "bananas" and had her table sorted
;; by the "company" field in descending ("desc") order.
;; Define a Map suzie-options with these choices for Suzie.


;; Define current-options as a combination of default-options and suzie-options
;; using merge.


;; Suzie changes her search text from "bananas" to "cherry"
;; Define new-search-options using curent-options and the merge function
