(ns chiklis.content
  (:require [chiklis.mutant :refer [observe-body]]
            [chiklis.chiklis :refer [chiklisify]])
  (:require-macros [dommy.macros :refer [sel1]]))

(defn init []
  (chiklisify (sel1 :body))
  (observe-body))


