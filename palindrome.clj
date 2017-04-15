; (use '[clojure.string :only (split triml)])



; Recursive solution ---------------------------------------

(defn opposite [characters n]
  (characters (- (- (count characters) 1) n)))

(defn is-pal-recur [phrase]
  (let [characters (vec phrase)]
    (loop [n 0 c (characters 0) cx (opposite characters n)]
      (if-not (= c cx)
        false
        (if (>= n (/ (count characters) 2))
          true
          (recur (inc n) (characters n) (opposite characters n)))))))


; Map / filter solution ------------------------------------

(defn opposite-character [characters i] (characters (- (- (count characters) i) 1)))

(defn opposite-pairs [characters]
  (fn [i] (vector (characters i) (opposite-character characters i))))

(defn any? [c] (empty? c))

(defn not-same-character-in [pair] (not (= (pair 0) (pair 1))))

(defn is-pal [phrase]
  (let [characters (vec phrase)
        total-characters (count characters)
        indices-in-first-half (range 0 (/ total-characters 2))
        characters-at-opposite-indices (map (opposite-pairs characters) indices-in-first-half)]
    (any? (filter not-same-character-in characters-at-opposite-indices))))

(println "goog" (is-pal "goog"))
(println "foog" (is-pal "foog"))
(println "popop" (is-pal "popop"))
(println "pogrop" (is-pal "pogrop"))
