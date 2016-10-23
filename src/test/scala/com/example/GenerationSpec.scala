package com.example

import org.scalatest._

class GenerationSpec extends FlatSpec with Matchers {

  val rowOfThree = Set(Cell(0, 0), Cell(1, 0), Cell(2, 0))
  val fourCells = rowOfThree + Cell(1, 1)

  "evolve" should "return empty generation for empty generation" in {
    Generation().evolve.aliveCells should === (Set.empty)
  }

  it should "return a generation containing a cell which had two neighbours" in {
    Generation(rowOfThree).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a generation containing a which had three neighbours" in {
    Generation(fourCells).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a generation with a new born cell when an empty cell has three living neighbours" in {
    val breedingPool = fourCells - Cell(1,0)

    Generation(breedingPool).evolve.aliveCells should contain(Cell(1, 0))
  }

  it should "return a static generation when a static generation is evolved" in {
    val static = Set(Cell(0,0), Cell(1,0), Cell(0,1), Cell(1,1))

    Generation(static).evolve.aliveCells should === (static)
  }
}
