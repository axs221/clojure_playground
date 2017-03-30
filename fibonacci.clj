(defn next-items [item-1 item-2]
  (let [item-3 (+ item-1 item-2)]
    (lazy-seq
      (cons item-3
        (next-items item-2 item-3)))))

(defn fibonacci [t1 t2]
  (concat [t1 t2]
    (next-items t1 t2)))

(println (take 15 (fibonacci 0 1)))

(println (lazy-seq [1 2 3 5 9]))

(defn timesTwo [number] (* 2 number))
(println (map timesTwo [1 2 3 5 9]))
