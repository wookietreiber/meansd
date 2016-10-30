package meansd

class MMean(var n: Long = 0, var mean: Double = 0, var m2: Double = 0) {
  def update(x: Double): this.type = {
    val delta = x - mean
    n += 1
    mean += delta / n
    m2 += delta * (x - mean)
    this
  }

  override def toString: String = {
    val sd = math.sqrt(m2 / (n - 1))
    s"n=$n ∅ $mean ± $sd"
  }
}
