//package de.htwg.se.muehle
//
//package aview
//package gui
//
//import controller.Controller
//import controller._
//import scala.swing.SimpleSwingApplication
//import scala.swing.MainFrame
//import de.htwg.se.muehle.util.Observer
//import scala.swing.GridPanel
//import java.awt.Dimension
//
//
//class MainGui(controller: Controller) extends SimpleSwingApplication {
//    def top = new MainFrame {
//        contents = new GridPanel(3, 3) {
//            preferredSize = new Dimension(1000, 1000)
//            contents += Tiles(0, 0, controller)
//            contents += Tiles(0, 1, controller)
//            contents += Tiles(0, 2, controller)
//            contents += Tiles(1, 0, controller)
//            contents += Tiles(1, 1, controller)
//            contents += Tiles(1, 2, controller)
//            contents += Tiles(2, 0, controller)
//            contents += Tiles(2, 1, controller)
//            contents += Tiles(2, 2, controller)
//        }
//
//        listenTo(controller)
//
//        reactions += {
//            case e: fieldchange => redraw
//        }
//
//        def redraw = {
//            FieldGui(controller)
//        }
//    }
//}

package de.htwg.se.muehle

package aview

package gui

import controller.Controller
import controller._
import scala.swing._
import de.htwg.se.muehle.util.Observer
import java.awt.Dimension
import java.awt.{Color, Font} 
import javax.swing.border.LineBorder

class MainGui(controller: Controller) extends SimpleSwingApplication {
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