(ns cljs101.exercises.ex103-keywords
  (:require
    [clojure.string :as str]))

(declare apple banana cherry
         z jane-user-id user-display-name
         jane-username-kwd john-password jane-password is-a-sen?)

;;
;; - Keywords are kind of like Strings, but mainly used as static identifiers
;; - Keywords begin with a : or ::
;;   - :foo
;;   - :bar-biz
;;   - :AAA_BBB_CCC
;;   - :logged-in?
;;
;; - Keywords can be namespaced:
;;   - :my-app.fruits/apple
;;   - ::apple <-- the double colon means "use the current namespace"
;;
;; - Keywords are most often used in the context of Maps as keys:
;;

(def some-point {:x 10, :y 12})

(def user-from-the-db
  {:user/id 33781
   :user/name "John Doe"
   :user/username "john_doe_45"
   :user/email "johnd@example.org"
   :user/createdAt "2016-10-30 08:12:34"})

(def course-instructor
  {:fname "Chris"
   :lname "Oakman"
   :cool-factor 1000000})

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Define some Keywords below:
;; apple --> :apple
;; banana --> :banana
;; cherry --> :my-app.fruits/cherry


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Keywords can be used as functions to extract values from Maps:
;; (:x {:x 10, :y 12}) --> 10
;; (:fname course-instructor) --> "Chris"
;; (:z some-point) --> nil (value does not exist)
;;
;; Extract some values from the maps below:
;;

(def another-point {:x 2, :y 5, :z 22})

(def another-user
  {:user/id 33782
   :user/name "Jane Doe"
   :user/username "jane_doe_46"
   :user/email "janed@example.org"
   :user/createdAt "2016-10-30 08:14:51"})

;; Define z from another-point

;; Define jane-user-id from another-user

;; Define user-display-name from another-user
;; users are displayed as: "Some User (some_user22@example.org)"
;; Hint: strings can be concatenated using the str function


;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Keywords can be created from Strings and vice-versa
;;
;; (keyword "abc") --> :abc
;; (name :RockinRobin) --> "RockinRobin"

;; Define jane-username-kwd using the username from another-user above

(def everyones-passwords
  {:user_33781 "password123", :user_33782 "password789"})

;; Define john-password using user-from-the-db and everyones-passwords

;; Define jane-password using another-user and everyones-passwords


(def best-chess-player :Magnus_Carlsen)

;; Define is-a-sen? using best-chess-player and the str/ends-with? function
;; Hint: remember that str/ends-with? only works on Strings, not Keywords
