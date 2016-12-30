(ns edn-inspect.app
  (:require [reagent.core :as reagent :refer [atom]]
            [cljs.reader :refer [read-string]]
            [datafrisk.core :as d]))

(defonce state (reagent/atom nil))

(defn frisk-view []
  (let [data (some-> (js/document.getElementById "edn-data")
                     .-text
                     read-string)]
    [d/Root data 0 state]))

(defn init []
  (reagent/render-component (fn [] [frisk-view])
                            (.getElementById js/document "container")))
