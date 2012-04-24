(defproject jersey-service "1.0.4"
  :description "FIXME: write description"
  :aot [jerseyservice.JerseyServiceServlet]
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clj-zoo "1.0.6"]
                 [jersey-zoo-clj "1.0.2"]]
  :dev-dependencies [[org.eclipse.jetty/jetty-servlet "8.1.3.v20120416"]])
