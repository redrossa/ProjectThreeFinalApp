import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// --== CS400 File Header Information ==--
// Name: Yuven Sundaramoorthy
// Email: ysundaramoor@wisc.edu
// Team: JF Blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>

public class DataWranglerTests {
  private String csvPath;
  private LocationDataReaderInterface dataReader;

  @BeforeEach
  public void setUp() {
    csvPath = "maplocations.csv";
    dataReader = new LocationDataReader();
  }

  /**
   * Tests the number of cities found in file
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Test
  public void testSize() throws FileNotFoundException, IOException {
    assertEquals(10, dataReader.readDataSet(new FileReader(csvPath)).size());
  }
  
  /**
   * Tests the names of the neighbors to Two different cities.
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Test
  public void testNeighborList() throws FileNotFoundException, IOException {
    List<String> names = new LinkedList<>();
    names.add("Denver");
    names.add("Dallas");
    names.add("Minneapolis");
    names.add("Chicago");
    assertEquals(names, dataReader.readDataSet(new FileReader(csvPath)).get(6).getNeighbors());
    names.clear();
    names.add("Las Vegas");
    names.add("Denver");
    assertEquals(names, dataReader.readDataSet(new FileReader(csvPath)).get(3).getNeighbors());
  }
  
  /**
   * Tests the distances between two cities and their neighbors.
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Test
  public void testNeighborsDistances() throws FileNotFoundException, IOException {
    List<Integer> distances= new LinkedList<>();
    distances.add(900);
    distances.add(740);
    distances.add(680);
    distances.add(670);
    assertEquals(distances, dataReader.readDataSet(new FileReader(csvPath)).get(6).getDistances());
    distances.clear();
    distances.add(250);
    distances.add(1230);
    assertEquals(distances, dataReader.readDataSet(new FileReader(csvPath)).get(9).getDistances());
  }
  /**
   * Tests the names of two cities.
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Test
  public void testName() throws FileNotFoundException, IOException {
    assertEquals("Dallas", dataReader.readDataSet(new FileReader(csvPath)).get(5).getName());
    assertEquals("St Louis", dataReader.readDataSet(new FileReader(csvPath)).get(6).getName());
  }
  /**
   * Tests the names of two cities using toString.
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Test
  public void testToString() throws FileNotFoundException, IOException {
    assertEquals("Phoenix", dataReader.readDataSet(new FileReader(csvPath)).get(2).toString());
    assertEquals("St Louis", dataReader.readDataSet(new FileReader(csvPath)).get(6).toString());
  }
  
}
