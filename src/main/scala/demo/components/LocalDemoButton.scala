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

import chandu0101.scalajs.react.components._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object LocalDemoButton {

  import RCustomStyles._

  trait Style {

    val button = TagMod(
      ^.backgroundColor := "#F2706D",
      ^.border := "1px solid transparent",
      ^.boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      ^.color := "#F5F4F4",
      ^.cursor := "pointer",
      ^.display := "inline-block",
      ^.fontSize := "15px",
      ^.textDecoration := "none",
      ^.padding := "5px 7px",
      WebkitBoxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)"
    )

    val buttonHover = TagMod(
      ^.backgroundColor := "#DA423E",
      ^.textDecoration := "none"
    )

  }

  case class State(buttonHover: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {

    def onButtonClick(P: Props)(e: ReactMouseEvent): Callback =
      (CallbackOption.liftOptionLike(P.onButtonClick).flatMap(f => f(e)) >>
        e.preventDefaultCB)

    val onMouseEnter: Callback =
      t.modState(_.copy(buttonHover = true))

    val onMouseLeave: Callback =
      t.modState(_.copy(buttonHover = false))

    def styleSet1(st1: TagMod, more: (TagMod, Boolean)*): TagMod = {
      TagMod(st1, more.filter(_._2).map(_._1).toTagMod)
    }

    def render(P: Props, S: State) = {
      val buttonStyle = styleSet1(
        P.style.button,
        P.style.buttonHover -> S.buttonHover
      )
      if (P.linkButton)
        <.a(
          buttonStyle,
          ^.href := P.href,
          ^.target := "_blank",
          ^.onMouseEnter --> onMouseEnter,
          ^.onMouseLeave --> onMouseLeave,
          P.name
        )
      else
        <.a(
          buttonStyle,
          ^.onClick ==> onButtonClick(P),
          ^.onMouseEnter --> onMouseEnter,
          ^.onMouseLeave --> onMouseLeave,
          P.name
        )
    }
  }

  val component = ScalaComponent
    .builder[Props]("LocalDemoButton")
    .initialState(State())
    .renderBackend[Backend]
    .build

  case class Props(
      name: String,
      onButtonClick: js.UndefOr[ReactMouseEvent => Callback],
      linkButton: Boolean,
      href: String,
      style: Style
  )

  def apply(
      name: String,
      onButtonClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
      linkButton: Boolean = false,
      href: String = "",
      style: Style = new Style {}
  ) = {
    component(Props(name, onButtonClick, linkButton, href, style))
  }

}
