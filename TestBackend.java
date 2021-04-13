// --== CS400 File Header Information ==--
// Name: Mayank Reddy Dornala
// Email: dornala@wisc.edu
// Team: JF
// TA: Xinyi
// Lecturer: Gary
// Notes to Grader: Backend Tests
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class TestBackend {

	
	/**
	 * This Test will check if the construction of the graph is implemented correctly.
	 * Checks:
	 *  - All Locations exist
	 *  - All Edges are correct
	 *  
	 * by calling graph in the backend
	 */
	@Test
	public void TestBackendConstruction() {
		
		Backend back = null;
		try {
			back = new Backend(new StringReader(
					"Location,C1,C1D,C2,C2D,C3,C3D,C4,C4D\n"
					+ "Los Angeles,Las Vegas,370,Phoenix,580\n"
					+ "Las Vegas,Los Angeles,370,Phoenix,420,Salt Lake City,580\n"
					+ "Phoenix,Los Angeles,580,Las Vegas,420,Dallas,1500\n"
					+ "Salt Lake City,Las Vegas,580,Denver,600\n"
			));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<LocationInterface> allLocations = back.retrieveLocObjs(); 
		
	}
	
	
}
