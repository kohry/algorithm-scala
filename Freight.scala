import java.util.Scanner
import java.io.File


object Freight {
  
  var areFriends = Array.ofDim[Boolean](10,10)
  
  def main(args: Array[String]): Unit = {
    
    val sc = new Scanner(new File("input_text.txt"))
    val N = sc.nextInt() 
    
    for ( i <- 0 until N ) {
      
      var n = sc.nextInt()
      
      var friendCount = sc.nextInt()
      
      println("--------------")
      
      print("n " + n)
      println(" c " + friendCount)
      
      areFriends = Array.fill(10,10)(false)
      
      for ( j <- 0 until friendCount ) {
        var a = sc.nextInt()
        var b = sc.nextInt()
        areFriends(a)(b) = true
        areFriends(b)(a) = true
        
//        print("a " + a)
//        println(" b " + b)
        
      }
      
      var taken = Array.fill[Boolean](n)(false)
      
      for( x <- 0 until n ) {
        for (y <- 0 until n) {
//          print("x " + x)
//          println(" y " + y)
//          println(areFriends(x)(y))
        }
      }     
      
      val result = countPairings(taken, n)
      println(result)
      
    }//end main loop
    
  }//end main
  
  
  def countPairings(taken : Array[Boolean], n: Int) : Int = {
    
    var finished = true
    for(i <- 0 until n) if(!taken(i)) finished = false
    if(finished) return 1
    var result = 0
    
    for(i <- 0 until n) {
      for(j <- i until n) {
        if(!taken(i) && !taken(j) && areFriends(i)(j)) {
          taken(j) = true
          taken(i) = taken(j)
          result += countPairings(taken, n)
          taken(j) = false
          taken(i) = taken(j)
        }
      }
    }
    
    return result
    
    
  }
  
  
  
}