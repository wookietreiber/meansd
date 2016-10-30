package meansd

import scalanative.native._
import stdio._

object Main {

  def main(args: Array[String]): Unit = {
    var n = 0L
    var mean = 0.0
    var m2 = 0.0
    var delta = 0.0
    val x = stackalloc[Double]

    while (scanf(c"%lf", x) == 1) {
      n += 1
      delta = !x - mean
      mean += delta / n
      m2 += delta * (!x - mean)
    }

    val sd = math.sqrt(m2 / (n - 1))

    val _ = printf(c"n=%ld ∅ %g ± %g\n", n, mean, sd)
  }

}
