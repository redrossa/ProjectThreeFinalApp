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
import java.util.ArrayList;
import java.util.List;

public class Backend implements BackendInterface {
	
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
	    
	    // add all locations to graph
	    for(LocationInterface x : allCities) {
	    	cities.insertVertex(x); 
	    }
	    
	    // fill in graph with edges from csv data
	    for(LocationInterface x : allCities) {
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
	  
	/**
	 * Frontend can only pass strings. These strings will be location names. 
	 * These strings will be matched to the proper location object, which 
	 * will be returned
	 * @param location: string user input
	 * @return location that matches string input
	 */
	public LocationInterface retrieveLocation(String location) {
		// loop through allCities (list of location objs) and return correct location object
		for(LocationInterface x: allCities) {
			if(x.getName().equals(location)) {
				return x;
			}
		}
		return null;
	}
	
	/**
	 * Returns List of Names (Strings) of Locations that make up the shortest path 
	 * from a src location to a target destination (using Dijkstra's Algorithm
	 * in graph implementation). 
	 * @param src
	 * @param destination
	 * @return List of Strings representing all locations along a Path
	 */
	@Override
	public List<String> shortestPath(String src, String destination) {
		// retrieve location objects:
		LocationInterface srcLoc = this.retrieveLocation(src);
		LocationInterface destLoc = this.retrieveLocation(destination);
		// determine shortest path:
		List<LocationInterface> sp = this.cities.shortestPath(srcLoc, destLoc);
		List<String> spNames = new ArrayList<String>(); 
		// add String Names to List
		sp.forEach((p) -> spNames.add(p.getName())); 
		return spNames;
	}
	
	/**
	* @return A List of Strings representing all known locations within the graph/data set
	*/
	@Override
	public List<String> returnAllLocation(){
		List<String> allNames = new ArrayList<String>(); 
		allCities.forEach((l) -> allNames.add(l.getName())); 
		return allNames; 
	}
	
	/**
	 * Returns distance of shortest Path
	 * (using Dijkstra's Algorithm
	 * in graph implementation). 
	 * @param src
	 * @param destination
	 */
	@Override
	public int shortestDistance(String src, String destination) {
		LocationInterface srcLoc = this.retrieveLocation(src);
		LocationInterface destLoc = this.retrieveLocation(destination); 
		return this.cities.getPathCost(srcLoc, destLoc);
	}
	
	/**
	 * Method for Tester class. 
	 * Has no real use for the frontend. It is here for me to use in the
	 * tester class to check that all locations have been added with their proper
	 * weighted edges. 
	 * @return
	 */
	public List<LocationInterface> retrieveLocObjs(){
		return this.allCities; 
	}
	
	
}
