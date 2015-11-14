package com.example

object GameOfLife {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    
    val field: Set[Point] = Set()
  }

  case class Point(x: Int, y: Int) {
    def distance(other: Point): Point = {
      Point(Math.abs(this.x - other.x), Math.abs(this.y - other.y))
    }
  }

  def tick(field: Set[Point]): Set[Point] = {
    var newField : Set[Point] = Set()
    for(point <- field) {
      val neighbours = getNumberOfNeighbours(field, point)
      if(neighbours == 2 || neighbours == 3) newField = newField + point
    }
    newField
  }
  
  def getSmallestPoint(field: Set[Point]): Point = {
    var smallestX = Integer.MAX_VALUE
    var smallestY = Integer.MAX_VALUE
    for(point <- field) {
      if (point.x < smallestX) {
        smallestX = point.x
      }
      if (point.y < smallestY) {
        smallestY = point.y
      }
    }
    Point(smallestX, smallestY)
  }

  def getLargestPoint(field: Set[Point]): Point = {
    var largestX = Integer.MAX_VALUE
    var largestY = Integer.MAX_VALUE
    for(point <- field) {
      if (point.x > largestX) {
        largestX = point.x
      }
      if (point.y > largestY) {
        largestY = point.y
      }
    }
    Point(largestX, largestY)
  }

  def getNumberOfNeighbours(field: Set[Point], point: Point): Int = {
    var numberOfNeighbours = 0
    for (xDistance <- List(-1, 0, 1)) {
      for (yDistance <- List(-1, 0, 1)) {
        val pointToCheck = Point(point.x + xDistance, point.y + yDistance)
        if (field.contains(pointToCheck)) {
          numberOfNeighbours += 1
        }
      }
    }
    Math.max(numberOfNeighbours - 1, 0)
  }
}
