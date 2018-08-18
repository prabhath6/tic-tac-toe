(ns tic-tac-toe.square
  (:require [reagent.core :as r]
            [tic-tac-toe.state :as st]
            [tic-tac-toe.winner :as w]))

;; ------------------
;; helpers
(defn handle-on-click [index current-board turn-value]
  (let [new-board (assoc current-board index turn-value)]
  (swap! st/history #(assoc % @st/current-key new-board))
  (swap! st/current-key inc)
  (prn current-board)
  (if (not (nil? (w/calculate-winner new-board st/lines)))
    (reset! st/isWinner (w/calculate-winner new-board st/lines)))))

(defn get-turn-val [isNext]
  (if isNext "X" "O"))

;;--------------------
;; Component
(defn square [square-pos current-board]
  (let [square-state (r/atom "")
        ]
    (fn []
      [:input {:class "square"
               :type "button"
               :value @square-state
               :on-click (fn []
                           (let [square-value (nth @st/board-state square-pos)
                                 turn-value (get-turn-val @st/isNext)
                                 is-winner @st/isWinner
                                 current-board @st/current-state]
                             (when-not (or (not (empty? is-winner)) (not (empty? @square-state)))
                               (reset! square-state (get current-board square-pos))
                              (reset! square-state turn-value)
                              (swap! st/isNext #(not %))
                              (handle-on-click square-pos current-board turn-value)
                              (prn @st/board-state))))}])))
