package de.htwg.se.muehle

package model.FieldComponent

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import model.FieldComponent._
import model.FieldComponent.FieldBaseImpl._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImpl._


class PointSpec extends AnyWordSpec {
    "a Point" should {
        "have a X-Cordinate and a Y-Cordinate" in {
            val test = Point(1, 1)
            test.x should be (1)
            test.y should be (1)  
        }
    }
} 