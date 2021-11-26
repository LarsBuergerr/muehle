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
@main def Muehle: Unit =

    print("Welcome to the muehle-game, please insert your desired field size [standart = 3]: \n");
    val input = readLine
    val size = input.toInt
    val matr = new MuehlMatrix[Option[Piece]](size, None)
    val field = new Field(18, size, matr)
    val controller = Controller(field)
    val tui = TUI(controller)
    tui.run

