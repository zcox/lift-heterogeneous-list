package code.snippet

//import net.liftweb.util._
import net.liftweb.util.Helpers._
import code.model._
import scala.xml._

class Things {
  def render: NodeSeq => NodeSeq = "*" #> Things.data.map(bind)

  def bind(t: Thing): NodeSeq => NodeSeq = t.other match {
    //this approach works, but doesn't scale well to more Thing types
    //case o1: Other1 => ".other1 *" #> bind(o1) & ".other2" #> NodeSeq.Empty
    //case o2: Other2 => ".other2 *" #> bind(o2) & ".other1" #> NodeSeq.Empty

    //the class!=other1 part doesn't work...
    //case o1: Other1 => "class=other1 *" #> bind(o1) & "class!=other1" #> NodeSeq.Empty
    //case o2: Other2 => "class=other2 *" #> bind(o2) & "class!=other2" #> NodeSeq.Empty

    //this doesn't bind anything to the inner template...
    case o1: Other1 => ".other1 ^^" #> bind(o1)
    case o2: Other2 => ".other2 ^^" #> bind(o2)
  }

  def bind(o1: Other1): NodeSeq => NodeSeq = ".text *+" #> o1.text
  def bind(o2: Other2): NodeSeq => NodeSeq = ".number *+" #> o2.number
}
