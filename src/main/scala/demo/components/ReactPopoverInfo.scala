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

package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactPopoverInfo {

  val component = ScalaComponent
    .builder[Unit]("ReactPopoverInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "popovers/ReactPopOver.scala")(
        <.h3("React Popover :"),
        <.p(" Simple popover component with following options: "),
        <.ul(^.paddingLeft := "15px")(
          <.li("left"),
          <.li("right"),
          <.li("top"),
          <.li("bottom")
        )
      )
    })
    .build

  def apply() = component()
}