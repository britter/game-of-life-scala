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

class GenerationSpec extends FlatSpec with Matchers {

  val rowOfThree = Set(Cell(0, 0), Cell(1, 0), Cell(2, 0))
  val fourCells  = rowOfThree + Cell(1, 1)

  "evolve" should "return empty generation for empty generation" in {
    Generation().evolve.aliveCells should ===(Set.empty)
  }

  it should "return a generation containing a cell which had two neighbours" in {
    Generation(rowOfThree).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a generation containing a which had three neighbours" in {
    Generation(fourCells).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a generation with a new born cell when an empty cell has three living neighbours" in {
    val breedingPool = fourCells - Cell(1, 0)

    Generation(breedingPool).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a static generation when a static generation is evolved" in {
    val static = Set(Cell(0, 0), Cell(1, 0), Cell(0, 1), Cell(1, 1))

    Generation(static).evolve.aliveCells should ===(static)
  }
}
