(defproject cljs-http "0.0.6-SNAPSHOT"
  :description "A ClojureScript HTTP library."
  :url "http://github.com/r0man/cljs-http"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1853"]]
  :profiles {:dev {:dependencies [[com.cemerick/clojurescript.test "0.0.4"]]
                   :plugins [[com.cemerick/austin "0.1.0"]]}}
  :plugins [[lein-cljsbuild "0.3.0"]]
  :hooks [leiningen.cljsbuild]
  :min-lein-version "2.0.0"
  :cljsbuild {:builds [{:compiler {:output-to "target/cljs-http-debug.js"}
                        :source-paths ["src"]}
                       {:compiler {:output-to "target/cljs-http.js"
                                   :optimizations :advanced
                                   :pretty-print false}
                        :source-paths ["src"]}
                       {:compiler {:output-to "target/cljs-http-test.js"
                                   :optimizations :advanced
                                   :pretty-print true}
                        :source-paths ["test"]}]
              :repl-listen-port 9000
              :repl-launch-commands
              {"chromium" ["chromium" "http://localhost:9000/"]
               "firefox" ["firefox" "http://localhost:9000/"]}
              :test-commands {"unit-tests" ["runners/phantomjs.js" "target/cljs-http-test.js"]}})
