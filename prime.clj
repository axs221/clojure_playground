; (defn prime? [num]
;   (let [divisors (range 2 (inc (int (Math/sqrt num))))
;         remainders (filter (fn [x] (= (rem num x) 0)) divisors)]
;     (= (count remainders) 0)))

; Rewritten using threading macros
(defn prime? [num]
  (let [divisors (->> num
                      (Math/sqrt)
                      (int)
                      (inc)
                      (range 2))
        remainders (filter (fn [x] (as-> x <>
                                     (rem num <>)
                                     (= <> 0)
                                     )) divisors)]
    (= (count remainders) 0)))

(defn print-prime [x] (println (prime? x) x))

(print-prime 1)
(print-prime 5)
(print-prime 8)
(print-prime 13)
(print-prime 18)
(print-prime 21)
(print-prime 37)

(defn prime-pairs [num]
  (let [nums (range 2 (inc num))]
    (for [x nums y nums :when (prime? (+ x y))]
      (list x y))))


(println (prime-pairs 5))
