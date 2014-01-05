(defproject optimus-jsx "0.1.1"
  :description "React JSX asset loader for Optimus."
  :url "http://github.com/magnars/optimus-jsx"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [optimus "0.13.6"]
                 [clj-v8 "0.1.5"]]
  :profiles {:dev {:dependencies [[midje "1.6.0"]
                                  [test-with-files "0.1.0"]]
                   :plugins [[lein-midje "3.1.3"]
                             [lein-shell "0.3.0"]]
                   :resource-paths ["test/resources"]}}
  :prep-tasks [["shell" "./build-js-sources.sh"]])
