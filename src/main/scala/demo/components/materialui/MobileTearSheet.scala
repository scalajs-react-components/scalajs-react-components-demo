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
package materialui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

object MobileTearSheet {

  object Style extends StyleSheet.Inline {

    import dsl._

    val root = style(
      marginBottom(24 px),
      marginRight(24 px),
      width(360 px)
    )

    val container = style(
      border :=! "solid 1px #d9d9d9",
      height :=! "500px",
      overflow.hidden
    )

    val bottomTear = style(
      display.block,
      position.relative,
      marginTop :=! "-10px",
      width(360 px)
    )
  }

  case class Backend($ : BackendScope[Unit, Unit]) {
    def render(C: PropsChildren) = {
      <.div(
        Style.root,
        <.div(
          Style.container,
          C
        ),
        <.img(Style.bottomTear, ^.src := Images.bottomTearImage.toString)
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("MobileTearSheet")
    .renderBackendWithChildren[Backend]
    .build

  def apply(children: VdomNode*) = component(children: _*)
}
