(ns chiklis.mutant
  (:require [khroma.log :as console]))

(defn handle-mutation [mutation]
  (console/log mutation))

(defn handle-mutations [mutations]
  (console/log "mutations" mutations)
  (doseq [m (js->clj mutations)]
    (handle-mutation m)))

(defn observe-page []
  (let [observer (js/MutationObserver. handle-mutations)] 
    (.observe observer js/document.body
              (clj->js {:atrributes true :childList true :characterData true}))
    (console/log "observed")))


