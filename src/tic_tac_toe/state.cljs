(ns tic-tac-toe.state
  (:require [reagent.core :as r]))

(defonce status (r/atom "Next Player: X"))

;; TODO: Review how use a lazy seq and update it.
(defonce board-state (r/atom [nil nil nil nil nil nil nil nil nil]))
