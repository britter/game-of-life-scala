package com.example

object Generation {
  def apply(cells: Set[Cell] = Set.empty): Generation = new Generation(cells)
}

class Generation(val aliveCells: Set[Cell]) {

  def evolve: Generation = {
    Generation(newBornCells ++ survivingCells)
  }

  private def newBornCells = deadNeighbours.filter(canBeBorn)
  
  private def canBeBorn(cell: Cell) = livingNeighbours(cell).size == 3

  private def deadNeighbours = aliveCells.flatMap(_.neighbours).diff(aliveCells)

  private def survivingCells = aliveCells.filter(survivors)

  private def survivors(cell: Cell) = {
    val livingNeighbourCount: Int = livingNeighbours(cell).size
    livingNeighbourCount == 2 || livingNeighbourCount == 3
  }

  private def livingNeighbours(cell: Cell) = cell.neighbours.intersect(aliveCells)
}
