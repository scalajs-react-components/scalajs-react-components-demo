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

import chandu0101.scalajs.react.components.reactsplitpane.ReactSplitPane
import chandu0101.scalajs.react.components.{
  Pager,
  ReactDraggable,
  ReactListView,
  ReactSearchBox,
  ReactTable,
  ReactTagsInputCss,
  SpinnerCss,
  hljs
}
import demo.components._
import demo.components.materialui._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._
import scalacss.internal.mutable.GlobalRegistry

object AppCSS {
  def load(): Unit = {
    GlobalRegistry.register(
      LeftNav.Style,
      LeftNavPage.Style,
      MuiButtonsDemo.Style,
      MuiPaperDemo.Style,
      MuiSwitchesDemo.Style,
      MuiTabsDemo.Style,
      MobileTearSheet.Style,
      ReactTable.DefaultStyle,
      ReactListView.DefaultStyle,
      ReactSearchBox.DefaultStyle,
      Pager.DefaultStyle,
      ScalaCSSTutorial.Style,
      InfoTemplate.Style,
      ReactInfiniteDemo.styles,
      ReactDraggable.Style,
      MuiTabsDemo.Style,
      ReactSplitPane.DefaultStyle,
      ReactDraggable.Style,
    )

    /* touch objects to force namespace import */
    hljs.Css.Github
    ReactTagsInputCss
    SpinnerCss

    GlobalRegistry.addToDocumentOnRegistration()
  }
}
