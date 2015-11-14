package com.example

object GameOfLife {
  
  type Field = Map[Point, Unit]

  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    val field: Field = Map()
  }

  def tick(field: Field): Field = {
    resultingField: Field = Map()
    for ((k, v) <- field) {
      
    }
  }
}
