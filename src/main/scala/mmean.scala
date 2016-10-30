package meansd

import scalanative.native._
import stdio._

@struct class MMean (var n: Long = 0, var mean: Double = 0, var m2: Double = 0) {
  def update(x: Double): Unit = {
    val delta = x - mean
    n += 1
    mean += delta / n
    m2 += delta * (x - mean)
  }

  def print(): Int = {
    val sd = math.sqrt(m2 / (n - 1))
    printf(c"n=%ld ∅ %g ± %g\n", n, mean, sd)
  }
}
