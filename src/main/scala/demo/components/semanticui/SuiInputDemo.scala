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
package semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiInputDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiInput")(
          <.b("A standard input field"),
          <.br(),
          SuiInput(placeholder = "Search ..")(),
          <.br(),
          <.b("Focus"),
          <.br(),
          SuiInput(placeholder = "Search ..", focus = true)(),
          <.br(),
          <.b("Error"),
          <.br(),
          SuiInput(placeholder = "Search ..", error = true)(),
          <.br(),
          <.b("Icon"),
          <.br(),
          SuiInput(placeholder = "Search ..", icon = SuiIconType("search"))()
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiInputDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
