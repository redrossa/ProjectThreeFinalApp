// --== CS400 File Header Information ==--
// Name: Yuven Sundaramoorthy
// Email: ysundaramoor@wisc.edu
// Team: JF Blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;

/**
 * A LocationDataReader provides a way to read a CSV file containing Locations
 * by line.
 */
public class LocationDataReader implements LocationDataReaderInterface {
  /** The index of the location name in the CSV file header. */
  private static final int LOCATION_NAME = 0;

  /** First index of a neighbors name in CSV file header. */
  private static final int NEIGHBOR_NAMES = 1;

  /** First index of a neighbors distances in CSV file header. */
  private static final int NEIGHBOR_DISTANCES = 2;

  /**
   * Parses a string integer value in the CSV file.
   * 
   * @param s a string integer value in the CSV file
   * @return a parsed int value of the given string integer value
   */
  private int parseDistance(String s) {
    return s.equals("-") ? 0 : Integer.parseInt(s);
  }

  /**
   * Returns a list of PlayerInterface instances given a Reader to a CSV file
   * containing statistics of NBA players each line.
   * 
   * @param r a Reader to a CSV file containing statistics of NBA players each
   *          line
   * @return a list of PlayerInterface instances
   * @throws IOException if there are any IO errors.
   */
  @Override
  public List<LocationInterface> readDataSet(Reader r) throws IOException {
    List<LocationInterface> locations = new LinkedList<>();
    CSVReader csvReader = new CSVReader(r);
    csvReader.skip(1); // skipping header line
    for (String[] line : csvReader) {
      List<String> names = new LinkedList<>();
      List<Integer> distances = new LinkedList<>();
      String val = line[NEIGHBOR_NAMES];
      int counter = 0;
      while (!val.equals("-")) {
        names.add(line[NEIGHBOR_NAMES + counter]);
        counter += 2;
        try {
          val = line[NEIGHBOR_NAMES + counter];
        } catch (Exception e) {
          break;
        }
      }
      val = line[NEIGHBOR_DISTANCES];
      counter = 0;
      while (!val.equals("-")) {
        try {
        distances.add(parseDistance(line[NEIGHBOR_DISTANCES + counter]));
        }catch (Exception e) {
          break;
        }
        counter += 2;
        try {
          val = line[NEIGHBOR_DISTANCES + counter];
        } catch (Exception e) {
          break;
        }
      }
      locations.add(new Location(
              line[LOCATION_NAME],
              names,
              distances));
    }
    return locations;
  }
}
