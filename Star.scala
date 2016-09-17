

object Star {
  
    var cache = Array.fill[Boolean](101,101)(false)
  var W:String = ""
  var S:String = ""
  
  
    def main(args: Array[String]): Unit = {
      W = "******a"
      S = "aaaaaaaaaab"
      matches3(0,0)
  }
  
  // 1.when wildcard and string don't match, FAIL
  // 2.when w reaches the end, pattern does not have any *
  // 3.when s reaches the end, pattern does not match except remaining Ws are *
  // 4.when w(pos) is *, check remaining strings. 
  
    //NO memoization
  def matches2(w:String, s:String):Boolean = {
    
    var pos = 0
    
    while(pos < s.size && pos < w.size) {
      if (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos) ) pos = pos + 1
    }
      
    if(pos == w.size) return pos == s.size
    
    if(w.charAt(pos) == '*') {
      for(skip <- 0 to s.size if (pos+skip) <= s.size) {
        if(matches2(w.substring(pos+1),s.substring(pos+skip))) return true
      }
    }
    
    return false
      
  }
  
  
    //YES memoization
  

  def matches3 (w:Int, s:Int):Boolean = {
    
    var w2 = w
    var s2 = s
    
    var result = cache(w)(s)
    if(result != false) return result
    
    while(s < S.size && w < W.size && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
      w2 = w2 + 1
      s2 = s2 + 1  
    }
    
    if(w2 == W.size) {
      cache(w2)(s2) = (s2 == S.size)
      return cache(w2)(s2)
    }
    
    var skip = 0
    
    if(W.charAt(w2) == '*'){
      while(skip + s2 <= S.size) {
        skip = skip + 1
        if(matches3(w2+1, s2+skip)) {
          cache(w2)(s2) = true
          return true
        }
      }
    }
    
    cache(w)(s) = false
    return false
    
      
  }
  
  
}