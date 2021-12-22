package de.htwg.se.muehle

package util

import model.FieldComponent._
import model.FieldComponent.FieldBaseImpl._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.muehle.aview.TUI

class TUISpec extends AnyWordSpec {
    "A tui" should {
        "contain a controller with a field and should be able to read input" in {
            val matr = new MuehlMatrix[Option[Piece]](3, None)
            val field = new Field(18, 3, matr)
            val controller = new Controller(field)
            val tui = new TUI(controller)
        }
    }
}