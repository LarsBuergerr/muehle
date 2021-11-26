package de.htwg.se.muehle
package controller

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import model.Piece
import model.MuehlMatrix
import model.Field
import model.Piece._

class ControllerSpec extends AnyWordSpec {
    "A Controller" should {
        "contain the Field that was handed over while creating the controller" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(18, 3, matr)
            var controller = new Controller(field)
            controller.field.matr.size shouldBe(6)
            controller.field.matr.rows(0) shouldBe(Vector(None, None, None))
            controller.field.size shouldBe(3)
            controller.field.matr.middle.size shouldBe(6)
        }
        "be able to update the Field and notifiying the Observers" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(18, 3, matr)
            var controller = new Controller(field)
            controller.put(Some(player1),1, 1)
            controller.put(Some(player2),2, 1)
            controller.field.matr.cell(1, 1) shouldBe(Some(player1))
            controller.field.matr.cell(2, 1) shouldBe(Some(player2))
        }
    }
}