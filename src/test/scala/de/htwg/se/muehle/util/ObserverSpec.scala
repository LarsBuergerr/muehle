package de.htwg.se.muehle

package util

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class ObserverSpec extends AnyWordSpec {
    
    class observabletester extends Observable {}

    class observertester(observable: Observable) extends Observer {
        val o = observable
        var n = 0
        override def update: Unit = {n = n + 1}
    }

    "An Observer" should {
        "observe the others, perceive changes and notify them" in {
            val observable = new observabletester
            val observer1 = new observertester(observable)
            val observer2 = new observertester(observable)

            observer1.o.add(observer1)
            observable.subscribers should contain(observer1)
            observer2.o.add(observer2)
            observable.subscribers should contain(observer2)

            observable.notifyObservers

            observer1.n should be(1)
            observer2.n should be(1)

            observer1.o.remove(observer1)
            observer2.o.remove(observer2)
        }
    }
}