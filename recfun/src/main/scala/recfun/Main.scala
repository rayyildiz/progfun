package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def findAbove(currentRow : Int, currentColumn:Int): Int = {
      if ( currentColumn == 0 || currentRow == 0 ||  currentColumn == currentRow  ) return 1;

      return findAbove( currentRow-1, currentColumn -1) + findAbove(currentRow-1, currentColumn) ;
    }

    var result = 1;

    if ( r > 0 && c > 0){
      if ( c == r) result = 1;
      else result = findAbove( r-1, c -1) + findAbove(r-1, c);
    }

    return result;
  } 

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var result = false

    if ( chars != null && !chars.isEmpty){
      var numberOfP = 0;
      chars.foreach((c: Char) =>{
        if ( c == '(' && numberOfP >= 0) numberOfP +=1;
        if ( c == ')') numberOfP -=1;
      });

      result = (numberOfP == 0);
    }

    return result;
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
