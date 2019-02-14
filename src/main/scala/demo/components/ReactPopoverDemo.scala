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
import chandu0101.scalajs.react.components.ReactPopOver
import chandu0101.scalajs.react.components.ReactPopOver.{Props, State}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactPopoverDemo {

  object Style {
    val popoverExample =
      TagMod(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  }
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[Unit, Unit]) {
    private val topRef    = Ref.toScalaComponent(ReactPopOver.component)
    private val rightRef  = Ref.toScalaComponent(ReactPopOver.component)
    private val leftRef   = Ref.toScalaComponent(ReactPopOver.component)
    private val bottomRef = Ref.toScalaComponent(ReactPopOver.component)

    def toggleCB(refComp: => ScalaComponent.MountedImpure[Props, State, ReactPopOver.Backend])
      : ReactMouseEvent => Callback = { e =>
      CallbackTo(e.currentTarget.domAsHtml) flatMap refComp.backend.toggle
    }

    def render = {
      <.div(
        <.h3("Demo"),
        CodeExample(code, "ReactPopover")(
          <.div(Style.popoverExample)(
            <.div(^.padding := "20px")(
              topRef.component(Props("Top Title", "top"))("I am Top Pop over"),
              LocalDemoButton(name = "Top Button", onButtonClick = toggleCB(topRef.unsafeGet()))
            ),
            <.div(^.padding := "20px")(
              leftRef.component(Props("Left Title", "left"))("I am left Popover"),
              LocalDemoButton(name = "Left Button", onButtonClick = toggleCB(leftRef.unsafeGet()))
            ),
            <.div(^.padding := "20px")(
              rightRef.component(Props("Right Title", "right"))("I am Right Popover"),
              LocalDemoButton(name = "Right Button", onButtonClick = toggleCB(rightRef.unsafeGet()))
            ),
            <.div(^.padding := "20px")(
              bottomRef.component(Props("Bottom Title", "bottom"))("I am bottom Popover"),
              LocalDemoButton(name = "Bottom Button", onButtonClick = toggleCB(bottomRef.unsafeGet()))
            )
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("ReactPopoverDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
