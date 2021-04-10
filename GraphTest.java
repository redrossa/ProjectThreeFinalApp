// --== CS400 File Header Information ==--
// Name: Reno Raksi
// Email: raksi@wisc.edu
// Team: JF blue
// TA: Xinyi
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;

    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-E
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        // insert edges from Week 09. Dijkstra's Activity
        graph.insertEdge("A","B",2);
        graph.insertEdge("A","D",4);
        graph.insertEdge("A","E",1);
        graph.insertEdge("B","C",5);
        graph.insertEdge("C","A",3);
        graph.insertEdge("D","B",3);
        graph.insertEdge("D","C",7);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","C",8);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled C to E
     * (should be 4), and from the vertex labelled A to C (should be 7).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertEquals(graph.getPathCost("C", "E"), 4);
        assertEquals(graph.getPathCost("A", "C"), 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled C to E, and from the vertex labelled A to C.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertEquals(graph.shortestPath("C", "E").toString(), "[C, A, E]");
        assertEquals(graph.shortestPath("A", "C").toString(), "[A, B, C]");
    }

    /**
     * Checks the distance to the farthest vertex in the Dijkstra's Activity from
     * my starting vertex C.
     */
    @Test
    public void testDistanceFarthestVertexFromC() {
        assertEquals(graph.getPathCost("C", "D"), 7);
    }

    /**
     * Checks the sequence to the farthest vertex in the Dijkstra's Activity from
     * my starting vertex C.
     */
    @Test
    public void testSequenceFarthestVertexFromC() {
        assertEquals(graph.shortestPath("C", "D").toString(), "[C, A, D]");
    }

    /**
     * Checks the distance of a path from a starting vertex to itself.
     */
    @Test
    public void testDistanceVertexToItself() {
        assertEquals(graph.getPathCost("A", "A"), 0);
    }

    /**
     * Checks exception of finding a path from a vertex to another
     * that is unreachable.
     */
    @Test
    public void testUnreachableVertex() {
        graph.insertVertex("F");
        assertThrows(NoSuchElementException.class, () -> graph.getPathCost("A", "F"));
    }
}