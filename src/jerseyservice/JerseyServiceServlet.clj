(ns jerseyservice.JerseyServiceServlet
  (:import (jerseyzoo.JerseyZooServletContainer))
  (:require [jerseyzoo.JerseyZooServletContainer :as Container])
  (:require [clj-zoo.serverSession :as ssession])
  (:import (javax.ws.rs GET Path Produces))
  (:gen-class :extends jerseyzoo.JerseyZooServletContainer
              ;; packages keepers env app region service major minor micro url
              :constructors {[String String String String String String
                              String String String String] [String String]}
              :state state
              :init init-state
              :post-init post)
  )

(defn -init-state
  [packages keepers env app region service major minor micro url]
  [[packages keepers] (ref {:env env :app app :region region :service service
                            :major major :minor minor :micro micro :url url})])

(defn -post
  [this packages keepers env app region service major minor micro url]
  (println "IN POST")
  (dosync
   (let [state (. this state)
         l (ssession/login keepers env app region)
         reg (ssession/registerService l service major minor micro url)]
     (alter state assoc :registration reg))))
