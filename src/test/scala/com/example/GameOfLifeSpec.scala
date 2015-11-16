package com.example

import com.example.GameOfLife.neighbours
import com.example.GameOfLife.occurences
import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  "evolve" should "create empty world for empty world" in {
    GameOfLife.evolve(Set()) should === (Set())
  }

  it should "create a new life when an empty cell has exactly three neighbours" in {
    GameOfLife.evolve(Set((0,2), (1,2), (2,2))) should contain (1, 1)
    GameOfLife.evolve(Set((0,0), (1,0), (2,0))) should contain (1, 1)
    GameOfLife.evolve(Set((0,0), (0,1), (0,2))) should contain (1, 1)
  }

  "neighbours" should "calculate neighbours for cell" in {
    neighbours (1, 1).toSet should === (Set((0,0), (1,0), (2,0), 
                                            (0,1),        (2,1), 
                                            (0,2), (1,2), (2,2))) 
  }
  
  "occurences" should "count single occurence" in {
    occurences(List((1,1))) should === (Map((1,1) -> 1))
  }
  
  it should "count multiple occurences" in {
    occurences(List((1,1), (2,1), (1,1))) should === (Map((1,1) -> 2, (2,1) -> 1))
  }
}
