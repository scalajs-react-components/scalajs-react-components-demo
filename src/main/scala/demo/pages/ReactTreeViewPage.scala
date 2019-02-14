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

package demo.pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTreeViewRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactTreeViewPage {
  val component = ScalaComponent
    .builder[Props]("ReactTreeViewPage")
    .renderBackend[Backend]
    .build

  class Backend(t: BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactTreeViewRouteModule.menu, P.selectedPage, P.ctrl)
  }

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
