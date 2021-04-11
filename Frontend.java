import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// --== CS400 File Header Information ==--
// Name: Lilly Boyd
// Email: laboyd2@wisc.edu
// Team: XF blue
// Role: Frontend Developer
// TA: Xinyi
// Lecturer: Gary
// Notes to Grader: <optional extra notes>
public class Frontend {
  private static int mode = 0;
  public static String startCity = "";
  public static String endCity = "";

  /**
   * Initializes the backend and starts the frontend implementation
   * 
   * @param args
   * @throws IOException
   */
  public void main(String[] args) throws IOException {
    BackendDummy backend = new BackendDummy(args);
    // title screen for user:
    System.out.println("************************************");
    System.out.println("*                                  *");
    System.out.println("*    Welcome to A Simple GPS!!!    *");
    System.out.println("*                                  *");
    System.out.println("************************************");
    System.out.println("");
    System.out.println("Press enter to continue: ");
    // try to proceed to next screen
    try {
      System.in.read();
    } catch (Exception e) {
      System.out.println("Please press enter to continue: ");
      main(args);
    }
    gpsMainMenu(backend);
  }

  /**
   * acts as the main menu for the program, displaying the list of cities and options user can
   * select
   * 
   * @param back
   */
  public static void gpsMainMenu(BackendDummy back) {

  }
}
