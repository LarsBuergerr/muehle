package de.htwg.se.muehle

package model.FieldComponent

class isValidMove(xinput: Int, yinput: Int, newxinput: Int, newyinput: Int):
    var oldx = xinput + 1
    var oldy = yinput + 1
    var newx = newxinput + 1
    var newy = newyinput + 1
    var newpoint = Point(newx, newy)

    def movestrat(): Boolean = {
        if(oldx != 4 && oldy == 1) {
            return strat1();
        } else if(oldx != 4 && oldy == 3) {
            return strat2();
        } else if(oldx == 4) {
            return strat3();
        } else {
            return strat4();
        }
    }

    def strat1(): Boolean = {
        var x = if(oldx > 3) {
            8 - oldx
        } else {
            oldx
        }

        if(newpoint.equals(Point(4, x)) || newpoint.equals(Point(oldx, oldy + 1))) {
            return true
        } else {
            return false
        }
    }

    def strat2(): Boolean = {
        var x = if(oldx > 3) {
            8 - oldx
        } else {
            oldx
        }

        if(newpoint.equals(Point(4, 7 - x)) || newpoint.equals(Point(oldx, oldy - 1))) {
            return true
        } else {
            return false
        }
    }

    def strat3(): Boolean = {
        var x = if(oldy < 4) {
            (4 - oldy)
        } else {
            (oldy - 3)
        }

        var y = if(oldy < 4) {
            1
        } else {
            3
        }
        if(newpoint.equals(Point(oldx - x, y)) || 
        newpoint.equals(Point(oldx + x, y)) ||
        ((newpoint.equals(Point(oldx, oldy + 1)) ||
        newpoint.equals(Point(oldx, oldy - 1))) && 
        (if(y == 1) {newpoint.y < 4} else {newpoint.y > 3}))) {
            return true
        } else {
            return false
        }
    }

    def strat4(): Boolean = {
        if(newpoint.equals(Point(oldx, oldy - 1)) ||
        newpoint.equals(Point(oldx, oldy + 1)) ||
        ((newpoint.equals(Point(oldx + 1, oldy)) ||
        newpoint.equals(Point(oldx - 1, oldy))) && 
        (if(oldx < 4) {newpoint.x < 4} else {newpoint.x > 4}))) {
            return true
        } else {
            return false
        }
    }