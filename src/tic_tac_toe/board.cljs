(ns tic-tac-toe.board
  (:require [tic-tac-toe.square :as s]
            [tic-tac-toe.state :as st]))

(defn board []
  [:div
   [:div {:class "status"} @st/status]
   [:div {:class "board-row"}
    [s/square 0]
    [s/square 1]
    [s/square 2]]
   [:div {:class "board-row"}
    [s/square 3]
    [s/square 4]
    [s/square 5]]
   [:div {:class "board-row"}
    [s/square 6]
    [s/square 7]
    [s/square 8]]])
