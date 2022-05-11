package util;
import java.util.Scanner;
public class ZSample{
  public static int[] strat(int[][] b, SavedData memory){
    // Pick the strategy you want to play.
    return strat2(b,memory);
  }
  public static int[] strat1(int[][] b, SavedData memory){
    // EXAMPLE: Move to the right of the last move every time.
    // How to use the memory:
    // The previous move is stored in memory.lastMove
    int[] prev = memory.lastMove;
    
    // If first move, place at row 0 col 0
    if(prev==null)
      return new int[] {0,0};
    // Place to the right of the prev move:
    int[] rv = {prev[0],(prev[1]+1)%b[0].length};
    return rv;
  }
  public static int[] strat2(int[][] b, SavedData memory){
    // How to maintain a list of all moves:
    // Pick one of the SavedData data types that would be appropriate.
    // Ex, int[][] or use the Object pointer o to point to an ArrayList.
    // Use a null check to see if this is the first move so you can initialize.
    // This example will use an int[][], and empty spaces will be null.
    if(memory.a==null){
      memory.a = new int[b.length * b[0].length][];
      // Currenty a = {null, null, ....}
    }
    // find the first null index
    int index=0;
    while(memory.a[index]!=null)
      index++;
    memory.a[index] = memory.lastMove;
    if(memory.lastMove != null)
      index++;
    // Choose a move
    int[] move = strat1(b,memory);
    // Your move also needs to go into memory.
    memory.a[index] = move;

    // For confirmation that moves are being saved:
    index = 0;
    while(memory.a[index]!=null){
      System.out.print("(" + memory.a[index][0] + "," + memory.a[index][1] + ")");
      index++;
    }
    System.out.println();
    
    return move;
  }
  public static int[] strat3(int[][] b, SavedData memory){
    // How to start off with a predefined set of moves:
    int[][] startingMoves = {{1,1},{2,2},{3,3},{4,4},{5,5}};
    // Loop through each move, making sure that spot on board is empty.
    for(int i=0; i<startingMoves.length; i++){
      if(b[startingMoves[i][0]][startingMoves[i][1]]==0){
        // End the function early on first available move.
        return startingMoves[i];
      }
    }
    // By this point, you know all spots have been taken,
    // so continue on with second part of your strategy.
    return strat1(b,memory);
  }
}
