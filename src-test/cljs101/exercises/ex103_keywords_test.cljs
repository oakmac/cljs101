(ns cljs101.exercises.ex103-keywords-test
  (:require
    [clojure.string :as str]
    [cljs.test :refer [deftest is]]
    [cljs101.exercises.ex103-keywords
      :refer [apple banana cherry
              z jane-user-id user-display-name
              jane-username-kwd john-password jane-password is-a-sen?]]))

(deftest simple-keywords-test
  (is (= apple :apple))
  (is (= banana :banana))
  (is (= cherry :my-app.fruits/cherry)))


(def another-point {:x 2, :y 5, :z 22})

(def user-from-the-db
  {:user/id 33781
   :user/name "John Doe"
   :user/username "john_doe_45"
   :user/email "johnd@example.org"
   :user/createdAt "2016-10-30 08:12:34"})

(def another-user
  {:user/id 33782
   :user/name "Jane Doe"
   :user/username "jane_doe_46"
   :user/email "janed@example.org"
   :user/createdAt "2016-10-30 08:14:51"})

(deftest keywords-and-maps-test
  (is (= z (:z another-point)))
  (is (= jane-user-id (:user/id another-user)))
  (is (= user-display-name (str (:user/name another-user)
                                " (" (:user/email another-user) ")"))))

(def everyones-passwords
  {:user_33781 "password123", :user_33782 "password789"})

(def best-chess-player :Magnus_Carlsen)

(deftest keywords-strings-test
  (is (= jane-username-kwd (keyword (:user/username another-user))))
  (is (= john-password (everyones-passwords (keyword (str "user_" (:user/id user-from-the-db))))))
  (is (= jane-password (everyones-passwords (keyword (str "user_" (:user/id another-user))))))
  (is (= is-a-sen? (str/ends-with? (name best-chess-player) "sen"))))
