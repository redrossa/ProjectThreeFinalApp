// --== CS400 File Header Information ==--
// Name: Yuven Sundaramoorthy
// Email: ysundaramoor@wisc.edu
// Team: JF Blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;

/**
 * Interface to represent the methods for location implementation.
 * @author Yuven Sundaramoorthy
 */
public interface LocationInterface {

  /**
   * Returns the name of the location
   * @return name of location
   */
  String getName(); 
  
  /**
   * List of all connected locations
   * 
   * @return List of LocationInterfaces
   */
  List<String> getNeighbors();
  
  /**
   * List of integers matching up to the neighbors.
   * 
   * @return List of Integers
   */
  List<Integer> getDistances();
}
