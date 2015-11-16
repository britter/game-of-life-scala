package com.example

object GameOfLife {

  type Cell = (Int, Int)

  def evolve(world: Set[Cell]) = {
    val survivors = for (
      cell <- world;
      livingNeighbours = neighbours(cell).filter(cell => world.contains(cell))
      if livingNeighbours.size == 2 || livingNeighbours.size == 3
    ) yield cell

    val newBorn = world.toList.flatMap(neighbours).groupBy(identity).mapValues(_.size).filter(_._2 == 3).keySet
    newBorn ++ survivors
  }

  val neighbours = (cell: Cell) => {
    for (
      x <- List(-1, 0, 1);
      y <- List(-1, 0, 1)
      if x != 0 || y != 0
    ) yield (cell._1 + x, cell._2 + y)
  }

  val occurences = (neighbours: List[Cell]) => {
    neighbours.groupBy(cell => cell).mapValues(_.size)
  }

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

}
