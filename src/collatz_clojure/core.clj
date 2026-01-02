(ns collatz-clojure.core
  (:require [com.hypirion.clj-xchart :as c])
  (:gen-class))


(defn collatz-length-brian [n]
   (loop [m n
          l 0]
      (cond
         (<= m 1) (inc l)
         (even? m) (recur (/ m 2) (inc l))
         :else     (recur (inc (* m 3))  (inc l)))))



(def xs  (range 1 1000000))
(def ys  (mapv collatz-length-brian xs))



(def chart (c/xy-chart {"Collatz Fun in Clojure"  {:x xs :y ys}} {:legend {:visible? false} :x-axis {:title "Value"} :y-axis {:title "Length"} :title "Collatz Length" :render-style :scatter}))

(defn -main
  [& args]
  (c/view chart)
  )
