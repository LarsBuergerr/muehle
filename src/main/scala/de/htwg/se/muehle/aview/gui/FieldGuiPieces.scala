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
import controller.ControllerComponent.ControllerBaseImpl._
import model.FieldComponent.Piece
import java.awt.GridLayout
import javax.swing.BorderFactory
import javax.swing.ImageIcon

case class GuiPieces(controller: ControllerInterface) {


    def tile(x: Int, y: Int) = new Tiles(x, y, controller)
    var top = Array.ofDim[Tiles](3, 3)
    var mid = Array.ofDim[Tiles](6)
    var bot = Array.ofDim[Tiles](3, 3)
    val hline = "de/htwg/se/muehle/aview/gui/hline.jpg"

    def addT(gp: GridPanel, n: Int, x: Int, y: Int, s: String) = {
        for(i <- 0 until n) {
            s match {
                case "t" => top(x)(y) = new Tiles(x, y, controller)
                            gp.contents += top(x)(y)
                case "m" => mid(y) = new Tiles(3, y, controller)
                            gp.contents += mid(y)
                case "b" => bot(x)(y) = new Tiles(x + 4, y, controller)
                            gp.contents += bot(x)(y)
            }
        }
    }

    def addH(gp: GridPanel, n: Int) = {
        def hspace = new Label{
            icon = ImageIcon("src/main/scala/de/htwg/se/muehle/aview/gui/hline.png")
            preferredSize = new Dimension(25, 25)
            minimumSize = new Dimension(25 ,25)
            maximumSize = new Dimension(60, 60)
        }
        for(i <- 0 until n) {
            gp.contents += hspace
        }
    }

    def addV(gp: GridPanel, n: Int) = {
        def vspace = new Label{
            icon = ImageIcon("src/main/scala/de/htwg/se/muehle/aview/gui/vline.png")
            preferredSize = new Dimension(25, 25)
            minimumSize = new Dimension(25 ,25)
            maximumSize = new Dimension(60, 60)
        }
        for(i <- 0 until n) {
            gp.contents += vspace
        }
    }

        def addb(gp: GridPanel, n: Int) = {
        def bspace = new Label{
            preferredSize = new Dimension(25, 25)
            minimumSize = new Dimension(25 ,25)
            maximumSize = new Dimension(60, 60)
        }
        for(i <- 0 until n) {
            gp.contents += bspace
        }
    }

    val textp1 = new TextField{columns = 10}

    val textp2 = new TextField{columns = 10}

    val player1 = new FlowPanel() {    
            contents += new Label("Spieler1: ")
            textp1.editable = false
            contents += textp1
        }
    val player2 = new FlowPanel() {    
            contents += new Label("Spieler2: ")    
            textp2.editable = false 
            contents += textp2   
        }
    val player = new FlowPanel() {
        contents += player1
        contents += player2
    }

    val p1stones = new TextField{columns = 2}

    val p2stones = new TextField{columns = 2}

    val stonesleftp1 = new FlowPanel {
        contents += new Label("stones left: ")
        p1stones.editable = false
        p1stones.text = controller.field.player.p1stones.toString
        contents += p1stones
    }
    val stonesleftp2 = new FlowPanel {
        contents += new Label("stones left: ")
        p2stones.editable = false
        p2stones.text = controller.field.player.p2stones.toString
        contents += p2stones
    }   
    val stones = new FlowPanel {
        contents += stonesleftp1
        contents += stonesleftp2
        border = Swing.EmptyBorder(10, 10, 50, 10)
        hGap = 150
    }
    val showturn = new TextField(columns = 50)

    val turn = new FlowPanel {
        contents+= showturn
        showturn.editable = false
        showturn.text = 
            if(controller.field.playerstatus.equals(Piece.player1)) {
                "Player1: " + controller.field.gamestatus.toString
            } else {
                "Player2: " + controller.field.gamestatus.toString
            }
        border = Swing.EmptyBorder(0, 0, 25, 0)

    }
    val mesh = new GridPanel(13, 13)
        addT(mesh, 1, 0, 0, "t");addH(mesh, 5);addT(mesh, 1, 0, 1, "t");addH(mesh, 5);addT(mesh, 1, 0, 2, "t")
        addV(mesh, 1);addb(mesh, 5);addV(mesh, 1);addb(mesh, 5);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addT(mesh, 1, 1, 0, "t");addH(mesh, 3);addT(mesh, 1, 1, 1, "t");addH(mesh, 3);addT(mesh, 1, 1, 2, "t");addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addT(mesh, 1, 2, 0, "t");addH(mesh, 1);addT(mesh, 1, 2, 1, "t");addH(mesh, 1);addT(mesh, 1, 2, 2, "t");addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addT(mesh, 1, 3, 0, "m");addH(mesh, 1);addT(mesh, 1, 3, 1, "m");addH(mesh, 1);addT(mesh, 1, 3, 2, "m");addb(mesh, 3);addT(mesh, 1, 3, 3, "m");addH(mesh, 1);addT(mesh, 1, 3, 4, "m");addH(mesh, 1);addT(mesh, 1, 3, 5, "m")
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addT(mesh, 1, 0, 0, "b");addH(mesh, 1);addT(mesh, 1, 0, 1, "b");addH(mesh, 1);addT(mesh, 1, 0, 2, "b");addb(mesh, 1);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 3);addV(mesh, 1);addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 1);addT(mesh, 1, 1, 0, "b");addH(mesh, 3);addT(mesh, 1, 1, 1, "b");addH(mesh, 3);addT(mesh, 1, 1, 2, "b");addb(mesh, 1);addV(mesh, 1)
        addV(mesh, 1);addb(mesh, 5);addV(mesh, 1);addb(mesh, 5);addV(mesh, 1)
        addT(mesh, 1, 2, 0, "b");addH(mesh, 5);addT(mesh, 1, 2, 1, "b");addH(mesh, 5);addT(mesh, 1, 2, 2, "b")

    val boardpanel = new BorderPanel {
        border = BorderFactory.createEmptyBorder(0, 175, 0, 175)
        add(mesh, BorderPanel.Position.Center)
    }

    val finalBox = new BoxPanel(Orientation.Vertical) {

        contents += player
        contents += stones
        contents += turn
        contents += boardpanel
        contents += new FlowPanel() {preferredSize = new Dimension(20, 20)}
    }
}