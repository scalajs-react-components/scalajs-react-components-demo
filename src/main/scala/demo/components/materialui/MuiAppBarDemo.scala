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
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiAppBarDemo {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiAppBarDemo")
    .render(
      P =>
        <.div(
          CodeExample(code, "MuiAppBar")(
            MuiAppBar(
              title = js.defined("Title"),
              onLeftIconButtonClick = CallbackDebug.f1("onLeftIconButtonClick"),
              onRightIconButtonClick = CallbackDebug.f1("onRightIconButtonClick"),
              onTitleClick = CallbackDebug.f1("onTitleClick"),
              showMenuIconButton = true
            )()
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()
}
