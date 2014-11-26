(ns chiklis.content
  (:require [khroma.log :as console]
            [clojure.string :as s])
  (:require-macros [dommy.macros :refer [sel1]]))

(defn- chiklisable? [node]
  (and (= (.-nodeType node) 1) (not (#{"script" "textarea"} (.-nodeName node)))))

(defn chiklisify [n f]
  (let [nn (s/lower-case (.-nodeName n))]
    (if (= nn "#text")
      (f n)
      (when (chiklisable? n)
        (dotimes [i (.-length (.-childNodes n))]
          (chiklisify (.item (.-childNodes n) i) f))))))


(defn init []
  (chiklisify (sel1 :body) 
              (fn [n] 
                (set! (.-textContent n) (s/replace (.-textContent n) 
                                            #"(?i)chicken" 
                                            "Chiklis")))))


