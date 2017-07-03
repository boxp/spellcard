(ns {{name}}.infra.datasource.example
  (:require [com.stuartsierra.component :as component]))

(defn connect
  [comp]
  {:connected? true
   :message "You are connected."})

(defrecord ExampleDatasourceComponent [conn port]
  component/Lifecycle
  (start [this]
    (println ";; Starting ExampleDatasourceComponent")
    (-> this
        (assoc :conn (connect this))))
  (stop [this]
    (println ";; Stopping ExampleDatasourceComponent")
    (-> this
        (dissoc :conn))))

(defn example-datasource-component
  [port]
  (map->ExampleDatasourceComponent
    {:port port}))
