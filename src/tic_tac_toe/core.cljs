(ns tic-tac-toe.core
    (:require
     [reagent.core :as r]
     [tic-tac-toe.board :as b]
     [tic-tac-toe.state :as st]))

;; -------------------------
;; Views

(defn home-page []
  [:div {:class "game"}
   [:div {:class "game-board"} [b/board]]
   [:div {:class "game-info"} [:div] [:ol]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
