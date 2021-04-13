import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

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
    Backend backend = new Backend(args);
    // title screen for user:
    System.out.println("************************************");
    System.out.println("*                                  *");
    System.out.println("*       Starting your GPS...       *");
    System.out.println("*                                  *");
    System.out.println("************************************");
    System.out.println("Press enter to continue: ");
    System.out.println("------------------------------------");
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
  public static void gpsMainMenu(Backend back) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("              Main Menu             ");
    System.out.println("------------------------------------");
    System.out.println("Enter 1 to find the shortest distance between two cities.");
    System.out.println("Enter 2 to view a list of the cities to travel to.");
    System.out.println(
        "Enter 3 to choose a city and view its neighboring cities and distances between them.");
    System.out.println("Enter 0 to quit the GPS.");
    try {
      mode = userInput.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input, please enter an integer 0-3.");
    }
    // quit program
    if (mode == 0) {
      System.exit(0);
    }
    // shortest distance
    if (mode == 1) {
      getShortestPathBetweenTwoCities(back);
    }
    // list of cities
    else if (mode == 2) {
      listAllCitiesAgain(back);
    }
    // city and neighbors
    else if (mode == 3) {
      // TODO: finish
    } else {
      System.out.println("Invalid input, please enter an integer 0-3.");
      gpsMainMenu(back);
    }
  }

  /**
   * Allows user to enter two cities from the list and find the shortest path of cities between them
   * 
   * @param backend
   */
  public static void getShortestPathBetweenTwoCities(Backend backend) {
    startCity = "";
    endCity = "";
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Find the Shortest Distance Between Two Cities:");
      System.out.println("------------------------------------");
      System.out.println("Cities to Choose from: ");
      List<String> cities = backend.returnAllLocation();
      for (int i = 0; i < cities.size(); i++) {
        System.out.println(cities.get(i));
      }
      System.out.println("------------------------------------");
      System.out.println("Please enter the name of the city you want to start at.");
      System.out.println("If you wish to return to the main menu, please enter 0");
      try {
        startCity = input.nextLine();
      } catch (Exception e) {
        System.out.println("Please enter a valid city. Try again.");
        getShortestPathBetweenTwoCities(backend);
      }
      // exit mode
      if (startCity.toLowerCase().equals("0")) {
        gpsMainMenu(backend);
      }
      System.out.println("Please enter the city you want to end at.");
      try {
        endCity = input.nextLine();
      } catch (Exception e) {
        System.out.println("Please enter a valid city. Try again.");
        getShortestPathBetweenTwoCities(backend);
      }
      System.out.println("------------------------------------");
      List<String> shortestPathToCities = backend.shortestPath(startCity, endCity);
      System.out.println("The shortest path to take is: ");
      for (int i = 0; i < shortestPathToCities.size(); i++) {
        System.out.println(shortestPathToCities.get(i));
      }
      System.out.println("------------------------------------");
    }

  }

  /**
   * Prints out the list of the cities again for the user if needed
   * 
   * @param backend
   */
  public static void listAllCitiesAgain(Backend backend) {
    Scanner userInput = new Scanner(System.in);
    int toReturn = 1;
    System.out.println("Cities to Choose from: ");
    List<String> cities = backend.returnAllLocation();
    for (int i = 0; i < cities.size(); i++) {
      System.out.println(cities.get(i));
    }
    System.out.println("Enter 0 to return to the main menu.");
    try {
      toReturn = userInput.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input, please enter 0 to return to the main menu");
    }
    if (toReturn == 0) {
      gpsMainMenu(backend);
    }
    System.out.println("------------------------------------");
  }

}
