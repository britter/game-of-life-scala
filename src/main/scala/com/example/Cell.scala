package com.example

case class Cell(x: Int, y: Int) {

  def neighbours: Set[Cell] = {
    for {
      a <- neighboursCoordinates(x)
      b <- neighboursCoordinates(y)
      if a != x || b != y
    } yield Cell(a, b)
  }

  private def neighboursCoordinates(coord: Int) = (coord - 1).to(coord + 1).toSet

}
