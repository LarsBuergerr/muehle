package de.htwg.se.muehle

package util
import model.Field

import model.Piece
import controller.Controller
import javax.swing.undo.UndoManager

trait Command(controller: Controller):
    def execute: Field
    def undoStep: Field
    def redoStep: Field
