package de.htwg.se.muehle

package aview

package gui

import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._
import scala.swing._
import de.htwg.se.muehle.util.Observer
import java.awt.Dimension
import java.awt.{Color, Font} 
import javax.swing.border.LineBorder

class MainGui(controller: ControllerInterface) extends SimpleSwingApplication {
    def top = new MainFrame {
        var pieces = GuiPieces(controller)
        title = "Muehle Game"
        centerOnScreen()
        contents = pieces.finalBox
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
        }
        def checkwin = {
            if(controller.field.player.p1stones == 0) {
                pieces.textp1.text = "PLAYER 2 WON"
                quit
            } else if(controller.field.player.p2stones == 0) {
                pieces.textp1.text = "PLAYER 1 WON"
                quit
            }
        }
        visible = true
    }
}