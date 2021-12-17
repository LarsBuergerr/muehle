package de.htwg.se.muehle

package aview

package gui

import scala.swing.BoxPanel
import scala.swing.Orientation
import model.FieldComponent._
import scala.swing.event.MouseClicked
import java.awt.Color
import javax.swing.border.LineBorder
import java.awt.Dimension
import de.htwg.se.muehle.controller.ControllerComponent.ControllerInterface



class Tiles(x: Int, y: Int, controller: ControllerInterface) extends BoxPanel(Orientation.NoOrientation) {
    def putReaction = controller.put(Some(controller.field.playerstatus), x, y)
    def selectReaction = controller.select(x, y)
    def unselectReaction = controller.undo
    def moveReaction = controller.move(Some(controller.field.playerstatus), controller.field.getpoint().get.x, controller.field.getpoint().get.y, x, y)
    preferredSize = new Dimension(25, 25)
    border = LineBorder(Color.BLACK)
    listenTo(mouse.clicks)
    background = Color.LIGHT_GRAY
    reactions += {
        case e: MouseClicked => {
            if(controller.field.gamestatus.equals(Gamestatus.put)) {
                putReaction
                selectReaction
            } else {
                if(controller.field.getpoint().equals(Some(Point(x, y)))) {
                    unselectReaction
                } else if (controller.field.getpoint().isDefined) {
                    moveReaction
                } else {
                    selectReaction
                }
            } 
            redraw()
        }
    }


    def redraw() = {
        if(controller.field.getcell(x, y).equals(Some(Piece.player1))) {
            background = Color.WHITE
        } else if(controller.field.getcell(x, y).equals(Some(Piece.player2))) {
            background = Color.BLACK
        } else {
            background = Color.LIGHT_GRAY
        }
    }
}
