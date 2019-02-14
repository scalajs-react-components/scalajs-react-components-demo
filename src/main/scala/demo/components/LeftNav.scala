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
import japgolly.scalajs.react.component.Generic.toComponentCtor
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

object LeftNav {
  object Style extends StyleSheet.Inline {

    import dsl._

    val container = style(
      display.flex,
      flexDirection.column,
      listStyle := "none",
      padding.`0`
    )

    val menuItem = styleF.bool(
      selected =>
        styleS(
          lineHeight(48.px),
          padding :=! "0 25px",
          cursor.pointer,
          textDecoration := "none",
          mixinIfElse(selected)(
            color.red,
            fontWeight._500
          )(
            color.black,
            &.hover(
              color(c"#555555"),
              backgroundColor(c"#ecf0f1")
            )
          )
      ))
  }

  case class Props(menus: List[LeftRoute], selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) = {
      <.ul(Style.container)(
        P.menus
          .map(
            item =>
              <.li(
                ^.key := item.name,
                Style.menuItem(item == P.selectedPage),
                item.name,
                P.ctrl setOnClick item
            ))
          .toTagMod
      )
    }
  }
  val component = ScalaComponent
    .builder[Props]("LeftNav")
    .renderBackend[Backend]
    .build
  def apply(menus: List[LeftRoute], selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = {
    component(Props(menus, selectedPage, ctrl))
    //    component.set(key, ref)(Props(menus, selectedPage, ctrl))
  }
}
