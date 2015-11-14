package com.example

import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  "true" should "equal true" in {
    true should === (true)
  }
}
