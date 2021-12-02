package de.htwg.se.muehle
package controller

import model.Field

import util.Command


class Invoker {
  private var undoStack: List[Command] = Nil
  private var redoStack: List[Command] = Nil

  def doStep(command: Command): Field = {
    command match
      case _ =>
        undoStack = command :: undoStack
    command.execute
  }

  def undoStep: Option[Field] = {
    undoStack match {
      case Nil => None
      case head :: stack => {
        undoStack = stack
        redoStack = head :: redoStack
        Some(head.undoStep)
      }
    }
  }

  def redoStep: Option[Field] = {
    redoStack match {
      case Nil => None
      case head :: stack => {
        redoStack = stack
        undoStack = head :: undoStack
        Some(head.redoStep)
      }
    }
  }
}