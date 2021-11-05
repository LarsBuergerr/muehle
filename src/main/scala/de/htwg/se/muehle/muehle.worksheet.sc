val corner = "#"
val top = "-"
val side = "|"
val eol = sys.props("line.separator")

def lines(width: Int, space: Int, depth: Int): String = {
    if depth == 0 then
        ((corner + top * width) * 2) + corner
    else
        lines(width, space, depth - 1) + " " * space + lines(width, space, 0)
}

def wall(width: Int, depth: Int): String = {
    " " + width + side + " " * width
}

def wallWall(width: Int,space: Int, depth: Int): String = {
    if depth == 0 then
        side + wall(width, depth)
    else
        side + " " * space + wallWall(width,space, depth -1) + " " * space + side
}

def wallWLine(width: Int, space: Int, depth: Int): String = {
    if depth == 0 then
        lines(width, 0, 0)
    else
        side + " " * space + wallWLine(width, space, depth - 1) + " " * space + side
}

val width = 12
val space = 3
val depth = 3

print(lines(width * depth, space, 0) + eol +
    wallWall(width, space, depth - depth)+ eol +
    wallWLine(width - depth -(depth - 1) * space + 1 + space % 2, space, depth - (depth - 1))+ eol +
    wallWall(width - depth -(depth -1) * space + 1 + space % 2, space, depth - (depth - 1)) + eol)
