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
 * Location object containing neighbors and distances
 * 
 * @author Yuven Sundaramoorthy
 *
 */
public class Location implements LocationInterface{

  //Name of location
  private String name;
  //list of the neighbors
  private List<String> neighbors;
  //list of the distances
  private List<Integer> distances;
  
  public Location(String name, List<String> neighbors, List<Integer> distances) {
    this.name = name;
    this.neighbors = neighbors;
    this.distances = distances;
  }
  
  /**
   * Returns name of location
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * returns list of neighbors.
   */
  @Override
  public List<String> getNeighbors() {
    return neighbors;
  }

  /**
   * Returns list of distances.
   */
  @Override
  public List<Integer> getDistances() {
    return distances;
  }
  
  @Override
  public String toString() {
    return name;
  }
  
}
