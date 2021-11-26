//package de.htwg.se.muehle
//
//package command
//
//import model.Piece
//import controller.Controller
//import javax.swing.undo.UndoManager
//
//trait Command[T]:
//    def noStep(t: T): T
//    def doStep(t: T): T
//    def undoStep(t: T): T
//    def redoStep(t: T): T
//
//
//class UndoManager[T]:
//    var undoStack: List[Command[T]]
//    var redoStack: List[Command[T]]
//    def doStep(t: T, command: Command[T]) =
//        undoStack = command :: undoStack
//        command.doStep(t)
//    def undoStep(t: T): T =
//        undoStack match {
//            case Nil => t
//            case head :: tack => {
//                val result = head.undoStep(t)
//                undoStack = stack
//                redoStack
//            }
//        }



//class PutCommand(stone: Option[Piece], x: Int, y: Int, controller: Controller) extends Command {
//    override def doStep: Unit = controller.field = controller.field.put(stone, x, y)
//    override def undoStep: Unit = controller.field = controller.field.put(None, x, y)
//    override def redoStep: Unit = controller.field = controller.field.put(stone, x, y)
//}


