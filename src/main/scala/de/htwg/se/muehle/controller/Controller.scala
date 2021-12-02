package de.htwg.se.muehle

package controller

import model.Field
import model.Piece
import util.Observable

case class Controller(var field: Field) extends Observable:
    val invoker = new Invoker
    def put(stone: Option[Piece],x: Int, y: Int) = 
        field = invoker.doStep(PutCommand(stone, x, y, this))
        notifyObservers

    def undo =
        field = invoker.undoStep.getOrElse(field)
        notifyObservers

    def redo =
        field = invoker.redoStep.getOrElse(field)
        notifyObservers

    def move(stone: Option[Piece],x: Int, y: Int, newx: Int, newy: Int) =
        field = invoker.doStep(MoveCommand(stone, x, y, newx, newy, this))
        notifyObservers


    def take(stone: Option[Piece], x: Int, y: Int) =
        field = invoker.doStep(TakeCommand(stone, x, y,this))
        notifyObservers
