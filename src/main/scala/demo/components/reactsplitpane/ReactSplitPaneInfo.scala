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

package demo.components.reactsplitpane

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneInfo {

  val component = ScalaComponent
    .builder[Unit]("ReactSplitPaneInfo")
    .render(P => {
      <.div(^.cls := "full-width-section")(
        <.h3("React Split Pane :"),
        <.p("Wrapper for the react-split-pane component (0.1.66)"),
        <.a(
          ^.href := "https://github.com/tomkp/react-split-pane",
          "react-split-pane on GitHub"
        )
      )
    })
    .build

  def apply() = component()
}
