(ns calculator.test.util
  (:use clojure.test
  	calculator.util))

(deftest test_util
	(testing "util functions"
		(is (formulaPrinter "+" 2 5) "2 + 5 = "
		)
	))	