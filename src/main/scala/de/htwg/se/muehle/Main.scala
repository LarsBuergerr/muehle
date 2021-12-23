package de.htwg.se.muehle

import scala.io.StdIn.readLine
import scala.annotation.meta.field
import model.FieldComponent.FieldBaseImpl.Field
import model.FieldComponent._
import controller.ControllerComponent.ControllerBaseImplementation._
import controller.ControllerComponent._
import aview.TUI
import aview.gui.MainGui

@main def Muehle: Unit =

    print("WELCOME TO THE MUEHLE-GAME\n\n\n");
    val matr = new MuehlMatrix[Option[Piece]](3, None)
    val field = new Field(2, 3, matr)
    val controller = Controller(field)
    val tui = TUI(controller)
    val gui = MainGui(controller)
    //gui.startup(Array())
    tui.run