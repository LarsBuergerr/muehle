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
    var size = input.toInt
    var matr = new MuehlMatrix[Option[Piece]](size, None)
    val field = new Field(size, matr)
    val controller = Controller(field)
    val tui = TUI(controller)
    tui.run
//    field.mesh()
//    getInputAndPrintLoop(field)
//
//def getInputAndPrintLoop(field: Field): Unit = 
//    val input = readLine
//    input match
//        case "quit" =>
//        case _ => {
//            val chars = input.toCharArray
//            val stone = chars(0) match
//                case 'W' => Piece.player1
//                case 'w' => Piece.player1
//                case 'B' => Piece.player2
//                case 'b' => Piece.player2
//            val x = chars(1).toString.toInt
//            val y = chars(2).toString.toInt
//            val newfield = field.put(Some(stone), x, y)
//            newfield.mesh()
//            getInputAndPrintLoop(newfield)
//        }
