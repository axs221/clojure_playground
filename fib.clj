(defn fib [n]
  (loop [i 0 j 1 nums []]
    (if (>= i n)
      nums
      (recur j (+ i j) (conj nums j)))))

(println (fib 5000))
