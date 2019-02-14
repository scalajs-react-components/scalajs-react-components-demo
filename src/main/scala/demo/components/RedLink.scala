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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object RedLink {
  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) = {
      <.a(
        ^.href := P.url,
        P.name,
        ^.textDecoration.none,
        ^.color.red,
        ^.margin := "0 5px",
        ^.target := "_blank"
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("RedLink")
    .renderBackend[Backend]
    .build

  case class Props(name: String, url: String)

  def apply(name: String, url: String) = component(Props(name, url))
}