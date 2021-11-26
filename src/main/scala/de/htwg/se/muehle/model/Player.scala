package de.htwg.se.muehle
package model
import scala.io.StdIn.readLine



trait Player {
    val name = readLine("> ")
    def show = println("This is a player")
}

private class Player1 extends Player {
    override def show: Unit = printf("player1: %s\n", name)
}

private class Player2 extends Player {
    override def show: Unit = printf("player2: %s\n", name)
}

object Player {
    def apply(player: String) = player match {
        case "player1" => new Player1()
        case "player2" => new Player2()
    }
}



val p1 = Player("player1")
