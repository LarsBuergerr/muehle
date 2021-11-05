
def teststring = "ichhoffedasfunktioniert"
def splittedstring = teststring.toArray
println(splittedstring(1))


val bar1 = "#+++++++#+++++++#"
val bar2 = "+---------------+"
val bar3 = "+---------------+"
val bar4 = "#---------------#"
val bar5 = "+---------------+"
val bar6 = "+---------------+"
val bar7 = "#+++++++#+++++++#"

val v1 = bar1.toVector
val v2 = bar2.toVector
val v3 = bar3.toVector
val v4 = bar4.toVector
val v5 = bar5.toVector
val v6 = bar6.toVector
val v7 = bar7.toVector

def Field = (v1, v2, v3, v4, v5, v6, v7)

Field(3)(0)


    enum Piece(name: String):
        override def toString: String = name
        case player1 extends Piece("w")
        case player2 extends Piece("B")
    val hashtag = "#"
    val plus = "+"
    val minus = "-"
    val width1 = 21
    val width2 = 6
    val width3 = 14
    val width4 = 7
    val width5 = 15
    val eol = sys.props("line.separator")
    def bar1(lines: Int, change: Vector[Option[Piece]]) = (change.take(change.size-1).map( p => p.getOrElse("#").toString + "-" * width1).mkString + change.last.getOrElse("#").toString + eol) * (lines - 2)
    import Piece._
    print(bar1(2, Vector(Some(player1), None)))
