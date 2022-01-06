package de.htwg.se.muehle

package model

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.FieldComponent.Piece


class PieceSpec extends AnyWordSpec {
    "Piece" should {
        "return the Letters B or W depending on choosing player1 or player2" in {
            Piece.player1.toString should be("W")
            Piece.player2.toString should be("B")
        }
    }
}
