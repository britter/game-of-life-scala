lazy val `game-of-life-scala` =
  project.in(file(".")).enablePlugins(AutomateHeaderPlugin, GitVersioning)

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import de.britter.game.of.life.scala._
                      |""".stripMargin
