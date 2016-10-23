/*
 * Copyright 2016 Benedikt Ritter
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

package de.britter.gameoflife

import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  // format: off
  val neighbours = Set(
    Cell(0,0), Cell(1,0), Cell (2,0),
    Cell(0,1),            Cell (2,1),
    Cell(0,2), Cell(1,2), Cell (2,2)
  )
  // format: on

  "neighbours" should "return all 8 neighbours of a cell" in {
    val cell = Cell(1, 1)

    cell.neighbours should ===(neighbours)
  }

}
