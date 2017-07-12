(ns {{name}}.domain.usecase.example
  (:require [com.stuartsierra.component :as component]
            [{{name}}.infra.repository.example :refer [get-example]]))

(defn get-message
  [{:keys [example-repository] :as comp}]
  (-> (get-example example-repository)
      :message))

(defrecord ExampleUsecaseComponent [example-repository]
  component/Lifecycle
  (start [this]
    (println ";; Starting ExampleUsecaseComponent")
    this)
  (stop [this]
    (println ";; Stopping ExampleUsecaseComponent")
    this))

(defn example-usecase-component
  []
  (map->ExampleUsecaseComponent {}))
