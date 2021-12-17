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
        title = "Muehle Game"
        centerOnScreen()
        contents = GuiPieces(controller).finalBox
        visible = true
        listenTo(controller)

        reactions += {
            case e: fieldchange => redraw
        }

    }
    def redraw = {
        def top = new MainFrame {
        title = "Muehle Game"
        centerOnScreen()
        contents = GuiPieces(controller).finalBox
        visible = true
        }
    }
}