public class ZKim{
  public static int[] strat(int[][] b, SavedData memory){
    int[] rv = {(int)(Math.random()*b.length),(int)(Math.random()*b[0].length)};
    while(b[rv[0]][rv[1]]!=0){
      rv[0] = (int)(Math.random()*b.length);
      rv[1] = (int)(Math.random()*b[0].length);
    }
    return rv;
  }
}
