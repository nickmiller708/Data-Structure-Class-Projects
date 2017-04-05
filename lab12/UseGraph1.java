//----------------------------------------------------------------------------
// Adapted from UseGraph.java  by Dale/Joyce/Weems           Chapter 9
//
// Examples of uses of the Graph ADT.
//----------------------------------------------------------------------------

import ch05.queues.*;
import ch03.stacks.*;
import ch09.graphs.*;
import ch09.priorityQueues.*;


public class UseGraph1
{


private static boolean isPath(WeightedGraphInterface graph,
                              String startVertex, 
                              String endVertex    )

// Returns true if a path exists on graph, from startVertex to endVertex; 
// otherwise returns false. Uses depth-first search algorithm.

{
  UnboundedStackInterface<Vertex> stack = new LinkedStack<Vertex>();
  UnboundedQueueInterface<Vertex> vertexQueue = new LinkedUnbndQueue<Vertex>();
 
  boolean found = false;
  Vertex vertexS = new Vertex(startVertex);
  Vertex vertexE = new Vertex(endVertex);
  Vertex item;
 
  graph.clearMarks();
  stack.push(vertexS);
  Vertex v;
  do
  {
    v = stack.top();
    stack.pop();
    if (v.equals(vertexE))
       found = true;
    else
    {
      if (!graph.isMarked(v))
      {
        graph.markVertex(v);
        vertexQueue = graph.getToVertices(v);
 
        while (!vertexQueue.isEmpty())
        {
          item = vertexQueue.dequeue();
          if (!graph.isMarked(item))
            stack.push(item);
        }
      }
    }
  } while (!stack.isEmpty() && !found);
  
  return found;
}


  public static void main(String[] args) 
  {
    WeightedGraphInterface graph = new Graph(20);
    Vertex v0 = new Vertex("Atlanta");
    Vertex v1 = new Vertex("Austin");
    Vertex v2 = new Vertex("Chicago");
    Vertex v3 = new Vertex("Dallas");
    Vertex v4 = new Vertex("Denver");	
    Vertex v5 = new Vertex("Houston");
    Vertex v6 = new Vertex("Washington");

    graph.addVertex(v0);
    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);
    graph.addVertex(v5);
    graph.addVertex(v6);

    System.out.println(graph);
    // Good stopping point for first test    
    graph.addEdge(v0, v5, 800);
    graph.addEdge(v0, v6, 600);
    graph.addEdge(v1, v3, 200);
    graph.addEdge(v1, v5, 160);
    graph.addEdge(v2, v4, 1000);
    graph.addEdge(v3, v1, 200);
    graph.addEdge(v3, v2, 900);
    graph.addEdge(v3, v4, 780);
    graph.addEdge(v4, v0, 1400);
    graph.addEdge(v4, v2, 1000);
    graph.addEdge(v5, v0, 800);
    graph.addEdge(v6, v0, 600);
    graph.addEdge(v6, v3, 1300);
    

    System.out.println(graph);
    //Good stopping point for second test
    boolean result;

    System.out.println("depth first ...");
    result = isPath(graph, "Atlanta", "Austin");
    System.out.println("Atlanta Austin " + result);
    result = isPath(graph, "Atlanta", "Washington");
    System.out.println("Atlanta Washington  " + result);
    result = isPath(graph, "Washington", "Houston");
    System.out.println("Washington Houston " + result);
    result = isPath(graph, "Washington", "Dallas");
    System.out.println("Washington Dallas  " + result);
    result = isPath(graph, "Washington", "Austin");
    System.out.println("Washington Austin  " + result);
    System.out.println();
    System.out.println();
	 
	 System.out.println("a new graph without Wash - Dallas leg");
    System.out.println();
    //Good stopping point for third test
    graph = new Graph(20);
    
 	v0 = new Vertex("Atlanta");
	v1 = new Vertex("Austin");
	v2 = new Vertex("Chicago");
	v3 = new Vertex("Dallas");
 	v4 = new Vertex("Denver");	
 	v5 = new Vertex("Houston");
 	v6 = new Vertex("Washington");

    

    graph.addVertex(v0);
    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);
    graph.addVertex(v5);
    graph.addVertex(v6);
    
    
    System.out.println(graph);
    // Good stopping point for first test    
    graph.addEdge(v0, v5, 800);
    graph.addEdge(v0, v6, 600);
    graph.addEdge(v1, v3, 200);
    graph.addEdge(v1, v5, 160);
    graph.addEdge(v2, v4, 1000);
    graph.addEdge(v3, v1, 200);
    graph.addEdge(v3, v2, 900);
    graph.addEdge(v3, v4, 780);
    graph.addEdge(v4, v0, 1400);
    graph.addEdge(v4, v2, 1000);
    graph.addEdge(v5, v0, 800);
    graph.addEdge(v6, v0, 600);
    //graph.addEdge(v6, v3, 1300);


    System.out.println("depth first ...");
    result = isPath(graph, "Atlanta", "Austin");
    System.out.println("Atlanta Austin " + result);
    result = isPath(graph, "Atlanta", "Washington");
    System.out.println("Atlanta Washington  " + result);
    result = isPath(graph, "Washington", "Houston");
    System.out.println("Washington Houston " + result);
    result = isPath(graph, "Washington", "Dallas");
    System.out.println("Washington Dallas  " + result);
    result = isPath(graph, "Washington", "Austin");
    System.out.println("Washington Austin  " + result);
    System.out.println();
    System.out.println();
    

  }
} 
