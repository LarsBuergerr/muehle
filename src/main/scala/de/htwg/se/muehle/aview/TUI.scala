package de.htwg.se.muehle

package aview
import controller.Controller
import model.Piece
import scala.io.StdIn.readLine
import util.Observer

class TUI(controller: Controller) extends Observer:
    controller.add(this)
    def run =
        controller.field.mesh()
        getInputAndPrintLoop()

    override def update = controller.field.mesh()

    def getInputAndPrintLoop(): Unit =
        val input = readLine
        input match
            case "quit" =>
            case _ => {
                val chars = input.toCharArray
                val stone = chars(0) match
                    case 'W' => Piece.player1
                    case 'w' => Piece.player1
                    case 'B' => Piece.player2
                    case 'b' => Piece.player2
                val x = chars(1).toString.toInt - 1
                val y = chars(2).toString.toInt - 1
                controller.put(Some(stone), x, y)
                getInputAndPrintLoop()
            }
