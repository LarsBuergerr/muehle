package de.htwg.se.muehle

package aview
import controller.Controller
import model.Piece
import scala.io.StdIn.readLine
import util.Observer
import model.Field
import model.MuehlMatrix
import model.Player

class TUI(controller: Controller) extends Observer:
    println("Insert Player Names: ")
    val p1 = Player("player1")
    val p2 = Player("player2")
    controller.add(this)
    def run =
        print(controller.field.mesh())
        loop

    def this() = this(new Controller(new Field(18, 3, new MuehlMatrix(3, None))))

    override def update = print(controller.field.mesh())

    //def getInputAndPrintLoop(): Unit =

    //    val input = readLine
    //    input match
    //        case "quit" =>
    //        //case "take" => {
    //        //    val str = input.toCharArray
    //        //    val s = str(0) match
    //        //    
    //        //}
    //        case _ => {
    //            val chars = input.toCharArray
    //            val x = chars(0).toString.toInt - 1
    //            val y = chars(1).toString.toInt - 1
    //            controller.put(x, y)
    //            getInputAndPrintLoop()
    //        }
    
    def loop: Unit =
        if(controller.field.playerstatus == 0) {
            p1.show
        } else {
            p2.show
        }
        val input = readLine("> ")
        inputloop(input) match {
            case 1 =>
                print("\n\n")
                loop
            case 0 =>
                print("Exiting...\n")
            case -1 =>
                print("Wrong input! Try again\n")
                loop
            case _ =>
                print("Not supported yet\n")
        }


        def inputloop(in: String): Int = {
            val chars = input.split(" ")
            chars(0) match {
                case "put" | "p" | "place" =>
                    val p = chars(1) match {
                        case "W" => Piece.player1
                        case "w" => Piece.player1
                        case "B" => Piece.player2
                        case "b" => Piece.player2
                    }
                    val x = chars(2).toInt - 1
                    val y = chars(3).toInt - 1
                    controller.put(Some(p), x, y)
                    return 1
            }
        }

