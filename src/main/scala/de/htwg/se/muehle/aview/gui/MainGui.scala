package de.htwg.se.muehle

package aview

package gui

import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImpl._
import model.FieldComponent.Piece
import scala.swing._
import de.htwg.se.muehle.util.Observer
import java.awt.Dimension
import java.awt.{Color, Font} 
import javax.swing.border.LineBorder

class MainGui(controller: ControllerInterface) extends SimpleSwingApplication {
    def top = new MainFrame {
        var pieces = GuiPieces(controller)
        title = "Mill Game"
        centerOnScreen()
        contents = new BorderPanel{add(pieces.finalBox, BorderPanel.Position.Center)}
        listenTo(controller)

        reactions += {
            case e: fieldchange => redraw;checkwin
        }

        def redraw = {
            for(x <- 0 to 2) {
                for(y <- 0 to 2) {
                    pieces.top(x)(y).redraw()
                    pieces.bot(x)(y).redraw()
                }
            }
            for(x <- 0 to 5) {
                pieces.mid(x).redraw()
            }
            pieces.p1stones.text = controller.field.player.p1stones.toString
            pieces.p2stones.text = controller.field.player.p2stones.toString

            pieces.showturn.text =
            if(controller.field.playerstatus.equals(Piece.player1)) {
                "Player1: " + controller.field.gamestatus.toString
            } else {
                "Player2: " + controller.field.gamestatus.toString
            }
        }
        def checkwin = {
            if(controller.field.player.p1stones == 0) {
                pieces.showturn.text = "PLAYER 2 WON"
            } else if(controller.field.player.p2stones == 0) {
                pieces.showturn.text = "PLAYER 1 WON"
            }
        }
        visible = true
    }
}