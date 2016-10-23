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

object Generation {
  def apply(cells: Set[Cell] = Set.empty): Generation = new Generation(cells)
}

class Generation(val aliveCells: Set[Cell]) {

  def evolve: Generation = {
    Generation(newBornCells ++ survivingCells)
  }

  private def newBornCells = deadNeighbours.filter(canBeBorn)

  private def canBeBorn(cell: Cell) = livingNeighbours(cell).size == 3

  private def deadNeighbours =
    aliveCells.flatMap(_.neighbours).diff(aliveCells)

  private def survivingCells = aliveCells.filter(survivors)

  private def survivors(cell: Cell) = {
    val livingNeighbourCount: Int = livingNeighbours(cell).size
    livingNeighbourCount == 2 || livingNeighbourCount == 3
  }

  private def livingNeighbours(cell: Cell) =
    cell.neighbours.intersect(aliveCells)
}
