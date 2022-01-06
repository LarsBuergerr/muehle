package de.htwg.se.muehle

package model.FieldComponent


import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImplementation._

class isValidMoveSpec extends AnyWordSpec {
    "isValidMove" should {
        "decide wether a move is valid or not" +
            " (if valid it returns true and if not it returns false)" in {
                val test_f1 = isValidMove(9, 9, 9, 9)
                val test_f2 = isValidMove(0, 0, 0, 0)
                val test_f3 = isValidMove(1, 1, 1, 3)
                val test_f4 = isValidMove(1, 1, 3, 3)
                val test_f5 = isValidMove(5, 2, 1, 3)
                test_f1.movestrat() should be(false)
                test_f2.movestrat() should be(false)
                test_f3.movestrat() should be(false)
                test_f4.movestrat() should be(false)
                test_f5.movestrat() should be(false)
                
                
                
                val test1 = isValidMove(0, 0, 0, 1)
                val test1_1 = isValidMove(4, 0, 4, 1)
                val test2 = isValidMove(1, 2, 1, 1)
                val test2_1 = isValidMove(4, 2, 3, 3)
                val test3 = isValidMove(3, 0, 3, 1)
                val test3_1 = isValidMove(3, 4, 3, 5)
                val test4 = isValidMove(1, 1, 2, 1)
                val test4_1 = isValidMove(1, 1, 0, 1)
                val test4_2 = isValidMove(1, 1, 1, 0)
                val test4_3 = isValidMove(1, 1, 1, 2)
                test1.movestrat() should be (true)
                test1_1.movestrat() should be (true)
                test2.movestrat() should be (true)
                test2_1.movestrat() should be (true)
                test3.movestrat() should be (true)
                test3_1.movestrat() should be (true)
                test4.movestrat() should be (true)
                test4_1.movestrat() should be (true)
                test4_2.movestrat() should be (true)
                test4_3.movestrat() should be (true)
        }  
    }
}