package de.htwg.se.muehle

package model.FieldComponent

trait FieldInterface {

    val player: Player

    val point: Option[Point]

    val status: Int

    val size: Int

    val matr: MuehlMatrix[Option[Piece]]

    val gamestatus: Gamestatus.Value

    val playerstatus: Piece

    def mesh(): String

    def put(stone: Option[Piece], x: Int, y: Int): FieldInterface

    def select(x: Int, y: Int): FieldInterface

    def move(stone: Option[Piece], x: Int, y: Int, xnew: Int, ynew: Int): FieldInterface

    def take(stone: Option[Piece], x: Int, y: Int): FieldInterface

    def getpoint() = point

    def getcell(x: Int, y: Int) = matr.checkcell(x, y)

    def checkmove(x: Int, y: Int, newx: Int, newy: Int): Boolean

    def checktake(stone: Option[Piece], x: Int, y: Int): Boolean
}