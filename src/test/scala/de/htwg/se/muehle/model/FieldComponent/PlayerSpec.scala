package de.htwg.se.muehle

package model.FieldComponent

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec


class PlayerSpec extends AnyWordSpec {
    "class Player" should {
        "have 2 values for the mount of stones for every player" in {
            val test = Player(9, 9)
            test.player1 should be (9)
            test.player2 should be (9)
        }
    }
}