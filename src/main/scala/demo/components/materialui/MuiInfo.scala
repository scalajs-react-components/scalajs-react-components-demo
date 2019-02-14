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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._

object MuiInfo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val content = style(
      textAlign.center,
      fontSize(30.px),
      paddingTop(40.px)
    )
  }

  val component = ScalaComponent
    .builder[Unit]("MuiInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "materialui/package.scala")(
        <.div(
          <.h3("Material-ui "),
          <.p(
            "scalajs-react wrapper for ",
            RedLink("material-ui", "http://material-ui.com/#/")
          ),
          <.div(
            <.h4("Supported Version :"),
            <.span("0.18.1")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p(
              "Follow the installation guide from :",
              RedLink("here", "https://github.com/callemall/material-ui#installation"),
              <.br(),
              <.br(),
              "Configure material-ui context in your top level component :",
              RedLink(
                "example",
                "https://github.com/chandu0101/scalajs-react-components/blob/master/demo/src/main/scala/demo/pages/MuiPage.scala")
            )
          )
        )
      )

    })
    .build

  def apply() = component()
}
