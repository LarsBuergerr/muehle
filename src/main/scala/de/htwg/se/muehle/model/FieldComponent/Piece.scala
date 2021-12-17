package de.htwg.se.muehle

package model.FieldComponent

enum Piece(name: String):
    override def toString: String = name
    case player1 extends Piece("W")
    case player2 extends Piece("B")