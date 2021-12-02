package de.htwg.se.muehle
package model

object Gamestatus extends Enumeration {
    type Gamestatus = Value
    val put, move, take = Value
}