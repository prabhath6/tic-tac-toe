(ns tic-tac-toe.square
  (:require [reagent.core :as r]
            [tic-tac-toe.state :as st]
            [tic-tac-toe.winner :as w]))

;; ------------------
;; helpers
(defn handle-on-click [index, turn-value]
    (swap! st/board-state #(assoc % index turn-value)))

(defn get-turn-val [isNext]
  (if isNext "X" "O"))

;;--------------------
;; Component
(defn square [square-pos]
  (let [square-state (r/atom "")]
    (fn []
      [:input {:class "square"
               :type "button"
               :value @square-state
               :on-click (fn []
                           (let [square-value (nth @st/board-state square-pos)
                                 turn-value (get-turn-val @st/isNext)
                                 is-winner @st/isWinner
                                 ]
                             (when-not (or (not (empty? is-winner)) (not (empty? @square-state)))
                              (reset! square-state turn-value)
                              (swap! st/isNext #(not %))
                              (handle-on-click square-pos turn-value)
                              (if (not (nil? (w/calculate-winner st/lines)))
                                (reset! st/isWinner (w/calculate-winner st/lines)))
                              (prn @st/isWinner)
                              (prn @st/board-state))))}])))
