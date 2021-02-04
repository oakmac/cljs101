(ns cljs101.exercises.ex105-maps-test
  (:require
    [clojure.string :as str]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex105-maps
      :refer [me my-friend
              board-with-pawn black-will-draw white-will-win
              game-state2 game-state3 game-state4
              suzie-options current-options new-search-options]]))

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


(def state1
  {[2 3] {:type "spaceship"
          :player "player1"
          :color "blue"}
   [8 12] {:type "spaceship"
           :player "player2"
           :color "red"}
   [4 7] {:type "power-up"
          :ability "speed-boost"
          :color "orange"}})

(def state2
  (assoc state1 [3 4] {:type "missile"
                       :velocity 1.5
                       :player "player1"}))

(def state3
  (dissoc state2 [2 3] [3 4]))

(def state4
  (let [p2 (get state3 [8 12])]
    (-> state3
      (dissoc [8 12])
      (assoc [7 11] p2))))

(deftest space-shooter-test
  (is (= game-state2 state2))
  (is (= game-state3 state3))
  (is (= game-state4 state4)))


(def default-options
  {:dashboard/dark-mode? false
   :dashboard/left-menu-hidden? false
   :dashboard/num-rows 50
   :dashboard/page-num 1
   :dashboard/save-modal-showing? false
   :dashboard/search-txt ""
   :dashboard/sort-by-column "createdAt"
   :dashboard/sort-direction "asc"})

(def s-options
  {:dashboard/dark-mode? true
   :dashboard/search-txt "bananas"
   :dashboard/sort-by-column "company"
   :dashboard/sort-direction "desc"})

(deftest merge-test
  (is (= suzie-options s-options))
  (is (= current-options (merge default-options s-options)))
  (is (= new-search-options (merge default-options s-options {:dashboard/search-txt "cherry"}))))
