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
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiDrawerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
      selected: js.UndefOr[String],
      isOpen: Boolean,
      isDocked: Boolean,
      isRight: Boolean
  )

  case class Choice(id: String, text: String)

  val choices = Seq(
    Choice("1", "First option"),
    Choice("2", "Second option"),
    Choice("3", "Third option"),
    Choice("4", "Fourth option")
  )

  class Backend($ : BackendScope[Unit, State]) {
    val toggleOpenCb: Callback =
      $.modState(s => s.copy(isOpen = !s.isOpen))

    val toggleOpen: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => toggleOpenCb

    val toggleDocked: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => $.modState(s => s.copy(isDocked = !s.isDocked))

    val toggleRight: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => $.modState(s => s.copy(isRight = !s.isRight))

    val onRequestChange: (Boolean, String) => Callback =
      (open, reason) =>
        Callback.info(s"onRequestChange: open: $open, reason: $reason") >>
        toggleOpenCb

    val selectItem: String => ReactEvent => Callback =
      id => e => $.modState(s => s.copy(selected = id))

    def render(S: State) = {
      <.div(
        CodeExample(code, "MuiDrawer")(
          <.div(
            MuiDrawer(
              onRequestChange = onRequestChange,
              openSecondary = S.isRight,
              open = S.isOpen,
              docked = S.isDocked
            )(
              /* hack in a cheesy centered avatar */
              MuiAvatar(
                key = "avatar",
                size = js.defined(112),
                backgroundColor = Mui.Styles.colors.red400,
                style = js.Dynamic.literal(margin = "auto", display = "block", padding = "10px")
              )(js.defined(":D")),
              choices
                .map(
                  c =>
                    MuiMenuItem(
                      key = c.id,
                      primaryText = js.defined(c.text),
                      checked = S.selected == js.defined(c.id),
                      onClick = selectItem(c.id)
                    )())
                .toVdomArray
            ),
            MuiToggle(key = "toggle1",
                      toggled = S.isOpen,
                      label = js.defined("Show drawer"),
                      onToggle = toggleOpen)(),
            MuiToggle(key = "toggle2",
                      toggled = S.isDocked,
                      label = js.defined("Show docked"),
                      onToggle = toggleDocked)(),
            MuiToggle(key = "toggle3",
                      toggled = S.isRight,
                      label = js.defined("Show on right side"),
                      onToggle = toggleRight)()
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("MuiDrawerDemo")
    .initialState(
      State(
        selected = js.undefined,
        isOpen = false,
        isDocked = false,
        isRight = false
      )
    )
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
