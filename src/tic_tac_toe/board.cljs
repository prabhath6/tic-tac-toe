(ns tic-tac-toe.board
  (:require [tic-tac-toe.square :as s]
            [tic-tac-toe.state :as st]))

(defn get-button [move-num]
  [:input {:type "button"
           :value (str "Go to: " move-num)
           :on-click #(prn (str "clicked " move-num))}])

(defn get-history []
  [:div {:class "game-info"}
    [:ol
    (for [h @st/history]
      ^{:key (first h)} [:li [get-button (first h)]])]])

(defn board [current-board]
  (fn []
  [:div
   (if (empty? @st/isWinner)
     [:div {:class "status"} (str @st/status (s/get-turn-val @st/isNext))]
     [:div {:class "status"
            :style {:color "green"}} (str @st/isWinner " is the winner.")])
   [:div {:class "board-row"}
    [s/square 0 ]
    [s/square 1 ]
    [s/square 2 ]]
   [:div {:class "board-row"}
    [s/square 3 ]
    [s/square 4 ]
    [s/square 5 ]]
   [:div {:class "board-row"}
    [s/square 6 ]
    [s/square 7 ]
    [s/square 8 ]]
   [get-history]]))
