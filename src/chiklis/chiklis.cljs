(ns chiklis.chiklis
  (:require [clojure.string :as s]
            [khroma.log :as console]))

(def chiklises {(js/RegExp. "chickens" "i") "Chiklises"
                (js/RegExp. "chicken" "i") "Chiklis"})

(defn chiklisize [n] 
  (doseq [[k v] chiklises]
    (set! (.-textContent n) (.replace (.-textContent n) k v))))

(defn- chiklisable? [node]
  (and (= (.-nodeType node) 1) (not (#{"script" "textarea"} (.-nodeName node)))))

(defn chiklisify [n]
  (let [nn (s/lower-case (.-nodeName n))]
    (if (= nn "#text")
      (chiklisize n)
      (when (chiklisable? n)
        (dotimes [i (.-length (.-childNodes n))]
          (chiklisify (.item (.-childNodes n) i) chiklisize))))))


