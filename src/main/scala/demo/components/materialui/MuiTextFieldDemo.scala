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
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiTextFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  //TODO for some reason the vdomNodeFromString implicit is not working

  val component = ScalaComponent
    .builder[Unit]("MuiTextFieldDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTextField")(
          <.div(
            ^.display.flex,
            ^.flexDirection.column,
            MuiTextField(
              hintText = js.defined("Hint Text"),
              onBlur = CallbackDebug.f1("onBlur"),
              onChange = CallbackDebug.f2("onChange"),
              onFocus = CallbackDebug.f1("onFocus")
            )(),
            MuiTextField(hintText = js.defined("Hint Text"),
                         floatingLabelText = js.defined("Floating Label Text"))(),
            MuiTextField(hintText = js.defined("Multi Line Text"), multiLine = true)(),
            MuiTextField(hintText = js.defined("Multi Line Text"),
                         multiLine = true,
                         floatingLabelText = js.defined("Multi Line Floating Label Text"))(),
            MuiTextField(hintText = js.defined("Disabled Hint text"), disabled = true)()
          )
        )
      )
    })
    .build
  // EXAMPLE:END

  def apply() = component()
}
