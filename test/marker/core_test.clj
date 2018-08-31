(ns marker.core-test
  (:require [clojure.test :refer :all]
            [marker.core :as marker]))

(deftest test-colors
  (testing "All colors exist."
    (is marker/colors
        {:black ";30m"
         :red ";31m"
         :green ";32m"
         :yellow ";33m"
         :blue ";34m"
         :purple ";35m"
         :cyan ";36m"
         :color-off "m"})))

(deftest test-starter
  (testing "Starter has not changed."
    (is (= marker/starter "\033[0"))))

(deftest test-get-preset
  (testing "Should return blue with starter from keyword."
    (let [blue (marker/get-preset :blue)]
      (is (= blue "\033[0;34m"))))

  (testing "Should return color-off with starter from keyword."
    (let [color-off (marker/get-preset :color-off)]
      (is (= color-off "\033[0m"))))

  (testing "Should return red with starter from string."
    (let [red (marker/get-preset "red")]
      (is (= red "\033[0;31m")))))

(deftest test-apply-color
  (testing "Should return a red string with ending."
    (let [red-result (marker/apply-color :red "Test")]
      (is (= red-result "\033[0;31mTest\033[0m")))))

(deftest test-marker
  (testing "Should return an anonymous function."
    (let [marker-fn (marker/marker :red)]
      (function? marker-fn)))

  (testing "Should return a green string with ending, currying."
    (let [green (marker/marker :green)
          green-result (green "Test")]
      (is (= green-result "\033[0;32mTest\033[0m"))))

  (testing "Should return a green string with ending, non currying."
    (let [green-result (marker/marker :green "Test")]
      (is (= green-result "\033[0;32mTest\033[0m")))))
