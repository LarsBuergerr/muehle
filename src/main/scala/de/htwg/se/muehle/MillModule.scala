package de.htwg.se.muehle

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import de.htwg.se.muehle.controller.ControllerComponent.ControllerBaseImpl._
import de.htwg.se.muehle.controller.ControllerComponent._
import de.htwg.se.muehle.model.FieldComponent.FieldBaseImpl.Field
import de.htwg.se.muehle.model.FieldComponent.FieldInterface


    class MillModule extends AbstractModule {

    override def configure() = {
        bind(classOf[ControllerInterface]).toInstance(Controller(new Field()))
        bind(classOf[FieldInterface]).toInstance(new Field())
    }
}