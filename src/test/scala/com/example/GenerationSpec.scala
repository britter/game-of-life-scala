package com.example

import org.scalatest._

class GenerationSpec extends FlatSpec with Matchers {

  val rowOfThree = Set(Cell(0, 0), Cell(1, 0), Cell(2, 0))

  "evolve" should "return empty generation for empty generation" in {
    Generation().evolve.aliveCells should ===(Generation().aliveCells)
  }

  it should "return a generation containing a cell which had two neighbours" in {

    Generation(rowOfThree).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a generation containing a which had three neighbours" in {
    val fourCells = rowOfThree + Cell(1, 1)

    Generation(fourCells).evolve.aliveCells should contain(Cell(1, 0))
  }
}
