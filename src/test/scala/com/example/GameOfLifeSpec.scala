package com.example

import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {
  "generation" should "return new field" in {
    GameOfLife.tick(Map()) should === (Map())
  }

  it should "create empty field when initial field only contains one cell" in {
    GameOfLife.tick(Map(Point(1, 1) -> null)) should === (Map())
  }

  /*it should "survive when two neighbours are alive" in {
    GameOfLife.tick(Map(Point(1, 1) -> null,
                        Point(0, 1) -> null,
                        Point(1, 2) -> null)) should contain (Point(1, 1))
  }*/
}
