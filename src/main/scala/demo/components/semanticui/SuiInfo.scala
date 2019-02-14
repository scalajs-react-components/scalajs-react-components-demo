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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiInfo {

  val component = ScalaComponent
    .builder[Unit]("SuiInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "semanticui/package.scala")(
        <.div(
          <.h3("Semnatic-UI-React "),
          <.p(
            "scalajs-react wrapper for ",
            RedLink("semantic-ui-react", "http://react.semantic-ui.com/introduction")
          ),
          <.div(
            <.h4("Supported Version :"),
            <.span("0.62.0")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :",
                RedLink("here", "http://react.semantic-ui.com/usage#javascript"))
          )
        )
      )

    })
    .build

  def apply() = component()
}
