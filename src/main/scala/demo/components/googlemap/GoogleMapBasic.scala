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

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.GoogleMap
import chandu0101.scalajs.react.components.fascades.LatLng
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapBasic {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val latlng = LatLng(16.3008, 80.4428)

  val component = ScalaComponent
    .builder[Unit]("BasicMap")
    .render(
      P =>
        <.div(
          <.h2(^.cls := "mui-font-style-headline")("Basic Map"),
          CodeExample(code, "GoogleMapBasic")(
            GoogleMap(width = "600px", height = "500px", center = latlng, zoom = 8)
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()
}
