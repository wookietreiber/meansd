package meansd

import scalanative.native._
import stdio._

@struct class IMean (val n: Long = 0, val mean: Double = 0, val m2: Double = 0) {
  def update(x: Double): IMean = {
    val nn = n + 1
    val delta = x - mean
    val nmean = mean + delta / nn
    val nm2 = m2 + delta * (x - nmean)

    new IMean(nn, nmean, nm2)
  }

  def print(): Int = {
    val sd = math.sqrt(m2 / (n - 1))
    printf(c"n=%ld ∅ %g ± %g\n", n, mean, sd)
  }
}
