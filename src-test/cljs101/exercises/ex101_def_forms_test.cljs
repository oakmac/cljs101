(ns cljs101.exercises.ex101-def-forms-test
  (:require
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex101-def-forms :refer [my-name your-name my-job my-age your-age]]))

(deftest def-forms-test
  (is (string? my-name))
  (is (string? your-name))
  (is (string? my-job))
  (is (number? my-age))
  (is (number? your-age)))
