package de.htwg.se.muehle

package model.FieldComponent


import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.FieldComponent._
import model.FieldComponent.FieldBaseImpl._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._

class isMillSpec extends AnyWordSpec {
    "isMill" should {
        "returns true or false if there is a Mill on the given Cordinates" in {
            
            val matr = new MuehlMatrix[Option[Piece]](3, None)
            val matr1 = matr.replace(0, 0, Some(Piece.player1))
            val matr2 = matr1.replace(0, 1, Some(Piece.player1))
            val matr3 = matr2.replace(0, 2, Some(Piece.player1))
            isMill(0, 0, Some(Piece.player1), matr3).muehlstrat() should be (true)
            isMill(0, 0, Some(Piece.player2), matr3).muehlstrat() should be (false)
            
            val matr4 = matr3.replace(3, 0, Some(Piece.player2))
            val matr5 = matr4.replace(3, 1, Some(Piece.player2))
            val matr6 = matr5.replace(3, 2, Some(Piece.player2))
            isMill(3, 2, Some(Piece.player2), matr6).muehlstrat() should be (true)
            isMill(3, 2, Some(Piece.player1), matr6).muehlstrat() should be (false)

            val matr7 = matr6.replace(3, 3, Some(Piece.player1))
            val matr8 = matr7.replace(3, 4, Some(Piece.player1))
            val matr9 = matr8.replace(3, 5, Some(Piece.player1))
            isMill(3, 4, Some(Piece.player1), matr9).muehlstrat() should be (true)
            isMill(3, 4, Some(Piece.player2), matr9).muehlstrat() should be (false)

            val matr10 = matr9.replace(4, 1, Some(Piece.player2))
            val matr11 = matr10.replace(5, 1, Some(Piece.player2))
            val matr12 = matr11.replace(6, 1, Some(Piece.player2))
            isMill(5, 1, Some(Piece.player2), matr12).muehlstrat() should be (true)
            isMill(5, 1, Some(Piece.player1), matr12).muehlstrat() should be (false)
        }
    }
}

