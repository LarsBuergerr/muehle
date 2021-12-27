package de.htwg.se.muehle

package model.FieldComponent



class isMill(xinput: Int, yinput: Int, stone: Option[Piece], matr: MuehlMatrix[Option[Piece]]):
    var x = xinput + 1
    var y = yinput + 1
    def muehlstrat(): Boolean = {
        if(x != 4 && y == 1) {
            return strat1();
        } else if(x != 4 && y == 3) {
            return strat2();
        } else if(x == 4) {
            return strat3();
        } else {
            return strat4();
        }
    }

    def strat1(): Boolean = {
        var newx = 
            if(x > 3) {
                8 - x;
            } else {
                x;
            }
        if((matr.mcell(newx, 1).equals(stone) && 
        matr.mcell(newx + (4 - newx), newx).equals(stone) &&
        matr.mcell(newx + 2 *(4 - newx), 1).equals(stone)) ||
        (matr.mcell(x, y).equals(stone) &&
        matr.mcell(x, y + 1).equals(stone) &&
        matr.mcell(x, y + 2).equals(stone))) {
            return true;
        } else {
            return false;
        }
    }

    def strat2(): Boolean = {
        var newx =
            if(x > 3) {
                8 - x;
            } else {
                x;
            }
        if((matr.mcell(newx, 3).equals(stone) &&
        matr.mcell(4, (7 - newx)).equals(stone) &&
        matr.mcell((8 - newx), 3).equals(stone)) ||
        (matr.mcell(x, y).equals(stone) &&
        matr.mcell(x, y - 1).equals(stone) &&
        matr.mcell(x, y - 2).equals(stone))) {
            return true;
        } else {
            return false;
        }
    }

    def strat3(): Boolean = {
        if(y < 4) {
            var newx = y
            if((matr.mcell(newx, 1).equals(stone) && 
            matr.mcell(newx + (4 - newx), newx).equals(stone) &&
            matr.mcell(newx + 2 *(4 - newx), 1).equals(stone)) ||
            (matr.mcell(4,1).equals(stone) &&
            matr.mcell(4, 2).equals(stone) &&
            matr.mcell(4, 3).equals(stone))) {
            return true;
        } else {
            return false;
        }
        } else {
            var newx = 7 - y
            if((matr.mcell(newx, 3).equals(stone) &&
            matr.mcell(4, (7 - newx)).equals(stone) &&
            matr.mcell((8 - newx), 3).equals(stone)) ||
            (matr.mcell(4, 4).equals(stone) &&
            matr.mcell(4,5).equals(stone) &&
            matr.mcell(4,6).equals(stone))) {
            return true;
        } else {
            return false;
        }
        }
    }

    def strat4(): Boolean = {
        if(x < 4) {
            if((matr.mcell(x, y).equals(stone) &&
            matr.mcell(x, y + 1).equals(stone) &&
            matr.mcell(x ,y - 1).equals(stone)) || 
            (matr.mcell(1, y).equals(stone) &&
            matr.mcell(2, y).equals(stone) &&
            matr.mcell(3, y).equals(stone))) {
                return true;
            } else {
                return false;
            }
        } else {
            if((matr.mcell(x, y).equals(stone) &&
            matr.mcell(x, y + 1).equals(stone) &&
            matr.mcell(x ,y - 1).equals(stone)) || 
            (matr.mcell(4, y).equals(stone) &&
            matr.mcell(5, y).equals(stone) &&
            matr.mcell(6, y).equals(stone))) {
                return true;
            } else {
                return false;
            }
        }
    }

