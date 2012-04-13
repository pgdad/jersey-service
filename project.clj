(defproject jersey-service "1.0.2"
  :description "FIXME: write description"
  :aot [jerseyservice.JerseyServiceServlet]
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clj-zoo "1.0.4"]
                 [jersey-zoo-clj "1.0.0"]]
  :dev-dependencies [[org.eclipse.jetty/jetty-servlet "8.1.2.v20120308"]])
