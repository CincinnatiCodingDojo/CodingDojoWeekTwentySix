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

(defn calculate-result-page [number1 operation number2]
	(layout/render "calculator.html" {:content (util/do-math (read-string number1) operation (read-string number2))
		:formula (util/formulaPrinter operation number1 number2)}))

(defn calculate-equation-result-page [equation]
  (layout/render "calculator.html" {:content (util/parse-equation equation)
    :formula equation}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/calculate" [number1 operation number2] (calculate-result-page number1 operation number2))
  (GET "/free-form-calculate" [equation] (calculate-equation-result-page equation))
  (GET "/calculator" [] (calculator-page)))
