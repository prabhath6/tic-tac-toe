(ns tic-tac-toe.winner
  (:require [tic-tac-toe.state :as st]))

(defn calculate-winner [lines]
  (let [[a b c] (first lines)]
    (cond
      (<= (count lines) 0) nil
      (and
       (== (nth @st/board-state a) (nth @st/board-state b) (nth @st/board-state c)) (not (nil? (nth @st/board-state a)))) (nth @st/board-state a)
      :else (recur (rest lines)))))
