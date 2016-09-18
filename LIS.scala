

object LIS {

  def main(args: Array[String]): Unit = {
    println(lis(Array(3,2,1,7,5,4,2,6)))
  }

  def lis(array: Array[Int]): Int = {

    if (array.isEmpty) return 0
    var result = 0

    for (i <- 0 until array.size) {
      var B: Array[Int] = Array()
      for (j <- i + 1 until array.size) {
        if (array(i) < array(j)) B = B :+ array(j)
      }
      result = Math.max(result, 1 + lis(B))
    }
    return result

  }

}