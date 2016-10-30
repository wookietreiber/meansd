package meansd

import scalanative.native._
import stdio._

object meansd {

  def main(args: Array[String]): Unit = {
    val m = new MMean
    val x = stackalloc[Double]

    while (scanf(c"%lf", x) == 1) {
      m.update(!x)
    }

    println(m)
  }

}
