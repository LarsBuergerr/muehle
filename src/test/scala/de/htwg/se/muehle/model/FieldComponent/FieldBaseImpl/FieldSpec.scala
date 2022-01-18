package de.htwg.se.muehle

package model.FieldComponent.FieldBaseImpl

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import model.FieldComponent._
import controller.ControllerComponent._
import controller.ControllerComponent.ControllerBaseImpl._


class FieldSpec extends AnyWordSpec {

    "A field" should {
        "contain a line(width: Int, depth: Int, pieces: Vector[Option[Piece]]) which" should {
            "produce a String containing - and #, W or B depending on parameters width and depth" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.line(2, 2, Vector(None, None)) should be ("#--#")
                field.line(3, 3, Vector(Some(Piece.player1), Some(Piece.player2), Some(Piece.player2))) should be ("W---B---B")
                field.line(4, 4, Vector(None, None, Some(Piece.player1), None)) should be ("#----#----W----#")
                field.line(1, 5, Vector(None, None, None, None, None)) should be ("#-#-#-#-#")
                field.line(5, 2, Vector(None, None)) should be ("#-----#")
                field.line(0, 4, Vector(None, None, None, Some(Piece.player2))) should be ("###B")
                field.line(6, 0, Vector(None)) should be ("#")
            }
        }
        "contain a lineWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]]) which" should {
            "produce a String containing 2 lines with parameters width, space and depth" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.lineWLine(2,2,2, Vector(None, None, None, None)) should be ("#--#  #--#")
                field.lineWLine(4,1,3, Vector(Some(Piece.player1), Some(Piece.player2),Some(Piece.player1), Some(Piece.player2),Some(Piece.player1), Some(Piece.player2))) should be
                    ("W----B----W B----W----B")
                field.lineWLine(1,4,3, Vector(None, None, None, None, None, None)) should be
                    ("#-#-#    #-#-#")
                field.lineWLine(1,5,1, Vector(None, None)) should be
                    ("#     #")
            }
        }
        "contain a wallWBar(width: Int, space: Int, depth: Int) which" should {
            "produce a String containing | and spaces with parameters width, space, and depth" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.wallWBar(1,2,1) should be ("|  | | |  |")
                field.wallWBar(3,3,3) should be ("|   |   |   |   |   |   |   |   |")
                field.wallWBar(10, 10, 0) should be ("|          |          |")
                field.wallWBar(2, 2, 1) should be("|  |  |  |  |")
            }
        }
        "contain a wallWWall(width: Int, space: Int, depth: Int) which" should {
            "produce a String containing | and spaces with parameters, width, space and depth" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.wallWWall(2,2,2) should be ("|  |  |  |")
                field.wallWWall(2,2,1) should be ("|  |")
                field.wallWWall(5,5,1) should be ("|     |")
                field.wallWWall(0,0,3) should be ("||||||")
            }
        }
        "contain a wallWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]]) which" should {
            "produce a String containing |, -, (#, b or w) and spaces with parameters width, space and depth" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.wallWLine(1,1,1, Vector(None, None,None)) should be ("| #-#-# |")
                field.wallWLine(2,2,2, Vector(None, None,None)) should be ("|  |  #--#--#  |  |")
                field.wallWLine(3,5,0, Vector(None, None,None)) should be ("#---#---#")
                field.wallWLine(0,1,5, Vector(None, None,None)) should be ("| | | | | ### | | | | |")
            }
        }
        "contain a mesh() method which" should {
            "return a String looking like a muehle-field which size is depending on the size parameter" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                field.mesh() should be 
            ("""#------------#------------#
                |            |            |
                |   #--------#--------#   |
                |   |        |        |   |
                |   |   #----#----#   |   |
                |   |   |         |   |   |
                #---#---#         #---#---#
                |   |   |         |   |   |
                |   |   #----#----#   |   |
                |   |        |        |   |
                |   #--------#--------#   |
                |            |            |
                #------------#------------#""")
                val matr2 = new MuehlMatrix[Option[Piece]](6, None)
                val field2 = new Field()
                field2.mesh() should be
            ("""#------------------------#------------------------#
                |                        |                        |
                |   #--------------------#--------------------#   |
                |   |                    |                    |   |
                |   |   #----------------#----------------#   |   |
                |   |   |                |                |   |   |
                |   |   |   #------------#------------#   |   |   |
                |   |   |   |            |            |   |   |   |
                |   |   |   |   #--------#--------#   |   |   |   |
                |   |   |   |   |        |        |   |   |   |   |
                |   |   |   |   |   #----#----#   |   |   |   |   |
                |   |   |   |   |   |         |   |   |   |   |   |
                #---#---#---#---#---#         #---#---#---#---#---#
                |   |   |   |   |   |         |   |   |   |   |   |
                |   |   |   |   |   #----#----#   |   |   |   |   |
                |   |   |   |   |        |        |   |   |   |   |
                |   |   |   |   #--------#--------#   |   |   |   |
                |   |   |   |            |            |   |   |   |
                |   |   |   #------------#------------#   |   |   |
                |   |   |                |                |   |   |
                |   |   #----------------#----------------#   |   |
                |   |                    |                    |   |
                |   #--------------------#--------------------#   |
                |                        |                        |
                #------------------------#------------------------#""")
            }
        }
        "contain a put(stone: Option[Piece],x: Int, y: Int) which" should {
            "change the Entries in the given matrix by changing '#' to either 'B' or 'W' on the given Coordinates" in {
                val matr = new MuehlMatrix[Option[Piece]](3, None)
                val field = new Field()
                val updated1 = field.put(Some(Piece.player1), 0, 0).put(Some(Piece.player2), 3, 1).put(Some(Piece.player1), 5, 1)
                updated1.matr.cell(0, 0) should be (Some(Piece.player1))
                updated1.matr.mid(1) should be (Some(Piece.player2))
                updated1.matr.cell(4, 1) should be (Some(Piece.player1))
            }
        }  
    }
}