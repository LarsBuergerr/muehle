package de.htwg.se.muehle
package model

import scala.annotation.switch


case class Field(status: Int, size: Int, matr: MuehlMatrix[Option[Piece]]):

    val corner = "#"
    val top = "-"
    val side = "|"
    val eol = sys.props("line.separator") 
    val playerstatus = 
        if(status % 2 == 0) then
            0
        else
            1
    val gamestatus =
        if(status > 0) then
            0
        else
            1
    import Piece._

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
        if(gamestatus == 0) {
            val newstatus = status - 1
            if ((matr.size / 2) == x) {
                copy(newstatus, size, matr.replaceMid(y, stone))
            } else {
                if((matr.size / 2) < x) {
                    copy(newstatus, size, matr.replace(x - 1, y, stone))
                } else {
                    copy(newstatus, size, matr.replace(x, y, stone))
                }
            }
        } else if(gamestatus == 1) {
            println("Only move Stones")
            this
        } else {
            println("take one Stone")
            this
        }
    }

    def move(stone: Option[Piece], x: Int, y: Int) = {
        if(gamestatus == 1) {
            if ((matr.size / 2) == x) {
                copy(status, size, matr.replaceMid(y, stone))
            } else {
                if((matr.size / 2) < x) {
                    copy(status, size, matr.replace(x - 1, y, stone))
                } else {
                    copy(status, size, matr.replace(x, y, stone))
                }
            } 
        } else if(gamestatus == 0) {
            println("Only place stones")
            this
        } else {
            println("take one Stone")
            this
        }
    }

    //def take(x: Int, y: Int) = {
    //    if ((matr.size / 2) == x) {
    //        copy(status, size, matr.replaceMid(y, None))
    //    } else {
    //        if((matr.size / 2) < x) {
    //            copy(status, size, matr.replace(x - 1, y, None))
    //        } else {
    //            copy(status, size, matr.replace(x, y, None))
    //        }
    //    } 
    //}

