object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val sth1 = Array.fill(3,3)(false)               //> sth1  : Array[Array[Boolean]] = Array(Array(false, false, false), Array(false
                                                  //| , false, false), Array(false, false, false))
  
  val sth2 = Array.ofDim[Boolean](3,3)            //> sth2  : Array[Array[Boolean]] = Array(Array(false, false, false), Array(fals
                                                  //| e, false, false), Array(false, false, false))
}