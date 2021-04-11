// --== CS400 File Header Information ==--
// Name: Mayank Reddy Dornala
// Email: dornala@wisc.edu
// Team: JF
// TA: Xinyi
// Lecturer: Gary
// Notes to Grader: Backend
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Backend {
	
	// Graph:
	private CS400Graph<LocationInterface> cities; 
	private List<LocationInterface> allCities; 
	
	/**
	   * Initializes a Backend given the command line arguments.
	   * 
	   * @param args the command line arguments whose zeroth element is expected to be
	   *             the path to a movies CSV file.
	   * @throws IOException         if the named file does not exist, is a directory
	   *                             rather than a regular file, or for some other
	   *                             reason cannot be opened for reading.
	   * 
	   */
	  public Backend(String[] args) throws IOException {
	    this(new FileReader(args[0]));
	  }
	  
	  /**
	   * Initializes a Backend given a Reader to a players CSV file.
	   * 
	   * @param r a Reader to a movies CSV file.
	   * @throws IOException           if the named file does not exist, is a
	   *                               directory rather than a regular file, or for
	   *                               some other reason cannot be opened for reading.
	   * 
	   */
	  public Backend(Reader r) throws IOException {
		  
		  // list of all location objects w/in data set
	    this.allCities = new LocationDataReader().readDataSet(r);
	      // init graph data structure to store locations
	    this.cities = new CS400Graph<LocationInterface>();
	    
	    // fill in graph with given Location Objects (src and target)
	    for(LocationInterface x : allCities ) {
	    	cities.insertVertex(x); 
	    	List<Integer> edgeWeights = x.getDistances();
	    	List<String> xNeighbors = x.getNeighbors(); 
	    	
	    	for(int i = 0; i < edgeWeights.size(); i++) { // loop through all edgeWeights
	    		for(int j = 0; j < allCities.size(); j++) { // loop thru all location objs to find the one that matches neighbor string
	    			if(allCities.get(j).getName().equals(xNeighbors.get(i))) { // if it matches neightbor's name, insert Edge and break j loop
	    				cities.insertEdge(x, allCities.get(j), edgeWeights.get(i)); 
	    				break; 
	    			}else {
	    				continue; 
	    			}
	    		}	
	    	}	
	     }
	  }
	
}
