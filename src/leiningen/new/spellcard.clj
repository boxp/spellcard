(ns leiningen.new.spellcard
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "spellcard"))

(defn name-to-screaming-snake
  [kebab]
  (-> (clojure.string/upper-case kebab)
      (clojure.string/replace #"\-" "_")))

(defn spellcard
  "FIXME: write documentation"
  [name project-id cluster-name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :screaming-snake (name-to-screaming-snake name)
              :project-id project-id
              :cluster-name cluster-name}]
    (main/info "Generating fresh 'lein new' spellcard project.")
    (->files data
             ["src/{{sanitized}}/infra/datasource/example.clj" (render "example-datasource.clj" data)]
             ["src/{{sanitized}}/infra/repository/example.clj" (render "example-repository.clj" data)]
             ["src/{{sanitized}}/domain/entity/example.clj" (render "example-entity.clj" data)]
             ["src/{{sanitized}}/domain/usecase/example.clj" (render "example-usecase.clj" data)]
             ["src/{{sanitized}}/app/my_webapp/handler.clj" (render "example-handler.clj" data)]
             ["src/{{sanitized}}/app/my_webapp/endpoint.clj" (render "example-endpoint.clj" data)]
             ["src/{{sanitized}}/system.clj" (render "system.clj" data)]
             ["dev/user.clj" (render "user.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["k8s/deployment.yml" (render "deployment.yml" data)]
             ["k8s/service.yml" (render "service.yml" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["circle.yml" (render "circle.yml" data)]
             ["deploy.sh" (render "deploy.sh" data)]
             [".lein-env" (render ".lein-env" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["README.md" (render "README.md" data)])))
