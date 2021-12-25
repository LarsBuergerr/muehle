package de.htwg.se.muehle

package controller.ControllerComponent.ControllerBaseImplementation

import util.Observable
import scala.swing.Publisher
import de.htwg.se.muehle.model.FieldComponent.{FieldInterface, Piece}
import de.htwg.se.muehle.controller.ControllerComponent._

case class Controller(var field: FieldInterface) extends ControllerInterface:
    val invoker = new Invoker
    def put(stone: Option[Piece],x: Int, y: Int) = 
        field = invoker.doStep(PutCommand(stone, x, y, this))
        publish(new fieldchange)

    def undo =
        field = invoker.undoStep.getOrElse(field)
        publish(new fieldchange)

    def redo =
        field = invoker.redoStep.getOrElse(field)
        publish(new fieldchange)

    def move(stone: Option[Piece],x: Int, y: Int, newx: Int, newy: Int) =
        field = invoker.doStep(MoveCommand(stone, x, y, newx, newy, this))
        publish(new fieldchange)


    def take(stone: Option[Piece], x: Int, y: Int) =
        field = invoker.doStep(TakeCommand(stone, x, y,this))
        publish(new fieldchange)


    def select(x: Int, y: Int) =
        field = invoker.doStep(SelectCommand(x, y, this))
        publish(new fieldchange)

    def movetake(stone: Option[Piece], x: Int, y: Int) =
        field = invoker.doStep(MoveTakeCommand(stone, x, y,this))
        publish(new fieldchange)
