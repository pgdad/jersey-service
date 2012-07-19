(defproject jersey-service "1.0.5"
  :description "FIXME: write description"
  :aot [jerseyservice.JerseyServiceServlet]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-zoo "1.0.11"]
                 [jersey-zoo-clj "1.0.3"]]
  :plugins [[ lein-swank "1.4.4"]]
  :profiles {:dev
             {:dependencies [[org.eclipse.jetty/jetty-servlet "8.1.4.v20120524"]]}})
