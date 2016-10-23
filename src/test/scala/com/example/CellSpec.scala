package com.example

import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  val neighbours = Set(
    Cell(0,0), Cell(1,0), Cell (2,0),
    Cell(0,1),            Cell (2,1),
    Cell(0,2), Cell(1,2), Cell (2,2)
  )

  "neighbours" should "return all 8 neighbours of a cell" in {
    val cell = Cell(1, 1)

    cell.neighbours should === (neighbours)
  }

}
