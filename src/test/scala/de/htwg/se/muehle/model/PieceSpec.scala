package de.htwg.se.muehle

package model

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.FieldComponent._
import model.FieldComponent.FieldBaseImpl._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._


class PieceSpec extends AnyWordSpec {
    "Piece" should {
        "return the Letters B or W depending on choosing player1 or player2" in {
            Piece.player1.toString should be("W")
            Piece.player2.toString should be("B")
        }
    }
}
