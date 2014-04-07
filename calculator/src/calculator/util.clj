(ns calculator.util
  (:require [noir.io :as io]
            [markdown.core :as md]))

(defn md->html
  "reads a markdown file from public/md and returns an HTML string"
  [filename]
  (->>
    (io/slurp-resource filename)
    (md/md-to-html-string)))
(defn formulaPrinter [operator number1 number2]
	(clojure.string/join " " [number1 operator number2 "="])
	)

(defn do-math [number1 operation number2]
	(try 
	((resolve (symbol operation)) number1 number2)
	(catch ArithmeticException e "undefined")
	)
  )

(defn parse-equation [equation]
	(let [val (clojure.string/split equation #"/s")] 
		(conj (read-string (first val)) (nth val 1) (read-string (last val)))
	 )
)

; (defn solve-equation [equation]
; 	(do-math (clojure.string/split equation))
; 	)
