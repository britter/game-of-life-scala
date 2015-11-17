package com.example

import org.scalatest._

class GenerationSpec extends FlatSpec with Matchers {

  "true" should "equal true" in {
    true should === (true)
  }

}
