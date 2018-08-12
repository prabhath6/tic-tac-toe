(ns tic-tac-toe.square
  (:require [reagent.core :as r]
            [tic-tac-toe.state :as st]))

(defn handle-on-click [index]
    (swap! st/board-state #(assoc % index "X")))

(defn square [square-pos]
  (let [square-state (r/atom "")
        square-value (nth @st/board-state square-pos)]
    (fn []
      [:input {:class "square"
               :type "button"
               :value @square-state
               :on-click (fn []
                           (reset! square-state "X")
                           (handle-on-click square-pos)
                           (prn @st/board-state))}])))
