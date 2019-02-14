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
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React.Ref
import japgolly.scalajs.react.vdom._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html
import org.scalajs.dom.html.Div

import scala.scalajs.js

object MuiPopoverDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  private case class OriginChoice[T](ts: Seq[T], label: String)(set: T => Callback,
                                                                fromState: State => T,
                                                                str: T => String) {
    val action: (ReactEvent, Int, String) => Callback =
      (e, idx, any) => set(ts(idx))

    val items: VdomNode =
      ts.map(t => MuiMenuItem[String](value = str(t), primaryText = js.defined(str(t)))())
        .toVdomArray

    def menu(S: State): VdomElement =
      <.div(
        ^.key := label,
        <.label(label, ^.width := "400px"),
        MuiDropDownMenu[String](onChange = action, value = str(fromState(S)))(items)
      )
  }

  case class State(open: Boolean, target: Origin, anchor: Origin)

  private case class Backend($ : BackendScope[Unit, State]) {
    var ref = Ref[html.Element]

    val toggle: Callback =
      $.modState(s => s.copy(open = !s.open))

    val anchorH = OriginChoice(Horizontal.values, "Change anchor horizontal")(
      t => $.modState(s => s.copy(anchor = s.anchor.copy(horizontal = t))),
      _.anchor.horizontal,
      _.value
    )
    val anchorV = OriginChoice(Vertical.values, "Change anchor vertical")(
      t => $.modState(s => s.copy(anchor = s.anchor.copy(vertical = t))),
      _.anchor.vertical,
      _.value
    )
    val targetH = OriginChoice(Horizontal.values, "Change target horizontal")(
      t => $.modState(s => s.copy(target = s.target.copy(horizontal = t))),
      _.target.horizontal,
      _.value
    )
    val targetV = OriginChoice(Vertical.values, "Change target vertical")(
      t => $.modState(s => s.copy(target = s.target.copy(vertical = t))),
      _.target.vertical,
      _.value
    )

    val originChoices = Seq(anchorV, anchorH, targetV, targetH)

    def render(S: State) = {
      <.div(
        CodeExample(code, "MuiPopoverDemo")(
          <.div(
            <.div(
              MuiRaisedButton(
                onClick = (e: ReactEvent) => toggle,
                label = "Click on me to show a popover"
              )()
            ).withRef(ref),
            originChoices.map(_.menu(S)).toVdomArray,
            MuiPopover(
              open = S.open,
              anchorEl = ref.asInstanceOf[js.Any],
              anchorOrigin = S.anchor,
              targetOrigin = S.target,
              onRequestClose = (s: String) => toggle
            )(
              <.div(
                ^.padding := "20px",
                <.h2("here is an arbitrary popover"),
                <.p("Hi - here is some content"),
                MuiRaisedButton(
                  primary = true,
                  label = "here is a button",
                  onClick = (e: ReactEvent) => toggle
                )()
              )
            )
          )
        )
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("MuiPopoverDemo")
    .initialState(
      State(
        open = false,
        target = Origin(Vertical.top, Horizontal.left),
        anchor = Origin(Vertical.bottom, Horizontal.left)
      ))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply(): VdomElement =
    component()
}
