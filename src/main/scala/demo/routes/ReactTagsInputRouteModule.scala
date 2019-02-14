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

import demo.components.{ReactTagsInputDemo, ReactTagsInputInfo}
import demo.pages.ReactTagsInputPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactTagsInputRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTagsInputInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTagsInputDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i => staticRoute(i.route, i) ~> renderR(r => ReactTagsInputPage(i, r))).reduce(_ | _)

  }
}