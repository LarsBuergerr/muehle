package de.htwg.se.muehle

package model.FieldComponent

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.FieldComponent._

class GamestatusSpec extends AnyWordSpec {

    "Gamestatus" should {
        "return the current  Gamestatus" in {
            val statusput = Gamestatus.put
            val statusmove = Gamestatus.move
            val statustake = Gamestatus.take
            statusput shouldBe (Gamestatus.put)
            statusmove shouldBe (Gamestatus.move)
            statustake shouldBe (Gamestatus.take)
        }
    }
}
