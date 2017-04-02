(def users { 
  "frank" { :age 22 :gender "male" :password "frankspassword" :number-of-pets 1}
  "suzy" { :age 45 :gender "female" :password "suzyspassword" :number-of-pets 3 }})


(defn check-login [username password]
  (let [actual-password ((users username) :password)]
    (= password actual-password)))

(println (check-login "frank" "frankspassword"))
(println (check-login "frank" "wrongpassword"))

(defn average-pets []
  (/ 
    (apply + (map :number-of-pets (vals users)))
    (count users)))

(println (average-pets))
