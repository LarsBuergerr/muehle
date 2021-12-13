package de.htwg.se.muehle

import scala.io.StdIn.readLine
import scala.annotation.meta.field
import model.MuehlMatrix
import model.Piece
import model.Piece._
import model.Field._
import model.Field
import controller.Controller
import aview.TUI
import aview.gui.MainGui

@main def Muehle: Unit =

    print("WELCOME TO THE MUEHLE-GAME\n\n\n");
    val matr = new MuehlMatrix[Option[Piece]](3, None)
    val field = new Field(18, 3, matr)
    val controller = Controller(field)
    val tui = TUI(controller)
    val gui = MainGui(controller)
    gui.startup(Array())
    tui.run
    


