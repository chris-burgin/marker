(ns marker.core)

(def starter "\033[0")
(def colors
  {:black ";30m"
   :red ";31m"
   :green ";32m"
   :yellow ";33m"
   :blue ";34m"
   :purple ";35m"
   :cyan ";36m"
   :color-off "m"})

(defn get-preset [color]
  (str starter ((keyword color) colors)))

(defn apply-color [color, text]
  (let [color-val (get-preset color)
        color-off (get-preset :color-off)]
    (str color-val text color-off)))

(defn marker
  ([color] (fn [text] (apply-color color text)))
  ([color text] (apply-color color text)))