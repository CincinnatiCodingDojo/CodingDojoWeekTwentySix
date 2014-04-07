(ns calculator.routes.home
  (:use compojure.core)
  (:require [calculator.views.layout :as layout]
            [calculator.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))


(defn calculator-page []
  (layout/render "calculator.html"))

(defn add-result-page [number1 number2]
	(layout/render "calculator.html" {:content (+ (read-string number1) (read-string number2))
		:formula (util/formulaPrinter "+" number1 number2)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/add" [number1 number2] (add-result-page number1 number2))
  (GET "/calculator" [] (calculator-page)))
