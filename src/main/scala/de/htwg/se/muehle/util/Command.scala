package de.htwg.se.muehle

package util
import model.FieldComponent._

import controller.ControllerComponent._
import javax.swing.undo.UndoManager
import de.htwg.se.muehle.model.FieldComponent.FieldInterface

trait Command(controller: ControllerInterface):
    def execute: FieldInterface
    def undoStep: FieldInterface
    def redoStep: FieldInterface
