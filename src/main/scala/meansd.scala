package meansd

import scalanative.native._
import scala.collection.mutable.Map
import stdio._
import math.pow

object meansd {

  def main(args: Array[String]): Unit = {

    val breaks = List(0.0, 1.0, pow(2, 12), pow(2, 15), pow(2, 20), pow(2, 50))
    val bins = breaks zip breaks.tail

    val means = Map.empty[(Double, Double), MMean] withDefault { _ =>
      new MMean()
    }

    val x = stackalloc[Double]

    while (scanf(c"%lf", x) == 1) for {
      bin <- bins.find({ case (a, b) => a <= !x && !x < b })
      mean = means(bin)
    } means.update(bin, mean.update(!x))

    for (((a, b), meansd) <- means)
      println(s"$a - $b $meansd")

    // val m = new MMean
    // val x = stackalloc[Double]
    // while (scanf(c"%lf", x) == 1) {
    //   m.update(!x)
    // }
    // println(m)
  }

}
