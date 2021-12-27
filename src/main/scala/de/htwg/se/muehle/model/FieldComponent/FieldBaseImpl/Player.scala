package de.htwg.se.muehle

package model.FieldComponent.FieldBaseImpl

import scala.io.StdIn.readLine



trait Player {
    val stones = 9
    def show = println("This is a player")
}

private class Player1 extends Player {
    override def show: Unit = printf("Player 1: \n")
}

private class Player2 extends Player {
    override def show: Unit = printf("Player 2: \n")
}

object Player {
    def apply(player: String) = player match {
        case "player1" => new Player1()
        case "player2" => new Player2()
    }
}
