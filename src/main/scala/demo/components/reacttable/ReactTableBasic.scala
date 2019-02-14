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
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactTable
import demo.util.{Person, SampleData}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactTableBasic {
  import scala.language.existentials
  import ReactTable._
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  //  val columns: List[String] =
  //    List("fname", "lname", "email", "country")
  val configs = List(
    SimpleStringConfig[Person](name = "First Name", _.fname),
    SimpleStringConfig[Person](name = "Last Name", _.lname),
    ColumnConfig[Person](
      name = "Email",
      person => <.a(^.href := s"mailto:${person.email}", person.email))(DefaultOrdering(_.email)),
    SimpleStringConfig[Person](name = "Country", _.country)
  )

  case class Backend($ : BackendScope[_, _]) {
    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Basic Table"),
        CodeExample(code, "ReactTableBasic")(
          ReactTable(data = SampleData.people, configs = configs, rowsPerPage = 6)())
      )
  }

  val component = ScalaComponent
    .builder[Unit]("plain")
    .renderBackend[Backend]
    .build
  // EXAMPLE:END

  def apply() = component()
}
