package de.htwg.se.muehle

package controller.ControllerComponent.ControllerBaseImpl

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import model.FieldComponent._
import model.FieldComponent.FieldBaseImpl._

class ControllerSpec extends AnyWordSpec {
    var matr = new MuehlMatrix[Option[Piece]](3, None)
    var field = new Field(2, 3, matr)
    var controller = new Controller(field)
    "A Controller" should {
        "contain the Field that was handed over while creating the controller" in {
            controller.field.matr.size shouldBe(6)
            controller.field.matr.rows(0) shouldBe(Vector(None, None, None))
            controller.field.size shouldBe(3)
            controller.field.matr.middle.size shouldBe(6)
        }
        "be able to put Pieces on the Field and notifiying the Observers" in {
            controller.put(Some(Piece.player1),0, 0)
            controller.put(Some(Piece.player2),1, 0)
            controller.field.matr.checkcell(0, 0) shouldBe(Some(Piece.player1))
            controller.field.matr.checkcell(1, 0) shouldBe(Some(Piece.player2))
        }
        "be able to move Pieces on the Field and notifiying the Observers" in {
            controller.move(Some(Piece.player1), 0, 0, 0, 1)
            controller.move(Some(Piece.player2), 1, 0, 1, 1)
            controller.field.matr.checkcell(0, 1) shouldBe(Some(Piece.player1))
            controller.field.matr.checkcell(1, 1) shouldBe(Some(Piece.player2))
        }
        "be able to take Pieces on the Field and notifiying the Observers" in {
            var matr2 = new MuehlMatrix[Option[Piece]](3, None)
            var field2 = new Field(6, 3, matr2)
            var controller2 = new Controller(field2)
            controller2.put(Some(Piece.player1), 0, 0)
            controller2.put(Some(Piece.player2), 2, 0)
            controller2.put(Some(Piece.player1), 0, 1)
            controller2.put(Some(Piece.player2), 3, 0)
            controller2.put(Some(Piece.player1), 0, 2)
            controller2.take(None, 2, 0)
            controller2.field.matr.checkcell(0, 0) shouldBe(Some(Piece.player1))
            controller2.field.matr.checkcell(0, 1) shouldBe(Some(Piece.player1))
            controller2.field.matr.checkcell(0, 2) shouldBe(Some(Piece.player1))
            controller2.field.matr.checkcell(2, 0) shouldBe(None)
        }
        "be able to undo and redo a move and notifiying the Observers" in {
            controller.undo
            controller.field.matr.checkcell(1, 1) shouldBe(None)
            controller.redo
            controller.field.matr.checkcell(1, 1) shouldBe(Some(Piece.player2))
        }
        "be able to select Cells and notfiying the Observers" in {
            controller.select(0, 0)
            controller.field.point.get.x should be(0)
            controller.field.point.get.x should be(0)
        }

    }
}