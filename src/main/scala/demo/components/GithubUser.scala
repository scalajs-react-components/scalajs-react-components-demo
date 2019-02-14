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

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

case class Github(login: String = "",
                  html_url: String = "",
                  avatar_url: String = "",
                  time: Double = 0) {
  override def equals(obj: Any): Boolean = obj match {
    case that: Github => that.login.equalsIgnoreCase(this.login)
    case _            => false
  }
}

object GithubUser {

  object Styles {
    val userGroup = TagMod(^.display := "inline-block",
                           ^.textAlign := "center",
                           ^.textDecoration := "none",
                           ^.color := "black")

    val userIcon = TagMod(^.margin := "10px",
                          ^.display := "block",
                          ^.width := "100px",
                          ^.height := "100px",
                          ^.borderRadius := "50%")

    val userName = TagMod(^.fontSize := "18px", ^.fontWeight := "500")
  }
  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) = {
      <.a(Styles.userGroup, ^.href := P.user.html_url)(
        <.img(Styles.userIcon, ^.src := P.user.avatar_url),
        <.span(Styles.userName)(P.user.login)
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("GithubUser")
    .renderBackend[Backend]
    .build

  case class Props(user: Github)

  def apply(user: Github, key: Key) = {
    //    component.set(key, ref)(Props(user))}
    component.withKey(key)(Props(user))
  }
}
