package de.htwg.se.muehle

package model.FieldComponent



class MuehlStrat(xinput: Int, yinput: Int, stone: Option[Piece], matr: MuehlMatrix[Option[Piece]]):
    var x = xinput + 1
    var y = yinput + 1
    def muehlstrat(): Boolean = {
        if(x != 4 && y == 1) {
            printf("used: strat1");
            return strat1();
        } else if(x != 4 && y == 3) {
            println("used: strat2");
            return strat2();
        } else if(x == 4) {
            println("used: strat3");
            return strat3();
        } else {
            println("used: strat4");
            return strat4();
        }
    }

    def strat1(): Boolean = {
        printf(" with x = %d, y = %d\n", x, y);
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
            println("strategy 1 worked");
            return true;
        } else {
            println("strategy 1 didnt work");
            return false;
        }
    }

    def strat2(): Boolean = {
        printf(" with x = %d, y = %d\n", x, y);
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
            println("strategy 2 worked");
            return true;
        } else {
            println("strategy 2 didnt work");
            return false;
        }
    }

    def strat3(): Boolean = {
        printf(" with x = %d, y = %d\n", x, y);
        if(y < 4) {
            var newx = y
            if((matr.mcell(newx, 1).equals(stone) && 
            matr.mcell(newx + (4 - newx), newx).equals(stone) &&
            matr.mcell(newx + 2 *(4 - newx), 1).equals(stone)) ||
            (matr.mcell(4,1).equals(stone) &&
            matr.mcell(4, 2).equals(stone) &&
            matr.mcell(4, 3).equals(stone))) {
            println("strategy 3 (left) worked");
            return true;
        } else {
            println("strategy 3 (left) didnt work");
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
            println("strategy 3 (right) worked");
            return true;
        } else {
            println("strategy 3 (right) didnt work");
            return false;
        }
        }
    }

    def strat4(): Boolean = {
        printf(" with x = %d, y = %d\n", x, y);
        if(x < 4) {
            if((matr.mcell(x, y).equals(stone) &&
            matr.mcell(x, y + 1).equals(stone) &&
            matr.mcell(x ,y - 1).equals(stone)) || 
            (matr.mcell(1, y).equals(stone) &&
            matr.mcell(2, y).equals(stone) &&
            matr.mcell(3, y).equals(stone))) {
                println("strategy 4 (top) worked");
                return true;
            } else {
                println("strategy 4 (top) didnt work");
                return false;
            }
        } else {
            if((matr.mcell(x, y).equals(stone) &&
            matr.mcell(x, y + 1).equals(stone) &&
            matr.mcell(x ,y - 1).equals(stone)) || 
            (matr.mcell(4, y).equals(stone) &&
            matr.mcell(5, y).equals(stone) &&
            matr.mcell(6, y).equals(stone))) {
                println("strategy 4 (bottom) worked");
                return true;
            } else {
                println("strategy 4 (bottom) didnt work");
                return false;
            }
        }
    }

