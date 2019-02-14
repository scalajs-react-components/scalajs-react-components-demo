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
import chandu0101.scalajs.react.components.materialui.MuiSlider
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object MuiSliderDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiSliderDemo")
    .render(P => {

      val onChange: (ReactMouseEvent, Double) => Callback =
        (e, v) => Callback.info(s"chose value: $v")

      <.div(
        CodeExample(code, "MuiSlider")(
          MuiSlider(name = "slider1", onChange = onChange)(),
          MuiSlider(name = "slider2", onChange = onChange, defaultValue = 0.5)(),
          MuiSlider(name = "slider1", onChange = onChange, value = 0.3, disabled = true)()
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
