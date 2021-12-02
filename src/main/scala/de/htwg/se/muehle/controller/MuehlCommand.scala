package de.htwg.se.muehle

package controller

import util.Command

import model._

case class PutCommand(stone: Option[Piece], x: Int, y: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: Field =
        newfield = controller.field.put(stone, x, y)
        newfield
    override def undoStep: Field = 
        oldfield
    override def redoStep: Field = 
        newfield

case class MoveCommand(stone: Option[Piece], x: Int, y: Int, xnew: Int, ynew: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: Field =
        newfield = controller.field.move(stone, x, y, xnew, ynew)
        newfield
    override def undoStep: Field = 
        oldfield
    override def redoStep: Field = 
        newfield

case class TakeCommand(stone: Option[Piece], x: Int, y: Int, controller: Controller) extends Command(controller):
    val oldfield = controller.field
    var newfield = controller.field
    override def execute: Field =
        newfield = controller.field.take(stone, x, y)
        newfield
    override def undoStep: Field = 
        oldfield
    override def redoStep: Field = 
        newfield
