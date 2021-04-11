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
import java.util.List;

// --== CS400 File Header Information ==--
// Name: Yuven Sundaramoorthy
// Email: ysundaramoor@wisc.edu
// Team: JF Blue
// Role: Data Wrangler
// TA: Xinyi
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>

/**
 * Interface for required methods in data reader.
 * 
 * @author Yuven Sundaramoorthy
 *
 */
public interface LocationDataReaderInterface {
  
  /**
   * List of LocationInterfaces given to a reader from a csv file
   * @param r
   * @return list of Location Interfaces
   * @throws IOException
   */
  List<LocationInterface> readDataSet(Reader r) throws IOException;
}
