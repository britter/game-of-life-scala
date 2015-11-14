package com.example

import com.example.GameOfLife.{Point, World}
import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  val emptyWorld = World(Set())
  val oneCellWorld = World(Set(Point(0,0)))
  val staticWorld = World(Set(Point(0,0), Point(0,1), Point(1,0), Point(1,1)))

  "getNextGeneration" should "return empty world for empty world" in {
    emptyWorld.getNextGeneration() should === (emptyWorld)
  }

  it should "return empty world if it is under populated" in {

    oneCellWorld.getNextGeneration() should === (emptyWorld)
  }

  it should "return static world" in {

    staticWorld.getNextGeneration() should === (staticWorld)
  }

  it should "return dead world for starving world" in {
    val starvingWorld = World(Set(Point(0,0), Point(1,1)))

    starvingWorld.getNextGeneration() should === (emptyWorld)
  }

  it should "return world with new cells" in {
    val reproductiveWorld = World(Set(Point(0,0), Point(0,1), Point(1,1)))

    reproductiveWorld.getNextGeneration() should === (staticWorld)
  }

  "countLivingNeighbours" should "return 0 for empty world" in {
    emptyWorld.countLivingNeighbours(Point(0,0)) should === (0)
  }

  it should "return one for a point wiht one neighbour" in {
    oneCellWorld.countLivingNeighbours(Point(0,1)) should === (1)
  }

}
