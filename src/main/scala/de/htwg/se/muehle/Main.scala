@main def Muehle: Unit =
  println("Das Muehle Spiel\n")
  println("---------------------------------------------\n")
  println("Player 1-----------------------------Player 2\n")
  println(mesh)
val hashtag = "#"
val plus = "+"
val minus = "-"
val width1 = 21
val width2 = 6
val width3 = 14
val width4 = 7
val width5 = 15
val eol = sys.props("line.separator")
def bar1 = ("#" + "+" * width1) * 2 + "#" + eol
def bar2 = ("+" + "-" * width1) * 2 + "+" + eol
def bar3 = ("+" + "-" * width2) + (("+" + "-" * width3) * 2) + ("+" + "-" * width2) + "+"  + eol
def bar4 = ("+" + "-" * width2) * 2 + (("#" + "+" * width4) * 2 + "#") + ("-" * width2 + "+") * 2 + eol
def bar5 = ("+" + "-" * width2) + ("#" + "+" * width3) * 2 + "#" + ("-" * width2 + "+") + eol
def bar6 = ("+" + "-" * width2) * 2 + ("+" + "-" * width5) + ("+" + "-" * width2) * 2 + "+" + eol
def bar7 = ("#" + "+" * 6) * 2 + "#" + ("-" * width5) + ("#" + "+" * 6) * 2 + "#" + eol
val mesh = (bar1 + bar2*2 + bar5 + bar3*2
            + bar4 + bar6*2 + bar7 + bar6*2 
            + bar4 + bar3*2 + bar5 + bar2*2 
            + bar1)

