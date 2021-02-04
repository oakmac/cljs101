(ns cljs101.exercises.ex105-maps-test
  (:require
    [clojure.string :as str]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex105-maps
      :refer [me my-friend
              board-with-pawn black-will-draw white-will-win]]))

(defn person-map? [m]
  (and (map? m)
       (not (str/blank? (:fname m)))
       (not (str/blank? (:lname m)))
       (number? (:cool-factor m))))

(deftest simple-map-test
  (is (person-map? me))
  (is (person-map? my-friend)))

(def pawn-board
  {"b4" "wP"
   "b5" "wK"
   "c7" "bK"})

(def black-draw
  {"b4" "wP"
   "b5" "wK"
   "b7" "bK"})

(def white-win
  {"b4" "wP"
   "a6" "wK"
   "c7" "bK"})

(deftest chessboards-test
  (is (= board-with-pawn pawn-board))
  (is (= black-will-draw black-draw))
  (is (= white-will-win white-win)))
