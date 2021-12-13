package de.htwg.se.muehle
package model

case class MuehlMatrix[T](rows: Vector[Vector[T]], middle: Vector[T]):
    def this(size: Int, filling: T) = this((Vector.tabulate(size * 2, 3) { (rows, col) => filling}), Vector.fill(size * 2)(filling))
    
    val size: Int = rows.size

    def cell(row: Int, col: Int): T = rows(row)(col)

    def mid(col: Int): T = middle(col)

    def fill(filling: T): MuehlMatrix[T] = copy((Vector.tabulate(size, 3) { (row, col) => filling}), Vector.fill(size)(filling))

    def replace(row: Int, col: Int, fill: T): MuehlMatrix[T] =
        //printf("x Value in muehlmatrix: %d\n", row)
        //printf("y Value in muehlmatrix: %d\n", col)
        if((size / 2) < row) then
            copy(rows.updated(row - 1, rows(row - 1).updated(col, fill)))
        else
            copy(rows.updated(row, rows(row).updated(col, fill)))


    def replaceMid(col: Int, fill: T): MuehlMatrix[T] = copy(rows, middle.updated(col, fill))