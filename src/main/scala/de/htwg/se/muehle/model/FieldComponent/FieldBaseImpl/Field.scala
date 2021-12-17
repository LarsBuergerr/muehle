package de.htwg.se.muehle

package model.FieldComponent.FieldBaseImpl

import de.htwg.se.muehle.model.FieldComponent._
import scala.util.Success
import scala.util.Try
import scala.util.Failure
import Console.{RED, RESET}

case class Field(point: Option[Point], status: Int, size: Int, matr: MuehlMatrix[Option[Piece]]) extends FieldInterface:


    def this(status: Int, size: Int, matr: MuehlMatrix[Option[Piece]]) = this(None, status, size, matr)
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
        if(status > 0) then
            Gamestatus.put
        else if(status <= 0)
            Gamestatus.move
        else
            Gamestatus.take

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
        if(checkifempty(x, y) && checkstatusput()) {
            val newstatus = status - 1
            copy(None, newstatus, size, matr.replace(x, y, stone))
        }else {
            Console.println(s"${RED}Field not empty or no playstones left\nPlease try another field or move one of yours stones${RESET}")
            this
        }
    }

    def select(x: Int, y: Int): Field =
        copy(Some(Point(x, y)), status, size, matr)


    def move(stone: Option[Piece], x: Int, y: Int, xnew: Int, ynew: Int) = {
        if(checkifempty(xnew, ynew) && checkstatusmove()) {
            val newstatus = status - 1
            copy(None, newstatus, size, matr.replace(x, y, None).replace(xnew, ynew, stone))
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

    def checkstatusmove(): Boolean = {
        Try {
            (gamestatus.equals(Gamestatus.move))
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }

    def checkstatusput(): Boolean = {
        Try {
            (gamestatus.equals(Gamestatus.put))
        } match {
            case Success(x) => x
            case Failure(y) => false
        }
    }

    def checktake(): Boolean = {
        return true
    }


    def take(stone: Option[Piece], x: Int, y: Int) = {
        copy(None, status, size, matr.replace(x, y, None))
    }
