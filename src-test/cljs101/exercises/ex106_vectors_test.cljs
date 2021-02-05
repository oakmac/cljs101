(ns cljs101.exercises.ex106-vectors-test
  (:require
    [clojure.string :as str]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex106-vectors
      :refer [my-friends my-enemies
              first-fruit second-fruit third-fruit unknown-fruit
              lunch-line2 lunch-line3 first-eater num-hungry-students
              grocery-list favorite-numbers toys-collection updated-grocery-list]]))

(defn friend-name? [n]
  (and (string? n)
       (not (str/blank? n))))

(defn vector-of-non-empty-strings? [v]
  (and (vector? v)
       (every? friend-name? v)))

(deftest simple-vectors-test
  (is (vector-of-non-empty-strings? my-friends))
  (is (= [] my-enemies)))


(def fruits ["apple" "banana" "cherry"])

(deftest vector-access-test
  (is (= first-fruit   (nth fruits 0)))
  (is (= second-fruit  (nth fruits 1)))
  (is (= third-fruit   (nth fruits 2)))
  (is (= unknown-fruit (nth fruits 442 "fruit not found!"))))


(def lunch-line ["Suzie" "Billy" "Jonny"])

(deftest lunch-line-test
  (is (= lunch-line2 (conj lunch-line "Sally")))
  (is (= lunch-line3 (conj lunch-line "Sally" "Ethan")))
  (is (= first-eater (first lunch-line)))
  (is (= num-hungry-students (count (conj lunch-line "Sally" "Ethan")))))


(def combined-items
  [3 76 81 2
   "chocolate" "salt" "milk" "onions" "apples"
   {:type "spaceship", :color "silver"}
   {:type "car", :color "blue"}
   {:type "teddy bear", :name "Brown Bear"}])

(deftest subvec-test
  (is (= grocery-list (subvec combined-items 4 9)))
  (is (= favorite-numbers (subvec combined-items 0 4)))
  (is (= toys-collection (subvec combined-items 9)))
  (is (= updated-grocery-list (assoc (subvec combined-items 4 9) 3 "carrots"))))
