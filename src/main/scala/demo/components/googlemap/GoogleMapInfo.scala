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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapInfo {

  val component = ScalaComponent
    .builder[Unit]("googleMapInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "maps/GoogleMap.scala")(
        <.h3("Google Map :"),
        <.p("Map component based on ",
            <.a(^.href := "https://developers.google.com/maps/documentation/javascript/")(
              "google map javascript api"))
      )

    })
    .build

  def apply() = component()

}
