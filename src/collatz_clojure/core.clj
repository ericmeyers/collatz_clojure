(ns collatz-clojure.core
    (:require [incanter.core :as inccore :refer [view]])
    (:require [incanter.charts :as inccharts :refer [scatter-plot]])
    (:gen-class))


(defn collatz-length-brian [n]
   (loop [m n
          l 0]
      (cond
         (<= m 1) (inc l)
         (even? m) (recur (/ m 2) (inc l))
         :else     (recur (inc (* m 3))  (inc l)))))



(def xs  (range 1 100000))
(def ys  (mapv collatz-length-brian xs))

(defn doit []
  (inccore/view (inccharts/scatter-plot xs ys :title "Collatz Fun in Clojure" :x-label "Value" :y-label "Length")))

;;(def chart (c/xy-chart {"Collatz Fun in Clojure"  {:x xs :y ys}} {:legend {:visible? false} :x-axis {:title "Value"} :y-axis {:title "Length"} :title "Collatz Length" :render-style :scatter}))

(defn -main
  [& args]
  (doit)
  )
