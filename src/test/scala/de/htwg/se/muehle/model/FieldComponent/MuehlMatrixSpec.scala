package de.htwg.se.muehle

package model.FieldComponent

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import FieldBaseImpl._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImpl._

class MuehlMatrixSpec extends AnyWordSpec {

    "A Matrix" should {
        "being created using a dimension and a filling " +
            "and consist out out of a Vatrix and a Vector" in {
            val matrix = new MuehlMatrix[Option[Piece]](3, None)
            matrix.size should be(6)
            matrix.rows(0).forall(p => p == None) should be(true)
            matrix.rows(1).forall(p => p == None) should be(true)
            matrix.rows(2).forall(p => p == Some(Piece.player1)) should be(false)
            matrix.mid(5) shouldBe(None)
        }
        "have a middlerow which width should be double the size" in {
            val matrix = new MuehlMatrix[Option[Piece]](3, None)
            matrix.mid(5) shouldBe(None)
            an [IndexOutOfBoundsException] should be thrownBy matrix.mid(6)
        }
        "have a filling if you do so by using the fill methode" in {
            val matrix = new MuehlMatrix[Option[Piece]](3, None)
            matrix.rows(0) shouldBe(Vector(None, None, None))
            matrix.fill(Some(Piece.player1)) shouldBe(MuehlMatrix(Vector(Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1)),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1)),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1)),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1)),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1)),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1))),
                Vector(Some(Piece.player1), Some(Piece.player1), Some(Piece.player1), Some(Piece.player1), Some(Piece.player1), Some(Piece.player1))))
        }
        "change the filling by using the replace and replaceMid methode" in {
            val matrix = new MuehlMatrix[Option[Piece]](3, None)
            matrix.rows(0) shouldBe(Vector(None, None, None))
            val newmatrix = matrix.replace(0,0,Some(Piece.player1))
            val newmatrix2 = newmatrix.replaceMid(5, Some(Piece.player1))
            newmatrix.rows(0) shouldBe(Vector(Some(Piece.player1), None, None))
            newmatrix2.middle shouldBe(Vector(None, None, None, None, None, Some(Piece.player1)))
        
        }
        "return the filling of a single cell by using the cell methode" in {
            val matrix = new MuehlMatrix[Option[Piece]](2, Some(Piece.player1))
            matrix.cell(0, 0) shouldBe(Some(Piece.player1))
            matrix.cell(0, 1) shouldBe(Some(Piece.player1))
            matrix.cell(1, 0) shouldBe(Some(Piece.player1))
            matrix.cell(1, 1) shouldBe(Some(Piece.player1))
            val matrix2 = new MuehlMatrix[Option[Piece]](2, Some(Piece.player2))
            matrix2.cell(0, 0) shouldBe(Some(Piece.player2))
            matrix2.cell(0, 1) shouldBe(Some(Piece.player2))
            matrix2.cell(1, 0) shouldBe(Some(Piece.player2))
            matrix2.cell(1, 1) shouldBe(Some(Piece.player2))
        }
    }
}