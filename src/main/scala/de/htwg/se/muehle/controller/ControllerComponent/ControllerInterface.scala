package de.htwg.se.muehle

package controller.ControllerComponent

import model.FieldComponent.Piece
import de.htwg.se.muehle.model.FieldComponent.FieldInterface
import scala.swing.Publisher

trait ControllerInterface extends Publisher:


    var field: FieldInterface

    val invoker: Invoker

    def put(stone: Option[Piece],x: Int, y: Int): Unit

    def undo: Unit

    def redo: Unit

    def move(stone: Option[Piece],x: Int, y: Int, newx: Int, newy: Int): Unit

    def take(stone: Option[Piece], x: Int, y: Int): Unit

    def select(x: Int, y: Int): Unit