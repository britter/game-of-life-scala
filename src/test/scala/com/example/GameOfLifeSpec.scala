package com.example

import com.example.GameOfLife.Point
import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  "tick" should "return empty field when empty field is passed in" in {
    GameOfLife.tick(Set()) should === (Set())
  }
  
  it should "return empty field when only single cell is alive" in {
    GameOfLife.tick(Set(Point(1, 1))) should === (Set())
  }
  
  it should "return a living cell when cell has two neighbours" in {
    GameOfLife.tick(Set(Point(1, 1), Point(0,1), Point(0,2))) should contain (Point(1,1))
  }
  
  it should "return a living cell when cell has three neighbours" in {
    GameOfLife.tick(Set(Point(1, 1), Point(0,1), Point(0,2),Point(2,2))) should contain (Point(1,1))
  }
  
  it should "remove cells when the area is overcrowded" in {
    GameOfLife.tick(Set(Point(0, 0),
                        Point(0, 1),
                        Point(0, 2),
                        Point(1, 0),
                        Point(1, 1),
                        Point(1, 2),
                        Point(2, 0),
                        Point(2, 1),
                        Point(2, 2))) should not contain Point(1, 1)
  }

  it should "retain cells that are living near overcrowded areas" in {
    GameOfLife.tick(Set(Point(0, 0),
                        Point(0, 1),
                        Point(0, 2),
                        Point(1, 0),
                        Point(1, 1),
                        Point(1, 2),
                        Point(2, 0),
                        Point(2, 1),
                        Point(2, 2))) should contain (Point(0, 0))
  }

  it should "reproduc e" in {
    GameOfLife.tick(Set(Point(0, 0),
                        Point(0, 1),
                        Point(0, 2))) should contain (Point(1, 1))
  }
  
  "getNumberOfNeighbours" should "find no neighbours" in {
    GameOfLife.getNumberOfNeighbours(Set(), Point(1, 1)) should === (0)
  }

  it should "find one neighbours" in {
    GameOfLife.getNumberOfNeighbours(Set(Point(1, 1), Point(0, 1)), Point(1, 1)) should === (1)
  }

  it should "find eightneighbours" in {
    GameOfLife.getNumberOfNeighbours(Set(Point(0, 0),
                                         Point(0, 1),
                                         Point(0, 2),
                                         Point(1, 0),
                                         Point(1, 1),
                                         Point(1, 2),
                                         Point(2, 0),
                                         Point(2, 1),
                                         Point(2, 2)), Point(1, 1)) should === (8)
  }
}
