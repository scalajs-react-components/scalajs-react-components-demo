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

import chandu0101.scalajs.react.components.ReactTapEventPlugin
import chandu0101.scalajs.react.components.hljs
import demo.routes.AppRouter
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp

object ReactApp extends JSApp {

  override def main(): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className += " pg-loaded"
    }

    //TODO: dev-server complains that we load several times?
    ReactTapEventPlugin(js.undefined)
    hljs.Hljs.registerLanguage("scala", hljs.Languages.Scala)
    AppCSS.load()
    val router = AppRouter.router()
    router.renderIntoDOM(dom.document.getElementById("container"))
    ()
  }
}