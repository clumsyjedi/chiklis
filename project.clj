(defproject chiklis "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [khroma "0.0.3-SNAPSHOT"]
                 [prismatic/dommy "0.1.2"]]
  :source-paths ["src"]
  :profiles {:dev {:plugins [[com.cemerick/austin "0.1.3"]
                             [lein-cljsbuild "1.0.1"]
                             [lein-resource "0.3.6"]
                             [lein-chromebuild "0.1.0"]]
                   :cljsbuild {:builds {:main
                                        {:source-paths ["src"]
                                         :compiler {:output-to "target/unpacked/chiklis.js"
                                                    :output-dir "target/js"
                                                    :optimizations :whitespace
                                                    :pretty-print true}}}}
                   ;:chromebuild {:resource-paths ["resources/js" "resources/html" "resources/images"]
                   ;              :target-path "target/unpacked"}
                   }
             }) 
