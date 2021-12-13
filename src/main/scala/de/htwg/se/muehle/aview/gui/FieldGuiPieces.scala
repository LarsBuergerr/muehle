package de.htwg.se.muehle


package aview

package gui


import controller._
import controller.Controller
import scala.swing._
import de.htwg.se.muehle.util.Observer
import java.awt.Dimension
import java.awt.{Color, Font} 
import javax.swing.border.LineBorder


case class GuiPieces(controller: Controller) {
    val player1 = new FlowPanel() {    
            contents += new Label("Spieler1: ")    
            contents += new TextField{columns = 10}     
        }
    val player2 = new FlowPanel() {    
            contents += new Label("Spieler2: ")    
            contents += new TextField{columns = 10}     
        }
    val player = new FlowPanel() {
        contents += player1
        contents += player2
    }


    val stonesleftp1 = new FlowPanel{
        contents += new Label("stones left: ")
        contents += new TextField{columns = 2}

    }

    val stonesleftp2 = new FlowPanel{
        contents += new Label("stones left: ")
        contents += new TextField{columns = 2}

    }   

    val stones = new FlowPanel {
        contents += stonesleftp1
        contents += stonesleftp2
        border = Swing.EmptyBorder(10, 10, 50, 10)
        hGap = 150
    }

    val turn = new FlowPanel {
        contents+= new TextField(columns = 50)
        border = Swing.EmptyBorder(0, 0, 25, 0)
    }

    val field1 = new FlowPanel() {
        hGap = 150
        contents += new Tiles(0, 0, controller)
        contents += new Tiles(0, 1, controller)
        contents += new Tiles(0, 2, controller)
    }
    val field11= new FlowPanel() {
        hGap = 150
        contents += new Tiles(6, 0, controller)
        contents += new Tiles(6, 1, controller)
        contents += new Tiles(6, 2, controller)
    }
    
    val field2 = new FlowPanel() {
        hGap = 100
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += new Tiles(1, 0, controller)
        contents += new Tiles(1, 1, controller)
        contents += new Tiles(1, 2, controller)
    }
    val field22 = new FlowPanel() {
        hGap = 100
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += new Tiles(5, 0, controller)
        contents += new Tiles(5, 1, controller)
        contents += new Tiles(5, 2, controller)
    }
    val field3 = new FlowPanel {
        hGap = 50
        contents += new Tiles(2, 0, controller)
        contents += new Tiles(2, 1, controller)
        contents += new Tiles(2, 2, controller)
    }
    val field33 = new FlowPanel {
        hGap = 50
        contents += new Tiles(4, 0, controller)
        contents += new Tiles(4, 1, controller)
        contents += new Tiles(4, 2, controller)
    }
    val fieldmid = new FlowPanel {
        hGap = 75
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += new FlowPanel {
            hGap = 25
            contents += new Tiles(3, 0, controller)
            contents += new Tiles(3, 1, controller)
            contents += new Tiles(3, 2, controller)
        }
        contents += new FlowPanel {
            hGap = 25
            contents += new Tiles(3, 3, controller)
            contents += new Tiles(3, 4, controller)
            contents += new Tiles(3, 5, controller)
        }
    }
    val finalBox = new BoxPanel(Orientation.Vertical) {
        contents += player
            contents += stones
            contents += turn
            contents += field1
            contents += field2
            contents += field3
            contents += fieldmid
            contents += field33
            contents += field22
            contents += field11
    }
}

