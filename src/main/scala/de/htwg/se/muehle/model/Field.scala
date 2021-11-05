package main.scala.de.htwg.se.muehle.model

object Field {
    val corner = "#"
    val top = "-"
    val side = "|"
    val eol = sys.props("line.separator")
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
}



