package de.htwg.se.muehle

package model

import Piece._
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class PieceSpec extends AnyWordSpec {
    "Piece" should {
        "return the Letters B or W depending on choosing player1 or player2" in {
            player1.toString should be("W")
            player2.toString should be("B")
            Piece.valueOf("player1") should be ("W")
        }
        
    }
}