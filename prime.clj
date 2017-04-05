(defn prime? [num]
  (let [divisors (range 2 (inc (int (Math/sqrt num))))
        remainders (filter (fn [x] (= (rem num x) 0)) divisors)]
    (= (count remainders) 0)))

(println (prime? 1) 1)
(println (prime? 5) 5)
(println (prime? 8) 8)
(println (prime? 13) 13)
(println (prime? 18) 18)
(println (prime? 21) 21)
(println (prime? 37) 37)

(defn prime-pairs [num]
  (let [nums (range 2 (inc num))]
    (for [x nums y nums :when (prime? (+ x y))]
      (list x y))))


(println (prime-pairs 5))
