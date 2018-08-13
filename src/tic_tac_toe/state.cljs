(ns tic-tac-toe.state
  (:require [reagent.core :as r]))

(defonce status (r/atom "Next Player: "))

;; TODO: Review how use a lazy seq and update it.
(defonce board-state (r/atom [nil nil nil nil nil nil nil nil nil]))

(defonce isNext (r/atom true))

(defonce isWinner (r/atom ""))

(def lines [[0 1 2] [3 4 5] [6 7 8] [0 3 6] [1 4 7] [2 5 8] [0 4 8] [2 4 6]])
