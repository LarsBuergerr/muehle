package main.scala.de.htwg.se.muehle.model
import Piece._
import MuehlMatrix._
import Field._


def put(width: Int, size: Int, space: Int, matr: MuehlMatrix[Option[Piece]]): String = {
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