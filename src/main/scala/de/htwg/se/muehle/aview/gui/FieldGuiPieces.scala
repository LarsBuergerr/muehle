package de.htwg.se.muehle


package aview

package gui


import scala.swing._
import de.htwg.se.muehle.util.Observer
import java.awt.Dimension
import java.awt.{Color, Font} 
import javax.swing.border.LineBorder
import de.htwg.se.muehle.controller.ControllerComponent.ControllerInterface
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._


case class GuiPieces(controller: ControllerInterface) {


    def tile(x: Int, y: Int) = new Tiles(x, y, controller)
    var top = Array.tabulate[Tiles](3, 3) { (row, col) => new Tiles(row, col, controller) }
    var mid = Array.tabulate[Tiles](6) { (col) => new Tiles(3, col, controller) }
    var bot = Array.tabulate[Tiles](3, 3) { (row, col) => new Tiles(row + 4, col, controller) }


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
        contents += top(0)(0)
        contents += top(0)(1)
        contents += top(0)(2)
    }
    val field11= new FlowPanel() {
        hGap = 150
        contents += bot(2)(0)
        contents += bot(2)(1)
        contents += bot(2)(2)
    }
    
    val field2 = new FlowPanel() {
        hGap = 100
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += top(1)(0)
        contents += top(1)(1)
        contents += top(1)(2)
    }
    val field22 = new FlowPanel() {
        hGap = 100
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += bot(1)(0)
        contents += bot(1)(1)
        contents += bot(1)(2)
    }
    val field3 = new FlowPanel {
        hGap = 50
        contents += top(2)(0)
        contents += top(2)(1)
        contents += top(2)(2)
    }
    val field33 = new FlowPanel {
        hGap = 50
        contents += bot(0)(0)
        contents += bot(0)(1)
        contents += bot(0)(2)
    }
    val fieldmid = new FlowPanel {
        hGap = 75
        border = Swing.EmptyBorder(25, 0, 25, 0)
        contents += new FlowPanel {
            hGap = 25
            contents += mid(0)
            contents += mid(1)
            contents += mid(2)
        }
        contents += new FlowPanel {
            hGap = 25
            contents += mid(3)
            contents += mid(4)
            contents += mid(5)
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

