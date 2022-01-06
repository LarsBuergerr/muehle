import de.htwg.se.muehle.controller.ControllerComponent.ControllerBaseImpl._
import de.htwg.se.muehle.aview.gui.Tiles
import de.htwg.se.muehle.model.FieldComponent._
import de.htwg.se.muehle.model.FieldComponent.FieldBaseImpl._

var matr = new MuehlMatrix[Option[Piece]](3, None)
var field = new Field(18, 3, matr)
var controller = new Controller(field)
var Matr = Array.tabulate[Tiles](5, 2) { (row, col) => new Tiles(row, col, controller) }
var Mid = Array.tabulate[Tiles](5) { (col) => new Tiles(3, col, controller) }
