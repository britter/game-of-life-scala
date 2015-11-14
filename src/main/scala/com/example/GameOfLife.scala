package com.example

object GameOfLife {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

  case class Point(x: Int, y: Int) {
    def isNeighbour(other: Point): Boolean = {
      val distX = Math.abs(other.x - this.x)
      val distY = Math.abs(other.y - this.y)
      distX < 2 && distY < 2 && other != this
    }
    
    def getAllNeighbours(): Set[Point] = {
      for(x <- Set(-1, 0, 1);
          y <- Set(-1, 0, 1)
          if x != 0 && y != 0) yield Point(this.x + x, this.y + y)
    }
  }

  case class World(initial: Set[Point]) {
    def getNextGeneration() = {
      World(initial.filter(point => countLivingNeighbours(point) > 1))
    }

    def countLivingNeighbours(point: Point) = {
      initial.count(each => each.isNeighbour(point))
    }
  }
}
