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
import chandu0101.scalajs.react.components.ReactListView
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object ReactListViewDemo {

  object Style {

    def listViewComponent = TagMod(^.float := "left", ^.marginBottom := "2em")

    def selectedContent = TagMod(^.alignSelf := "center", ^.margin := "0 40px")

    def listViewDemo = TagMod(^.display := "flex")
  }

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val data = List("ScalaJS", "JavasScript", "ReactJS", "Html", "Css", "Software", "Browser")

  case class State(content: String = "")

  class Backend(t: BackendScope[Unit, State]) {

    def onItemSelect(item: String) = Callback {
      val content = s"Selected Item: $item <br>"
      dom.document.getElementById("listviewcontent").innerHTML = content
    }

    def render =
      <.div(
        <.h3("Demo"),
        CodeExample(code, "ReactListView")(
          <.div(Style.listViewDemo)(
            ReactListView(
              items = data,
              showSearchBox = true,
              onItemSelect = onItemSelect _
            ),
            <.strong(
              ^.id := "listviewcontent",
              Style.selectedContent,
              "Selected Content Here"
            )
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactListViewDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build
  // EXAMPLE:END

  def apply() = component()
}
