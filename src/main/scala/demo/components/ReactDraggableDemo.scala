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

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{RElementPosition, ReactDraggable}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.raw.Event

object ReactDraggableDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render =
      <.div(
        ^.cls := "react-draggable-demo",
        <.h2(^.cls := "mui-font-style-headline", "Demo"),
        CodeExample(code, "ReactDraggable")(
          ReactDraggable(
            zIndex = 100,
            onStop = (e: Event, pos: RElementPosition) => Callback.info(s"stopped at $pos")
          )(
            <.div(
              <.h2("Drag me"),
              ^.backgroundColor := "#F2706D",
              ^.padding := "20px",
              ^.width := "200px"
            )
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactDraggableDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
