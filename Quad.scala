
//아직까지 동작안됨.
object Quad {

  val decompressed = Array.fill(100, 100)(0)
  var depth = 0
  
  
  def main(args: Array[String]): Unit = {
    
    decompress("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb", 0, 0, 16)
   
    decompressed.foreach { row =>
      row.foreach { print _ }
      println()
    }
    
//    print(decompressed.map(_.mkString).mkString("\n"))
    
  }
  


  def decompress(str: String, y: Int, x: Int, size: Int): Unit = {

    if (str.charAt(depth) == 'w' || str.charAt(depth) == 'b') {
      for (i <- x until size)
        for (j <- i until size) decompressed(i)(j) = str.charAt(depth)
    }
    
    depth = depth + 1

    var half = size / 2
    decompress(str, x, y, half)
    decompress(str, x + half, y, half)
    decompress(str, x, y + half, half)
    decompress(str, x + half, y + half, half)

  }

}