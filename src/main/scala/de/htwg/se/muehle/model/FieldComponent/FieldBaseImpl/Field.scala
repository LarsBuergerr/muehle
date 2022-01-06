package de.htwg.se.muehle

package model.FieldComponent.FieldBaseImpl

import de.htwg.se.muehle.model.FieldComponent._
import scala.util.Success
import scala.util.Try
import scala.util.Failure
import Console.{RED, RESET}

case class Field(player: Player, mill: Int, point: Option[Point], status: Int, size: Int, matr: MuehlMatrix[Option[Piece]]) extends FieldInterface:


    def this(status: Int, size: Int, matr: MuehlMatrix[Option[Piece]]) = this(Player(1, 1), 0 , None, status, size, matr)
    val p1 = player.player1
    val p2 = player.player2
    val corner = "#"
    val top = "-"
    val side = "|"
    val eol = sys.props("line.separator") 
    val playerstatus = 
        if (status % 2 == 0) then
            Piece.player1
        else
            Piece.player2

    val gamestatus =
        if(mill == 0) {
            if(status > 0) then
            Gamestatus.put
        else
            Gamestatus.move
        } else {
            Gamestatus.take
        }

    def line(width: Int, depth: Int, pieces: Vector[Option[Piece]]): String = {
        (pieces.take(depth - 1).map(p => p.getOrElse("#").toString + top * width)).mkString + pieces.last.getOrElse("#").toString
    }
    def lineWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]]): String = {
        line(width, depth, pieces.take(pieces.size / 2)) + " " * space + line(width, depth, pieces.takeRight(pieces.size / 2))
    }
    def wallWBar(width: Int, space: Int, depth: Int): String = {
        if depth == 0 then
            side + " " * width + side + " " * width + side
        else
            side + " " * space + wallWBar(width, space, depth - 1) + " " * space + side
    }
    def wallWWall(width: Int, space: Int, depth: Int): String = {
        if depth == 1 then
            side + " " * width + side
        else
            side + " " * space + wallWWall(width, space, depth - 1) + " " * space + side
    }
    def wallWLine(width: Int, space: Int, depth: Int, pieces: Vector[Option[Piece]]): String = {
        if depth == 0 then
            line(width, 3, pieces)
        else
            side + " " * space + wallWLine(width, space, depth - 1, pieces) + " " * space + side
    }

    def mesh(): String= {
        var width = size * 4
        var space = 3
        var str = line(width, 3, matr.rows(0)) + eol
        for (i <- 1 to size) {
            if i < size then
                str = str + wallWBar(width - ((i - 1) * (space + 1)), space, i - 1) + eol
                str = str + wallWLine(width - (i * (space + 1)), space, i, matr.rows(i)) + eol
            else
                str = str + wallWWall((width - ((size - 1) * (space + 1))) * 2 + 1, space, size) + eol
                str = str + lineWLine(space, (width - (size - 1) * (space + 1)) * 2 + 1, size, matr.middle) + eol
        }
        var j = size
        var n = (matr.size / 2) - 1
        while (j > 0) {
            if j < size then
                str = str + wallWLine(width - (j * (space + 1)), space, j, matr.rows(n)) + eol
                str = str + wallWBar(width - ((j - 1) * (space + 1)), space, j - 1) + eol
            else
                str = str + wallWWall((width - ((size - 1) * (space + 1))) * 2 + 1, space, size) + eol
            j = j - 1
            n = n + 1
        }
        str = str + line(width, 3, matr.rows(matr.size - 1)) + eol
        return str
    }

    def put(stone: Option[Piece], x: Int, y: Int) = {
        if(checkput(x, y)) {
            val newstatus = status - 1
            val newmatr = matr.replace(x, y, stone)
            if(isMill(x, y, stone, newmatr).muehlstrat()) {
                copy(Player(p1, p2), 1, None, status, size, newmatr)
            } else {
                copy(Player(p1, p2), 0, None, newstatus, size, newmatr)
            }
        }else {
            Console.println(s"${RED}Field not empty or no playstones left\nPlease try another field or move one of yours stones${RESET}")
            this
        }
    }

    def select(x: Int, y: Int): Field =
        copy(Player(p1, p2), 0, Some(Point(x, y)), status, size, matr)


    def move(stone: Option[Piece], x: Int, y: Int, xnew: Int, ynew: Int) = {
        if(checkmove(x, y, xnew, ynew)) {
            val newstatus = status - 1
            val newmatr = matr.replace(x, y, None).replace(xnew, ynew, stone)
            if(isMill(xnew, ynew, stone, newmatr).muehlstrat()) {
                copy(Player(p1, p2), 1, None, status, size, newmatr)
            } else {
                copy(Player(p1, p2), 0, None, newstatus, size, newmatr)
            }
        } else {
            Console.println(s"${RED}Field not empty or playstone left\nPlease try another field or put one of your remaining stones${RESET}")
            this
        }
    }

    def checkifempty(x: Int, y: Int): Boolean = {
        Try {
            matr.checkcell(x, y).equals(None)
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }

    def checkmove(x: Int, y: Int, newx: Int, newy: Int): Boolean = {
        Try {
            (gamestatus.equals(Gamestatus.move) &&
            checkifempty(newx, newy) &&
            (matr.checkcell(x, y).equals(Some(playerstatus))) &&
            inBounds(x, y) &&
            isValidMove(x, y ,newx, newy).movestrat())
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }

    def checkput(x: Int, y: Int): Boolean = {
        Try {
            (gamestatus.equals(Gamestatus.put) &&
            checkifempty(x, y) &&
            inBounds(x, y))
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }

    def inBounds(x: Int, y: Int): Boolean = {
        if(x > 6) {
            return false;
        } else {
            if(x == 3) {
                if(y > 5) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if(y > 2) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    def checktake(stone: Option[Piece], x: Int, y: Int): Boolean = {
        Try {
            (gamestatus.equals(Gamestatus.take) && 
            (!matr.checkcell(x, y).equals(Some(playerstatus)) &&
            !matr.checkcell(x, y).equals(None)) && 
            !isMill(x, y, Some(Piece.player1), matr).muehlstrat() &&
            !isMill(x, y, Some(Piece.player2), matr).muehlstrat() &&
            inBounds(x, y))
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }


    def take(stone: Option[Piece], x: Int, y: Int) = {
        if(checktake(stone, x, y)) {
            val newstatus = status - 1
            if(playerstatus.equals(Piece.player2)) {
                copy(Player(p1 - 1, p2), 0, None, newstatus, size, matr.replace(x, y, None))
            } else {
                copy(Player(p1, p2 - 1), 0, None, newstatus, size, matr.replace(x, y, None))
            }
            
        } else {
            Console.println(s"${RED}Cannot take this Stone or arent allowed to take a stone${RESET}")
            this
        }
    }

