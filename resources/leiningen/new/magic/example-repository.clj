(ns {{name}}.infra.repository.example
  (:require [com.stuartsierra.component :as component]
            [{{name}}.domain.entity.example :refer [map->Example]]))

(defn get-example
  [comp]
  (let [message (some-> comp :example-datasource :conn :message)]
    (map->Example {:message message})))

(defrecord ExampleRepositoryComponent [example-datasource]
  component/Lifecycle
  (start [this]
    (println ";; Starting ExampleRepositoryComponent")
    this)
  (stop [this]
    (println ";; Stopping ExampleRepositoryComponent")
    this))

(defn example-repository-component
  []
  (map->ExampleRepositoryComponent {}))
