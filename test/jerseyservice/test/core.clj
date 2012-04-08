(ns jerseyservice.test.core
  (:use [clojure.test])
  (:import (jerseyservice JerseyServiceServlet)
           (org.eclipse.jetty.servlet ServletContextHandler ServletHolder)
           (org.eclipse.jetty.server Server)
           (org.eclipse.jetty.server.handler HandlerCollection ConnectHandler)
           (org.eclipse.jetty.server.nio SelectChannelConnector)
))

(deftest server-in-jetty
  (let [server (Server.)
        connector (SelectChannelConnector.)
        handlers (HandlerCollection.)]
    (. connector setPort 8787)
    (. server addConnector connector)
    (. server setHandler handlers)
    (println "HELLO THERE")
    (let [context (ServletContextHandler. handlers
                                          "/" ServletContextHandler/SESSIONS)
          other (println "THERE2")
          jerseyServlet (ServletHolder.
                         (JerseyServiceServlet. "jersey" "localhost" "PROD" "SI" "DC1"
                                                "SIServiceA" "1" "1" "1" "http://localhost:8787"))
          handler (ConnectHandler.)]
      (. context addServlet jerseyServlet "/*")
      (. handlers addHandler handler)
      (. server start)
      (Thread/sleep (* 60 1000))
      ;; TODO: add meaningful test cases
      (. server stop)
      )))
