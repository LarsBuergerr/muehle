package de.htwg.se.muehle

package util

import model.Piece
import model.MuehlMatrix
import model.Field
import model.Piece._
import controller.Controller
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.muehle.aview.TUI

class TUISpec extends AnyWordSpec {
    "A tui" should {
        "contain a controller with a field and should be able to read input" in {
            val matr = new MuehlMatrix[Option[Piece]](3, None)
            val field = new Field(18, 3, matr)
            val controller = new Controller(field)
            val tui = new TUI
        }
    }
}