object demo {
  @main def test: Unit =
    println("Hello world!")

    val x = 10

    val y = 20

    printf("Value of X = %d\n", x)
    printf("Value of Y = %d\n", y)

    val z = x + y
    printf("Value of Z = %d\n", z)

    def msg = "I was compiled by Scala 3. :)"

    def addInt(a: Int, b: Int): Int = {
      var sum: Int = 0
      sum = a + b

      return sum
    }
    val sum = addInt(4, 6)
    printf("sum-function: %d\n", sum)

    def strtest = """This is a test-string 
its also a multiline string
this is very funny to programm :)
"""
    printf(strtest)
    printf("bin drinn")
}
