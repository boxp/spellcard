(ns {{name}}.app.my-webapp.endpoint
  (:require [com.stuartsierra.component :as component]
            [compojure.core :refer [defroutes context GET POST routes]]
            [compojure.route :as route]
            [ring.adapter.jetty :as server]
            [ring.middleware.json :refer [wrap-json-params
                                          wrap-json-response
                                          wrap-json-body]]
            [{{name}}.app.my-webapp.handler :as handler]))

(defn main-routes
  [{:keys [my-webapp-handler] :as comp}]
  (routes
    (GET "/" [req] (handler/index my-webapp-handler))
    (route/not-found "<h1>404 page not found</h1>")))

(defn app
  [comp]
  (-> (main-routes comp)
      (wrap-json-body {:keywords? true :bigdecimals? true})))

(defrecord MyWebappEndpointComponent [port server my-webapp-handler]
  component/Lifecycle
  (start [this]
    (println ";; Starting MyWebappEndpointComponent")
    (-> this
        (assoc :server (server/run-jetty (app this) {:port port :join? false}))))
  (stop [this]
    (println ";; Stopping MyWebappEndpointComponent")
    (.stop (:server this))
    (-> this
        (dissoc :server))))

(defn my-webapp-endpoint-component
  [port]
  (map->MyWebappEndpointComponent {:port port}))
