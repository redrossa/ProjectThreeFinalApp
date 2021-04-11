// --== CS400 File Header Information ==--
// Name: Mayank Reddy Dornala
// Email: dornala@wisc.edu
// Team: JF
// TA: Xinyi
// Lecturer: Gary
// Notes to Grader: Interface to define Backend function
import java.util.List;
public interface BackendInterface {
	
	 public List<String> shortestPath(LocationInterface src, LocationInterface destination);
	 public List<String> returnAllLocation(); 
	 public int shortestDistance(LocationInterface src, LocationInterface destination);

}

