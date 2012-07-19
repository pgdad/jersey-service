(ns jerseyservice.JerseyServiceServlet
  (:import (jerseyzoo.JerseyZooServletContainer))
  (:require [jerseyzoo.JerseyZooServletContainer :as Container])
  (:require [clj-zoo.serverSession :as ssession])
  (:import (javax.ws.rs GET Path Produces))
  (:gen-class :extends jerseyzoo.JerseyZooServletContainer
              ;; packages keepers region service major minor micro url
              :constructors {[String String String String
                              String String String String String String] [String String]}
              :state state
              :init init-state
              :post-init post)
  )

(defn -init-state
  [packages keepers region service major minor micro port uri url]
  [[packages keepers] (ref {:region region :service service
                            :major major :minor minor :micro micro :url url})])

(defn -post
  [this packages keepers region service major minor micro port uri url]
  (dosync
   (let [state (. this state)
         l (ssession/login keepers region)
         reg (ssession/registerService l false service
                                       (read-string major)
                                       (read-string minor)
                                       (read-string micro)
                                       (read-string port)
                                       "/"  url)]
     (alter state assoc :registration reg))))
