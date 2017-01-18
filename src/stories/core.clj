(ns stories.core
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [html5]])
  (:gen-class))

(defn index []
  (html5
   [:head
    [:title "Namelos."]]
   [:body
    [:h1 "Hello world!"]]))

(defroutes routes
  (GET "/" [] (index)))

(defn -main []
  (run-jetty #'routes {:port 3000 :join? false}))
