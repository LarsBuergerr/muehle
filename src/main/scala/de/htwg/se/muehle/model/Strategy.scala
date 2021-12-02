package de.htwg.se.muehle

package model


case class context(status: Int) {
    var strategy = 
        if (status % 2 == 0) then
            strategy1
        else
            strategy2

    def strategy1 = Piece.player1

    def strategy2 = Piece.player2
}

