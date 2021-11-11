package de.htwg.se.muehle

package controller

import model.Field
import model.Piece
import util.Observable

case class Controller(var field: Field) extends Observable:
    def put(stone: Option[Piece], x: Int, y: Int) = 
        field = field.put(stone, x, y)
        notifyObservers