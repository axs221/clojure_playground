(def reg #"\w+")
(def phrase "Hi there pilgrim")
(defn tokenize [r s] (re-seq r s))
(def result (tokenize reg phrase))
(println result)


(defn print-all-things [things]
  (let [total (count things) 
        first-item (first things)]
        ; last-item (last things)]
      
    (defn last-item [my-list] (last my-list))

    (println "first" first-item "last" (last-item things))

    (dorun (map println things))))


(print-all-things ["foo" "bar" "baz"])


(println "------")
(println "------")

(defn find-first [f l]
  (first (filter f l)))

(defn odd [n] (= (mod n 2) 0))

; (println "odd" (odd 2))

; (println (find-first odd [3 8 5]))

(println (filter odd [1 2 3 4 5 6 7 8]))
