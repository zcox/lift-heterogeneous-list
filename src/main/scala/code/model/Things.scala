package code.model

case class Thing(other: Other)

abstract class Other
case class Other1(text: String) extends Other
case class Other2(number: Int) extends Other

object Things {
  val data = List(
    Thing(Other1("something")), 
    Thing(Other2(123)), 
    Thing(Other1("another one")),
    Thing(Other2(456))
  )
}
