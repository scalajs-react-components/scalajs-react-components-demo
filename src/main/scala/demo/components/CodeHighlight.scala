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

import chandu0101.scalajs.react.components.hljs.Hljs
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Generic.toComponentCtor
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

object CodeHighlight {
  val applySyntaxHighlight = Callback(
    dom.document.querySelectorAll("code").foreach(Hljs.highlightBlock)
  )

  private val component = ScalaComponent
    .builder[String]("CodeHighLighter")
    .render_P(str => <.code(^.`class` := "scala", ^.padding := "20px", str))
    .configure(
      _.componentDidMountConst(applySyntaxHighlight).componentDidUpdateConst(applySyntaxHighlight))
    .build

  def apply(code: String) = component(code)
}
