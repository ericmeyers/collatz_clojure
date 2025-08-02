(ns collatz-clojure.core
  (:require [oz.core :as oz])
  (:gen-class))


(defn collatz-length-brian [n]
   (loop [m n
          l 0]
      (cond
         (<= m 1) (inc l)
         (even? m) (recur (/ m 2) (inc l))
         :else     (recur (inc (* m 3))  (inc l)))))



(def xs (range 1 1000000))
(def ys (map collatz-length-brian xs))

(defn make-data [xs ys]
   (map (fn [x y] {:x x :y y}) xs ys))

(def myplot
  {
   :title "Collatz Fun in Clojure",
   :data {:values (make-data xs ys)}
   :encoding {:x {:field "x" :type "quantitative" }
              :y {:field "y" :type "quantitative" }
              :color {:field "item" :type "nominal" :legend nil}}
   :selection {:brush {:type "interval" :bind "scales" }}
   :mark "point"
   :width  800
   :height 600
  })



(defn -main
  [& args]
  (oz/start-server!)
  (oz/view! myplot))
