package de.htwg.se.muehle
package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import model.Field
import model.Piece._



class FieldSpec extends AnyWordSpec {

    "line(width: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
        "produce a String containing - and #, W or B depending on parameters width and depth" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(3, matr)
            field.line(2, 2, Vector(None, None)) should be ("#--#")
            field.line(3, 3, Vector(Some(player1), Some(player2), Some(player2))) should be ("W---B---B")
            field.line(4, 4, Vector(None, None, Some(player1), None)) should be ("#----#----W----#")
            field.line(1, 5, Vector(None, None, None, None, None)) should be ("#-#-#-#-#")
            field.line(5, 2, Vector(None, None)) should be ("#-----#")
            field.line(0, 4, Vector(None, None, None, Some(player2))) should be ("###B")
            field.line(6, 0, Vector(None)) should be ("#")
        }
    }
    "lineWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
        "produce a String containing 2 lines with parameters width, space and depth" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(3, matr)
            field.lineWLine(2,2,2, Vector(None, None, None, None)) should be ("#--#  #--#")
            field.lineWLine(4,1,3, Vector(Some(player1), Some(player2),Some(player1), Some(player2),Some(player1), Some(player2))) should be
                ("W----B----W B----W----B")
            field.lineWLine(1,4,3, Vector(None, None, None, None, None, None)) should be
                ("#-#-#    #-#-#")
            field.lineWLine(1,5,1, Vector(None, None)) should be
                ("#     #")
        }
    }
    "wallWBar(width: Int, space: Int, depth: Int)" should {
        "produce a String containing | and spaces with parameters width, space, and depth" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(3, matr)
            field.wallWBar(1,2,1) should be ("|  | | |  |")
            field.wallWBar(3,3,3) should be ("|   |   |   |   |   |   |   |   |")
            field.wallWBar(10, 10, 0) should be ("|          |          |")
            field.wallWBar(2, 2, 1) should be("|  |  |  |  |")
        }
    }
    "wallWWall(width: Int, space: Int, depth: Int)" should {
        "produce a String containing | and spaces with parameters, width, space and depth" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(3, matr)
            field.wallWWall(2,2,2) should be ("|  |  |  |")
            field.wallWWall(2,2,1) should be ("|  |")
            field.wallWWall(5,5,1) should be ("|     |")
            field.wallWWall(0,0,3) should be ("||||||")
        }
    }
    "wallWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
        "produce a String containing |, -, (#, b or w) and spaces with parameters width, space and depth" in {
            var matr = new MuehlMatrix[Option[Piece]](3, None)
            var field = new Field(3, matr)
            field.wallWLine(1,1,1, Vector(None, None,None)) should be ("| #-#-# |")
            field.wallWLine(2,2,2, Vector(None, None,None)) should be ("|  |  #--#--#  |  |")
            field.wallWLine(3,5,0, Vector(None, None,None)) should be ("#---#---#")
            field.wallWLine(0,1,5, Vector(None, None,None)) should be ("| | | | | ### | | | | |")
        }
    }
}