package main.scala.de.htwg.se.muehle
@main def Muehle: Unit =
  println("Das Muehle Spiel\n")
  println("---------------------------------------------\n")
  println("Player 1-----------------------------Player 2\n")
  println(mesh(1))
  println()
  println()
  println(mesh(2))
  println()
  println()
  println(mesh(3))
  //println(bar4(5))
val hashtag = "#"
val plus = "+"
val minus = "-"
val width1 = 21
val width2 = 6
val width3 = 14
val width4 = 7
val width5 = 15
val eol = sys.props("line.separator")
def bar1(lines: Int) = (("#" + "+" * width1) * 2 + "#" + eol) * (lines - 2)
def bar2(lines: Int) = (("+" + "-" * width1) * 2 + "+" + eol) * (lines - 2)
def bar3(lines: Int) = (("+" + "-" * width2) * (lines -2) + (("+" + "-" * width3) * 2) + ("+" + "-" * width2) * (lines -2) + "+") * (if(lines == 1){lines - lines}else if(lines == 2){lines - 1}else(lines - 2)) + eol
def bar4(lines: Int) = ("+" + "-" * width2) * (lines - 1) + (("#" + "+" * width4) * 2 + "#") + ("-" * width2 + "+") * (lines - 1) + eol
def bar5(lines: Int) = ((("+" + "-" * width2) * (lines -2) + ("#" + "+" * width3) * 2 + "#" + ("-" * width2 + "+") * (lines -2))) * (if(lines == 2){lines - 1} else{lines -2}) + eol
def bar6(lines: Int) = ("+" + "-" * width2) * (lines - 1) + ("+" + "-" * width5) + (("+" + "-" * width2)) * (lines - 1) + "+" + eol
def bar7(lines: Int) = ("#" + "+" * width2) * (lines - 1) + "#" + ("-" * width5) + ("#" + "+" * width2) * (lines - 1) + "#" + eol
def mesh(lines: Int) = (bar1(lines) + bar2(lines) *2 + bar5(lines) + bar3(lines)*2
            + bar4(lines) + bar6(lines)*2 + bar7(lines) + bar6(lines)*2 
            + bar4(lines) + bar3(lines)*2 + bar5(lines) + bar2(lines)*2 
            + bar1(lines))