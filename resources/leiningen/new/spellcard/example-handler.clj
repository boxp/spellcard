(ns {{name}}.app.my-webapp.handler
  (:require [com.stuartsierra.component :as component]
            [cheshire.core :refer [generate-string]]
            [{{name}}.domain.usecase.example :as example-usecase]))

(defn get-message
  [{:keys [example-usecase] :as comp}]
  (-> {:message (example-usecase/get-message example-usecase)}
      generate-string))

(defrecord MyWebappHandlerComponent [example-usecase]
  component/Lifecycle
  (start [this]
    (println ";; Starting MyWebappHandlerComponent")
    this)
  (stop [this]
    (println ";; Stopping MyWebappHandlerComponent")
    this))

(defn my-webapp-handler-component
  []
  (map->MyWebappHandlerComponent {}))
