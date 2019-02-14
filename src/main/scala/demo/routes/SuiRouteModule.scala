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

package demo.routes

import demo.components.semanticui._
import demo.pages.SuiPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object SuiRouteModule {
  case object Info extends LeftRoute("Info", "info", () => SuiInfo())

  case object Button extends LeftRoute("Button", "button", () => SuiButtonDemo())

  case object Container extends LeftRoute("Container", "container", () => SuiContainerDemo())

  case object Divider extends LeftRoute("Divider", "divider", () => SuiDividerDemo())

  case object Flag extends LeftRoute("Flag", "flag", () => SuiFlagDemo())

  case object Header extends LeftRoute("Header", "header", () => SuiHeaderDemo())

  case object Icon extends LeftRoute("Icon", "icon", () => SuiIconDemo())

  case object Input extends LeftRoute("Input", "input", () => SuiInputDemo())

  case object SuiList extends LeftRoute("List", "list", () => SuiListDemo())

  case object Grid extends LeftRoute("Grid", "grid", () => SuiGridDemo())

  val menu: List[LeftRoute] = List(
    Info,
    Button,
    Container,
    Divider,
    Flag,
    Header,
    Icon,
    Input,
    SuiList,
    Grid
  )

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => SuiPage(i, r)))
      .reduce(_ | _)
  }
}
