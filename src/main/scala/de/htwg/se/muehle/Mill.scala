/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/*Ich schieb das Fach auf ein späteres Semester, heist falls die Überlegung war uns mehr
als einen Punkt in dem Review zu geben was eh höchst unwarscheinlich ist weil das Projekt
nicht so noice war :) lasst das lieber*/
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

package de.htwg.se.muehle

import com.google.inject.Guice
import scala.io.StdIn.readLine
import scala.annotation.meta.field
import model.FieldComponent.FieldBaseImpl.Field
import model.FieldComponent._
import controller.ControllerComponent.ControllerBaseImpl._
import controller.ControllerComponent._
import aview.TUI
import aview.gui.MainGui


@main def Muehle: Unit =

    print("WELCOME TO THE MUEHLE-GAME\n\n\n");
    val injector = Guice.createInjector(new MillModule)
    val field = injector.getInstance(classOf[FieldInterface])
    val controller = injector.getInstance(classOf[ControllerInterface])
    //val field = new Field()
    //val controller = new Controller(field)
    val tui = TUI(controller)
    val gui = MainGui(controller)
    gui.startup(Array())
    tui.run