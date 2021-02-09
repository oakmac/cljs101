(ns cljs101.exercises.ex107-sets-test
  (:require
    [clojure.set :as set]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex107-sets
      :refer [katie-is-a-student? samantha-is-a-student?
              students-with-betty students-without-jimmy
              everyones-favorites anyone-like-knitting? rachel-and-kristen-activities
              liked-by-everyone mark-indoor-activities jonah-favorites jonah-is-outdoorsy?]]))

;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; NOTE FOR STUDENTS: this file is for the test suite
;; Please do your work in src-cljs/cljs101/exercises/ex107_sets.cljs
;; Thank you 😊
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
;; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


(def students #{"Jimmy" "Billy" "Sally" "Katie"})

(deftest set-get-test
  (is (= katie-is-a-student? (contains? students "Katie")))
  (is (= samantha-is-a-student? (contains? students "Samantha"))))


(deftest change-set-test
  (is (= students-with-betty (conj students "Betty")))
  (is (= students-without-jimmy (disj students "Jimmy"))))


(def rachel-favorites #{"Biking" "Cooking" "Yoga" "Movies" "TV"})
(def kristen-favorites #{"Reading" "Yoga" "Cooking"})
(def mark-favorites #{"Cooking" "Reading" "TV" "Camping"})
(def outdoor-activities #{"Biking" "Camping" "Fishing"})

(deftest activities-test
  (is (= everyones-favorites (set/union rachel-favorites kristen-favorites mark-favorites)))
  (is (= anyone-like-knitting? (contains? everyones-favorites "Knitting")))
  (is (= rachel-and-kristen-activities (set/intersection rachel-favorites kristen-favorites)))
  (is (= liked-by-everyone (set/intersection rachel-favorites kristen-favorites mark-favorites)))
  (is (= mark-indoor-activities (set/difference mark-favorites outdoor-activities)))
  (is (= jonah-favorites #{"Biking" "Fishing"}))
  (is (= jonah-is-outdoorsy? (set/subset? jonah-favorites outdoor-activities))))
