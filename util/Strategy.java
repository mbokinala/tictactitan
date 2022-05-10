import java.util.ArrayList;
public class Strategy{
  private static ArrayList<StratFn> allStrats = new ArrayList<StratFn>();
  private static int junk = addStrats(); // ???
  // STUDENTS 2: Add your strategy description to String[] teamNames
  private static String[] teamNames = {"Kim", "Sample"};
  public static int[] getMove(int strategyNumber, int[][] b, SavedData memory){
    if(strategyNumber >= allStrats.size())
      return null;
    return allStrats.get(strategyNumber).run(b,memory);
  }
  // STUDENTS 3: Add your strategy function calls here:
  public static int addStrats(){
    allStrats.add((b,m) -> strat0(b,m)); // Kim
    allStrats.add((b,m) -> strat1(b,m)); // Sample
    return 0;
  }
  public static String[] getTeamNames(){
    String[] copy = new String[teamNames.length];
    for(int i=0; i<teamNames.length; i++)
      copy[i] = teamNames[i];
    return copy;
  }
  public static String description(){
    String s = "-1: Player\n";
    for(int i=0; i<teamNames.length; i++)
      s += i + ": " + teamNames[i] + "\n";
    return s;
  }
  // STUDENTS 1: Add your strategy functions here:
  // Use ZLastName java files for your helper functions.
  // Assume you are player 1(X), opponent is player -1(O).
  // memory.lastMove will be opponent's last move.
  public static int[] strat0(int[][] b, SavedData memory){
    return ZKim.strat(b,memory);
  }
  // To the right of the last move every time.
  public static int[] strat1(int[][] b, SavedData memory){
    return ZSample.strat(b,memory);
  }
}
interface StratFn{
  int[] run(int[][] b, SavedData memory);
}
