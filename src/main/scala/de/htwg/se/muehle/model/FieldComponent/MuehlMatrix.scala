package de.htwg.se.muehle

package model.FieldComponent

case class MuehlMatrix[T](rows: Vector[Vector[T]], middle: Vector[T]):
    def this(size: Int, filling: T) = this((Vector.tabulate(size * 2, 3) { (rows, col) => filling}), Vector.fill(size * 2)(filling))
    
    val size: Int = rows.size

    def cell(row: Int, col: Int): T = rows(row)(col)

    def mid(col: Int): T = middle(col)

    def checkcell(row: Int, col: Int): T = 
        if((size / 2) == row) {
            mid(col)
        } else if((size / 2) < row) {
            cell(row - 1, col)
        } else {
            cell(row, col)
        }

    def mcell(rowi: Int, coli: Int): T = 
        var row = rowi - 1;
        var col = coli - 1;
        if((size / 2) == row) {
            mid(col)
        } else if((size / 2) < row) {
            cell(row - 1, col)
        } else {
            cell(row, col)
        }

    def fill(filling: T): MuehlMatrix[T] = copy((Vector.tabulate(size, 3) { (row, col) => filling}), Vector.fill(size)(filling))

    def replaceMatr(row: Int, col: Int, fill: T): MuehlMatrix[T] =
        copy(rows.updated(row, rows(row).updated(col, fill)))

    def replaceMid(col: Int, fill: T): MuehlMatrix[T] = copy(rows, middle.updated(col, fill))

    def replace(row: Int, col: Int, fill: T): MuehlMatrix[T] =
        if((size / 2) == row) {
            replaceMid(col, fill)
        } else if((size / 2) < row) {
            replaceMatr(row - 1, col, fill)
        } else {
            replaceMatr(row, col, fill)
        }