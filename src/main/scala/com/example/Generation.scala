package com.example

object Generation {
  def apply(cells: Set[Cell] = Set.empty): Generation = new Generation(cells)
}

class Generation(val aliveCells: Set[Cell]) {

  def evolve: Generation = {
    Generation(survivors)
  }

  private def survivors = aliveCells.filter(willSurvive)

  private def willSurvive(cell: Cell) = {
    val livingNeighbourCount: Int = livingNeighbours(cell).size
    livingNeighbourCount == 2 || livingNeighbourCount == 3
  }

  private def livingNeighbours(cell: Cell) = cell.neighbours.intersect(aliveCells)
}
