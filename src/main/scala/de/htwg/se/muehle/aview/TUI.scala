package de.htwg.se.muehle

package aview
import scala.io.StdIn.readLine
import util.Observer
import model.FieldComponent.{MuehlMatrix, Piece, MuehlStrat}
import model.FieldComponent.FieldBaseImpl._
import scala.swing.Reactor
import de.htwg.se.muehle.controller.ControllerComponent.ControllerInterface
import de.htwg.se.muehle.controller.ControllerComponent.ControllerBaseImplementation._

class TUI(controller: ControllerInterface) extends Reactor:
    println("Insert Player Names: ")
    val p1 = Player("player1")
    val p2 = Player("player2")
    listenTo(controller)
    def run =
        print(controller.field.mesh())
        loop

    //def this() = this(new Controller(new Field(18, 3, new MuehlMatrix(3, None))))

    reactions += {
        case fieldchange =>
        print(controller.field.mesh())
        println("Selected Point: ")
    }

    def loop: Unit =
        if(controller.field.playerstatus.equals(Piece.player1)) then
            p1.show
        else if(controller.field.playerstatus.equals(Piece.player2)) 
            p2.show
        
        val input = readLine("> ")
        inputloop(input) match {
            case 1 =>
                print("\n\n")
                loop
            case 0 =>
                print("Exiting...\n")
            case -1 =>
                println("Wrong input!\n" +
                    "Supported Operations:\n\n" +
                    "placing a stone:\tput <x> <y>\n" +
                    "moving a stone:\t\tmove <x> <y> <new x> <new y>\n" +
                    "taking a stone:\t\ttake <x> <y>\n" +
                    "Exit:\t\t\t<quit> or <q>\n")
                loop
            case _ =>
                print("Not supported yet\n")
        }

        def inputloop(in: String): Int = {
            val chars = input.split(" ")
            chars(0) match {
                case "quit" | "q" =>
                    return 0
                case "put" | "p" | "place" =>
                    if(chars.size != 3) {
                        return -1
                    }
                    val x = chars(1).toInt - 1
                    val y = chars(2).toInt - 1
                    controller.put(Some(controller.field.playerstatus), x, y)
                    println(controller.field.gamestatus)
                    return 1
                case "move" | "m" =>
                    if(chars.size != 5) {
                        return -1
                    }
                    val x = chars(1).toInt - 1
                    val y = chars(2).toInt - 1
                    val newx = chars(3).toInt - 1
                    val newy = chars(4).toInt - 1
                    controller.move(Some(controller.field.playerstatus), x, y, newx, newy)                  
                    return 1
                case "take" | "t" =>
                    val x = chars(1).toInt - 1
                    val y = chars(2).toInt - 1
                    controller.take(None, x, y)
                    return 1
                case "z" =>
                    controller.undo
                    return 1
                case "y" =>
                    controller.redo
                    return 1
                case _ =>
                    return -1
                }
        }

