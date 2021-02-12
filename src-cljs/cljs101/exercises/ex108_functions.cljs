(ns cljs101.exercises.ex108-functions)

(declare abc)

;;
;; ClojureScript Functions are JavaScript Functions
;;
;; We have already seen how certain ClojureScript values can be used as Functions:
;;   - Keywords, Vectors, Sets, and Maps can be used as Functions to operate on themselves
;;

;; the primary way to define a function in ClojureScript is with defn

(defn add-some-things-together ;; <-- define a Symbol for this function
  "Sum x and y" ;; <-- an optional docstring for your function
  [x y] ;; <-- arguments to the function (function arity)
  (+ x y)) ;; <-- function body (contains expressions)
           ;; Note that there is no "return" statement in ClojureScript.
           ;; The value from the last expression in the Function body will be returned.

;; call our function by putting it as the first item in a List
;; ie: add-some-things-together is in "function position" below
(add-some-things-together 4 5) ; => 9

;; use "defn-" to indicate that this function should be private to the namespace
;; NOTE: private functions are not enforced by the ClojureScript compiler
;; (but they are enforced on JVM Clojure)
(defn- some-private-work
  "this function does something internal to the namespace"
  []
  nil)

;; Anonmyous Functions can be defined using fn
(fn [x y z]
  (+ x y z))

;; Here we are creating an anonymous Function and assigning it to a Symbol using def
;; Under the hood, this is essentially how "defn" works.
(def my-fn
  (fn []
    65))

(my-fn) ; => 65

;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;; Declare some functions



;; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;;
