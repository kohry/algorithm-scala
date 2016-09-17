

object Star {
    def main(args: Array[String]): Unit = {
    println(matches("thelordoftherings","t*"))
    
  }
  
    //customized 
  def matches(str: String, evaluator: String): Boolean = {
    str.contains(evaluator.replace("*", ""))
  }
  
  // 1.when wildcard and string don't match, FAIL
  // 2.when w reaches the end, pattern does not have any *
  // 3.when s reaches the end, pattern does not match except remaining Ws are *
  // 4.when w(pos) is *, check remaining strings. 
  
  def matches2(w:String, s:String):Boolean = {
    
    var pos = 0
    
    while(pos < s.size && pos < w.size && w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos) ) 
      pos = pos + 1
    
    if(pos == w.size) return pos == s.size
    
    if(w.charAt(pos) == '*') {
      for(skip <- 0 to s.size) {
        if(matches2(w.substring(pos+1),s.substring(pos+skip))) return true
      }
    }
    
    return false
      
  }
  
  
}