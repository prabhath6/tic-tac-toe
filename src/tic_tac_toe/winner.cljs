(ns tic-tac-toe.winner)

(defn calculate-winner [current-board lines]
  (let [[a b c] (first lines)]
    (cond
      (<= (count lines) 0) nil
      (and
       (== (nth current-board a)
           (nth current-board b)
           (nth current-board c))
       (not (nil? (nth current-board a))))
      (nth current-board a)
      :else (recur current-board (rest lines)))))
