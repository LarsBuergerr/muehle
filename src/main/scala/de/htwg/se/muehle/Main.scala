package main.scala.de.htwg.se.muehle

import scala.io.StdIn.readLine
import scala.annotation.meta.field


@main def Muehle: Unit =

    import model.MuehlMatrix
    import model.Piece
    import model.Piece._
    import model.Field._
    import model.put

    print("Welcome to the muehle-game, please insert your desired field size [standart = 3]: ");
    var line = readLine()
    println()
    var size = line.toInt
    var matr = new MuehlMatrix[Option[Piece]](size, None)
    val field = put(size * 4, size, 3, matr)
    print(field)
//    val width = 12
//    val space = 3
//    val size = 3
//    val depth = size * 2
//    
//    var matr = new MuehlMatrix[Option[Piece]](size, None)
//
//    val str = update(12, 3, 3, matr)
//
//    print(str)
//
//    matr = matr.replace(0, 1, Some(player1))
//
//    val tmp = update(12, 3, 3, matr)
//
//    print(tmp)
