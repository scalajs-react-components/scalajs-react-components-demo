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
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

object MuiSelectFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class ChoiceId(val value: String)                extends js.Object
  class Choice(val id: ChoiceId, val text: String) extends js.Object

  case class Backend($ : BackendScope[Seq[Choice], Choice]) {
    val onChange: (TouchTapEvent, Int, Choice) => Callback =
      (e, idx, a) => $.setState(a) >> Callback.info(s"selected $a")

    def render(choices: Seq[Choice], selected: Choice): VdomElement =
      CodeExample(code, "MuiSelectField")(
        MuiSelectField[Choice](
          value = selected,
          onBlur = CallbackDebug.f1("onBlur"),
          onFocus = CallbackDebug.f1("onFocus"),
          onChange = onChange
        )(
          choices
            .map(
              c =>
                MuiMenuItem[Choice](key = c.id.value, value = c, primaryText = js.defined(c.text))()
            )
            .toVdomArray
        )
      )
  }

  private val component =
    ScalaComponent
      .builder[Seq[Choice]]("MuiSelectFieldDemo")
      .initialStateFromProps(_.head)
      .renderBackend[Backend]
      .build

  def apply(): Unmounted[Seq[Choice], Choice, Backend] =
    component(
      Seq(
        new Choice(new ChoiceId("1"), "Never"),
        new Choice(new ChoiceId("2"), "Every Night"),
        new Choice(new ChoiceId("3"), "Weeknights"),
        new Choice(new ChoiceId("4"), "Weekends"),
        new Choice(new ChoiceId("5"), "Weekly")
      )
    )

  // EXAMPLE:END
}
