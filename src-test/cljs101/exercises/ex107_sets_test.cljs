(ns cljs101.exercises.ex107-sets-test
  (:require
    [clojure.set :as set]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex107-sets
      :refer [katie-is-a-student? samantha-is-a-student?
              students-with-betty students-without-jimmy]]))

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
