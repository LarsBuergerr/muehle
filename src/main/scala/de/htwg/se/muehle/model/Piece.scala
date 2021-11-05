package main.scala.de.htwg.se.muehle.model

enum Piece(name: String):
    override def toString: String = name
    case player1 extends Piece("w")
    case player2 extends Piece("B")