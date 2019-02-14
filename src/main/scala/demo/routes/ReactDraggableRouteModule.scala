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

import demo.components.{ReactDraggableDemo, ReactDraggableInfo}
import demo.pages.ReactDraggablePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactDraggableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactDraggableInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactDraggableDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._

    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => ReactDraggablePage(i, r)))
      .reduce(_ | _)

  }
}
