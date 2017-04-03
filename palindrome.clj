; (use '[clojure.string :only (split triml)])
(defn opposite [characters n]
  (characters (- (- (count characters) 1) n)))

(defn is-pal [phrase]
  (let [characters (vec phrase)]
    (loop [n 0 c (characters 0) cx (opposite characters n)]
      (if-not (= c cx)
        false
        (if (>= n (/ (count characters) 2))
          true
          (recur (inc n) (characters n) (opposite characters n)))))))

(println "goog" (is-pal "goog"))
(println "foog" (is-pal "foog"))
(println "popop" (is-pal "popop"))
(println "pogrop" (is-pal "pogrop"))
