//package de.htwg.se.muehle
//
//package model
//
//import Field._
//import Piece._
//import org.scalatest.wordspec.AnyWordSpec
//import org.scalatest.matchers.should.Matchers._
//
//
//
//class FieldSpec extends AnyWordSpec {
//
//    "line(width: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
//        "produce a String containing - and #, W or B depending on parameters width and depth" in {
//            line(2, 2, Vector(None, None)) should be ("#--#")
//            line(3, 3, Vector(Some(player1), Some(player2), Some(player2))) should be ("W---B---B")
//            line(4, 4, Vector(None, None, Some(player1), None)) should be ("#----#----W----#")
//            line(1, 5, Vector(None, None, None, None, None)) should be ("#-#-#-#-#")
//            line(5, 2, Vector(None, None)) should be ("#-----#")
//            line(0, 4, Vector(None, None, None, Some(player2))) should be ("###B")
//            line(6, 0, Vector(None)) should be ("#")
//        }
//    }
//    "lineWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
//        "produce a String containing 2 lines with parameters width, space and depth" in {
//            lineWLine(2,2,2, Vector(None, None, None, None)) should be ("#--#  #--#")
//            lineWLine(4,1,3, Vector(Some(player1), Some(player2),Some(player1), Some(player2),Some(player1), Some(player2))) should be
//                ("W----B----W B----W----B")
//            lineWLine(1,4,3, Vector(None, None, None, None, None, None)) should be
//                ("#-#-#    #-#-#")
//            lineWLine(1,5,1, Vector(None, None)) should be
//                ("#     #")
//        }
//    }
//    "wallWBar(width: Int, space: Int, depth: Int)" should {
//        "produce a String containing | and spaces with parameters width, space, and depth" in {
//            wallWBar(1,2,1) should be ("|  | | |  |")
//            wallWBar(3,3,3) should be ("|   |   |   |   |   |   |   |   |")
//            wallWBar(10, 10, 0) should be ("|          |          |")
//            wallWBar(2, 2, 1) should be("|  |  |  |  |")
//        }
//    }
//    "wallWWall(width: Int, space: Int, depth: Int)" should {
//        "produce a String containing | and spaces with parameters, width, space and depth" in {
//            wallWWall(2,2,2) should be ("|  |  |  |")
//            wallWWall(2,2,1) should be ("|  |")
//            wallWWall(5,5,1) should be ("|     |")
//            wallWWall(0,0,3) should be ("||||||")
//        }
//    }
//    "wallWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]])" should {
//        "produce a String containing |, -, (#, b or w) and spaces with parameters width, space and depth" in {
//            wallWLine(1,1,1, Vector(None, None,None)) should be ("| #-#-# |")
//            wallWLine(2,2,2, Vector(None, None,None)) should be ("|  |  #--#--#  |  |")
//            wallWLine(3,5,0, Vector(None, None,None)) should be ("#---#---#")
//            wallWLine(0,1,5, Vector(None, None,None)) should be ("| | | | | ### | | | | |")
//        }
//    }
//}
