(println "")
(println "")
(println "")
(println "")
(println "Using standard function...............")

(defn prime? [num]
  (let [divisors (range 2 (inc (int (Math/sqrt num))))
        remainders (filter (fn [x] (= (rem num x) 0)) divisors)]
    (= (count remainders) 0)))

(defn print-prime [x] (println (prime? x) x))

(print-prime 1)
(print-prime 5)
(print-prime 8)
(print-prime 13)
(print-prime 18)
(print-prime 21)
(print-prime 37)


(println "")
(println "Using threading macros, a little better................")
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

(defn print-prime-threading [x] (println (prime? x) x))

(print-prime-threading 1)
(print-prime-threading 5)
(print-prime-threading 8)
(print-prime-threading 13)
(print-prime-threading 18)
(print-prime-threading 21)
(print-prime-threading 37)


(println "")
(println "Using composition, more like English................")

(defn debug [x]
  (println x)
  x)

; Rewritten using composition
(defn any? [fx x] (empty? (filter fx x)))
(defn mod-of [x] (fn [y] (rem x y)))
(defn sqrt [x] (Math/sqrt x))
(defn between-2-and [x] (range 2 x))
(def sqrt-plus-1-of (comp inc int sqrt))

(defn is-divisible-by [num] (comp zero? (mod-of num)))

(defn prime-comp? [num]
  (let [possible-divisors ((comp between-2-and sqrt-plus-1-of) num)]
    (any? (is-divisible-by num) possible-divisors)))

(defn print-prime-comp [x] (println (prime-comp? x) x))

(print-prime-comp 1)
(print-prime-comp 5)
(print-prime-comp 8)
(print-prime-comp 13)
(print-prime-comp 18)
(print-prime-comp 21)
(print-prime-comp 37)
