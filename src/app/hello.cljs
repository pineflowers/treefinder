(ns app.hello
  (:require
   [reagent.core :as r]))

(defn click-counter [click-count]
  [:div
   "The atom " [:code "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me!"
            :on-click #(swap! click-count inc)}]])

(def click-count (r/atom 0))

(def trees (r/atom 
            [{:common-name "Arborvitae"
              :latin-name "Thuja occidentalis"}
             {:common-name "Black Ash"
              :latin-name "Fraxinus nigra"}
             {:common-name "White Ash"
              :latin-name "Fraxinus americana"}   
             {:common-name "Bigtooth Aspen"
              :latin-name "Populus grandidentata"}
             {:common-name "Quaking Aspen"
              :latin-name "Populus tremuloides"}
             {:common-name "Basswood"
              :latin-name "Tilia americana"}
             {:common-name "American Beech"
              :latin-name "Fagus grandifolia"}
             {:common-name "Black Birch"
              :latin-name "Betula lenta"}
             {:common-name "Gray Birch"
              :latin-name "Betula populifolia"}
             {:common-name "Paper Birch"
              :latin-name "Betula papyrifera"}
             {:common-name "Yellow Birch"
              :latin-name "Betula alleghaniensis"}
             {:common-name "Butternut"
              :latin-name "Juglans cinerea"}
             {:common-name "Black Cherry"
              :latin-name "Prunus serotina"}
             {:common-name "Pin Cherry"
              :latin-name "Prunus pensylvanica"}
             {:common-name "American Chestnut"
              :latin-name "Castanea dentata"}
             {:common-name "Eastern Cottonwood"
              :latin-name "Populus deltoides"}
             {:common-name "Cucumber Tree"
              :latin-name "Magnolia acuminata"}
             {:common-name "American Elm"
              :latin-name "Ulmus americana"}
             {:common-name "Slippery Elm"
              :latin-name "Ulmus rubra"}
             {:common-name "Balsam Fir"
              :latin-name "Abies balsamea"}
             {:common-name "Hawthorn"
              :latin-name "Crataegus"}
             {:common-name "Eastern Hemlock"
              :latin-name "Tsuga canadensis"}
             {:common-name "Bitternut Hickory"
              :latin-name "Carya cordiformis"}
             {:common-name "Pignut Hickory"
              :latin-name "Carya glabra"}
             {:common-name "Shagbark Hickory"
              :latin-name "Carya ovata"}
             {:common-name "American Hophornbeam"
              :latin-name "Ostrya virginiana"}
             {:common-name "American Hornbeam"
              :latin-name "Carpinus caroliniana"}
             {:common-name "American Larch"
              :latin-name "Larix laricina"}
             {:common-name "Black Locust"
              :latin-name "Robinia pseudoacacia"}
             {:common-name "Honey-Locust"
              :latin-name "Gleditsia triacanthos"}
             {:common-name "Red Maple"
              :latin-name "Acer rubrum"}
             {:common-name "Silver Maple"
              :latin-name "Acer saccharinum"}
             {:common-name "Sugar Maple"
              :latin-name "Acer saccharum"}
             {:common-name "The Oaks"
              :latin-name "about all species"}
             {:common-name "Black Oak"
              :latin-name "Quercus velutina"}
             {:common-name "Chestnut Oak"
              :latin-name "Quercus montana"}
             {:common-name "Northern Red Oak"
              :latin-name "Quercus rubra"}
             {:common-name "Scarlet Oak"
              :latin-name "Quercus coccinea"}
             {:common-name "White Oak"
              :latin-name "Quercus alba"}
             {:common-name "Eastern White Pine"
              :latin-name "Pinus strobus"}
             {:common-name "Pitch Pine"
              :latin-name "Pinus rigida"}
             {:common-name "Red Pine"
              :latin-name "Pinus resinosa"}
             {:common-name "Eastern Redcedar"
              :latin-name "Juniperus virginiana"}
             {:common-name "Sassafras"
              :latin-name "Sassafras albidum"}
             {:common-name "Shadbush"
              :latin-name "Amelanchier canadensis"}
             {:common-name "Red Spruce"
              :latin-name "Picea rubens"}
             {:common-name "White Spruce"
              :latin-name "Picea glauca"}
             {:common-name "Sycamore"
              :latin-name "Platanus occidentalis"}
             {:common-name "Tulip Tree"
              :latin-name "Liriodendron tulipifera"}
             {:common-name "Black Walnut"
              :latin-name "Juglans nigra"}
             {:common-name "Black Willow"
              :latin-name "Salix nigra"}]))

(defn table-render []
  [:table.table.table-striped.table-bordered 
   {:cell-spacing "0" :width "100%"}
   [:thead>tr 
    [:th "Common Name"]
    [:th "Latin Name"]]
   [:tbody
    (for [x @trees] [:tr {:key (gensym)} [:td (:common-name x)] [:td (:latin-name x)]])]])

(defn page-ready [this]
  (.DataTable (js/$ (r/dom-node this))))

(defn table []
  (r/create-class {:reagent-render table-render
                   :component-did-mount page-ready}))

(defn hello []
  [:<>
   [:div#table]
   ;; [click-counter click-count]
   ])

