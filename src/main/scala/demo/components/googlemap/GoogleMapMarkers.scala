/*
 * Copyright 2018 Roberto Leibman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo
package components
package googlemap

import chandu0101.scalajs.react.components.GoogleMap
import chandu0101.scalajs.react.components.fascades.{LatLng, Marker}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapMarkers {

  val code =
    """
      |
      |  val latlng = LatLng(-33.9 ,151.2)
      |
      |  val markers = List(
      |   Marker( position = LatLng(-33.890542,151.274856) ,title = "Bondi Beach" ),
      |   Marker( position = LatLng(-33.923036,151.259052) ,title = "Coogee Beach" ),
      |   Marker( position = LatLng(-34.028249,151.157507) ,title = "Cronulla Beach" ),
      |   Marker( position = LatLng(-33.80010128657071,151.28747820854187) ,title = "Manly Beach" )
      |  )
      |  GoogleMap(center = latlng ,markers = markers ,zoom = 10)
      |
    """.stripMargin
  val component = ScalaComponent
    .builder[Unit]("mapmarkers")
    .render(P => {
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Markers"),
        CodeExample(code, "GoogleMapMarkers")(
          GoogleMap(center = latlng, markers = markers, zoom = 10)
        )
      )
    })
    .build

  val latlng = LatLng(-33.9, 151.2)

  val markers = List(
    Marker(position = LatLng(-33.890542, 151.274856), title = "Bondi Beach"),
    Marker(position = LatLng(-33.923036, 151.259052), title = "Coogee Beach"),
    Marker(position = LatLng(-34.028249, 151.157507), title = "Cronulla Beach"),
    Marker(position = LatLng(-33.80010128657071, 151.28747820854187), title = "Manly Beach")
  )
  def apply() = component()
}
