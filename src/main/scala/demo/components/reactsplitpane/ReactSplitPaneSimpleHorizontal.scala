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

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactsplitpane.ReactSplitPane
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneSimpleHorizontal {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[_, _]) {

    def render() = {

      <.div(
        CodeExample(code, "Simple Vertical Split")(
          <.div(
            ^.width := "95%",
            ^.height := "400px",
            ^.border := "1px solid",
            ^.margin := "auto",
            ^.position := "relative",
            ReactSplitPane(
              split = "horizontal"
            )(<.div("first"), <.div("second"))
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("ReactSplitPaneDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
