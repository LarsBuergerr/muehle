import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class MuehleSpec extends AnyWordSpec:
  "Muehle" should {
    "have a bar1 as String of form '#+++++++++++++++++++++#+++++++++++++++++++++#'" in {
      bar1 should be("#+++++++++++++++++++++#+++++++++++++++++++++#" + eol)
    }
    "have a bar2 as String of form '+---------------------+---------------------+'" in {
      bar2 should be("+---------------------+---------------------+" + eol)
    }
    "have a bar3 as String of form '+------+--------------+--------------+------+'" in {
      bar3 should be("+------+--------------+--------------+------+" + eol)
    }
    "have a bar4 as String of form '+------+------#+++++++#+++++++#------+------+'" in {
      bar4 should be("+------+------#+++++++#+++++++#------+------+" + eol)
    }
    "have a bar5 as String of form '+------#++++++++++++++#++++++++++++++#------+'" in {
      bar5 should be("+------#++++++++++++++#++++++++++++++#------+" + eol)
    }
    "have a bar6 as String of form '+------+------+---------------+------+------+'" in {
      bar6 should be("+------+------+---------------+------+------+" + eol)
    }
    "have a bar7 as String of form '#++++++#++++++#---------------#++++++#++++++#'" in {
      bar7 should be("#++++++#++++++#---------------#++++++#++++++#" + eol)
    }
  }