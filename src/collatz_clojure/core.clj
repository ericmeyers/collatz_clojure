(ns collatz-clojure.core
  (:require [scicloj.kindly.v4.kind :as kind]
            [scicloj.clay.v2.api :as clay])
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




(def trace1
  {:x xs
   :y ys
   :mode "markers"
   :type "scatter"})

(def lay
  {:title "Collatz Fun in Clojure"})



(defn -main
  [& args]
  (clay/start!)
  (clay/make!  {:single-form '(kind/plotly {:data [trace1] :layout lay}  )})
  )
