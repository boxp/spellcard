(ns {{name}}.system
  (:require [com.stuartsierra.component :as component]
            [environ.core :refer [env]]
            [{{name}}.infra.datasource.example :refer [example-datasource-component]]
            [{{name}}.infra.repository.example :refer [example-repository-component]]
            [{{name}}.domain.usecase.example :refer [example-usecase-component]]
            [{{name}}.app.my-webapp.handler :refer [my-webapp-handler-component]]
            [{{name}}.app.my-webapp.endpoint :refer [my-webapp-endpoint-component]])
  (:gen-class))

(defn {{name}}-system
  [{:keys [{{name}}-example-port
           {{name}}-my-webapp-port] :as conf}]
  (component/system-map
    :example-datasource (example-datasource-component {{name}}-example-port)
    :example-repository (component/using
                          (example-repository-component)
                          [:example-datasource])
    :example-usecase (component/using
                       (example-usecase-component)
                       [:example-repository])
    :my-webapp-handler (component/using
                         (my-webapp-handler-component)
                         [:example-usecase])
    :my-webapp-endpoint (component/using
                          (my-webapp-endpoint-component {{name}}-my-webapp-port)
                          [:my-webapp-handler])))

(defn load-config []
  {:{{name}}-example-port (-> (or (env :{{name}}-example-port) "8000") Integer/parseInt)
   :{{name}}-my-webapp-port (-> (or (env :{{name}}-my-webapp-port) "8080") Integer/parseInt)})

(defn -main []
  (component/start
    ({{name}}-system (load-config))))
