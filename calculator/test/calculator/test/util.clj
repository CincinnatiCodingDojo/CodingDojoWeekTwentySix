(ns calculator.test.util
  (:use clojure.test
  	calculator.util))

(deftest test_util
	(testing "util functions"
		(is (formulaPrinter "+" 2 5) "2 + 5 = "
		)
	))

	(deftest test_do_math
		(testing "do math"
			(is (do-math 1 "+" 1) 2)
			(is (do-math 3 "*" 3) 9)
			)
		(testing "do math divide by zero error"
			(is (do-math 1 "/" 0) "undefined")
			)

		)	

; (deftest test_solve_equation
; 	(testing "solve equation"
; 		(is (solve-equation "1 + 1") 2)
; 		)
; 	)

(deftest test_parse_equation
	(testing "parsing equation"
		(is (parse-equation ["1" "+" "1"]) [1 "+" 1])
		)
)