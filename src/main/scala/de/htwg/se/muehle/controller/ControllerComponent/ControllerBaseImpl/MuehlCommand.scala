package de.htwg.se.muehle

package controller.ControllerComponent.ControllerBaseImplementation

import util.Command

import model.FieldComponent._

case class PutCommand(stone: Option[Piece], x: Int, y: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: FieldInterface =
        newfield = controller.field.put(stone, x, y)
        newfield
    override def undoStep: FieldInterface = 
        oldfield
    override def redoStep: FieldInterface = 
        newfield

case class MoveCommand(stone: Option[Piece], x: Int, y: Int, xnew: Int, ynew: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: FieldInterface =
        newfield = controller.field.move(stone, x, y, xnew, ynew)
        newfield
    override def undoStep: FieldInterface = 
        oldfield
    override def redoStep: FieldInterface = 
        newfield

case class TakeCommand(stone: Option[Piece], x: Int, y: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: FieldInterface =
        newfield = controller.field.take(stone, x, y)
        newfield
    override def undoStep: FieldInterface = 
        oldfield
    override def redoStep: FieldInterface = 
        newfield

case class SelectCommand(x: Int, y: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: FieldInterface = 
        newfield = controller.field.select(x, y)
        newfield

    override def undoStep: FieldInterface =
        oldfield

    override def redoStep: FieldInterface =
        newfield
