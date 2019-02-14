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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._

object ReactTagsInputInfo {

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(
      textAlign.center,
      fontSize(30.px),
      paddingTop(40.px)
    )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactTagsInputInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "textfields/ReactTagsInput.scala")(
        <.div(
          <.h3("React Tags Input "),
          <.p(
            "scalajs-react wrapper for ",
            RedLink("tags input", "https://github.com/olahol/react-tagsinput")
          ),
          <.div(
            <.h4("Supported Version :"),
            <.span("3.0.3")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :",
                RedLink("here", "https://github.com/olahol/react-tagsinput#install"))
          )
        )
      )

    })
    .build

  def apply() = component()
}
