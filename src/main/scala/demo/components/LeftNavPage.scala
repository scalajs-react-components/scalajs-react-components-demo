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

import demo.routes.LeftRoute
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

object LeftNavPage {

  object Style extends StyleSheet.Inline {
    import dsl._

    val container = style(
      display.flex,
      minHeight(600.px),
      paddingTop(64.px)
    )

    val nav = style(width(190.px))

    val content = style(
      padding(30.px),
      borderLeft :=! "1px solid rgb(223, 220, 220)",
      flex := "1"
    )
  }

  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) = {
      <.div(
        Style.container,
        <.div(Style.nav, LeftNav(P.menu, P.selectedPage, P.ctrl)),
        <.div(Style.content, P.selectedPage.render())
      )
    }
  }
  val component = ScalaComponent
    .builder[Props]("LeftNavPage")
    .renderBackend[Backend]
    .build

  case class Props(menu: List[LeftRoute], selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(menu: List[LeftRoute],
            selectedPage: LeftRoute,
            ctrl: RouterCtl[LeftRoute]): VdomElement = {
    component(Props(menu, selectedPage, ctrl))
  }
}
