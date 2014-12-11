(ns chiklis.mutant
  (:require [khroma.log :as console]
            [chiklis.chiklis :refer [chiklisify]]))

(declare observe-element)

(defn handle-mutation [mutation]
  (chiklisify (.-target mutation))
  (doseq [child (-> mutation .-target .-childNodes (array-seq 0))]
    (observe-element child)))

(defn handle-mutations [mutations]
  (doseq [m (js->clj mutations)]
    (handle-mutation m)))

(defn observe-element [elem]
  (let [observer (js/MutationObserver. handle-mutations)]
    (.observe observer elem
              (clj->js {:atrributes true :childList true :characterData true}))))

(defn observe-body []
  (observe-element js/document.body))

