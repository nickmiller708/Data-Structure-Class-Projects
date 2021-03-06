/* Nick and Haofei
   Vertex class */
import ch06.lists.*;
import ch05.queues.*;
public class Vertex {
    protected String name; //name of city
    protected boolean marked; //true if marked - else false
    protected RefUnsortedList<Edge> list; //list of edges of other cities
    
    public Vertex (String nm) {
	name = nm;
	marked = false;
	list = new RefUnsortedList<Edge>();
    }
    public String getName() {
	return name;
    }
    public RefUnsortedList<Edge> getList() {
	return list;
    }
    public void mark(boolean b) {
	marked = b;
    }
    public boolean isMarked() {
	return marked;
    }
    public void addEdge (Edge e) {
	list.add(e);
    }
    public ArrayUnbndQueue<Integer> getToVertexIndices() {
	ArrayUnbndQueue<Integer> returner = new ArrayUnbndQueue<Integer>();
	list.reset();
	for (int i = 0; i < list.size(); i++) {
	    Edge a = list.getNext(); // will get the next Edge in the list
	    returner.enqueue(a.getCity()); //will add its index to the Queue
	}
	return returner;
    }
    public String toString() {
	String returner = "Name of the city: " + name + "\n Marked: " + marked;
	return returner;
    }
    public boolean equals (Object o) {
	Vertex e = (Vertex) o;
	return (name == e.getName());
    }
    public static void main(String[] args) {
	Vertex v0 = new Vertex("Atlanta");
	Vertex v1 = new Vertex("Austin");
	Vertex v2 = new Vertex("Chicago");
	Vertex v3 = new Vertex("Dallas");
	Vertex v4 = new Vertex("Denver");
	Vertex v5 = new Vertex("Houston");
	Vertex v6 = new Vertex("Washington");
	v0.addEdge(new Edge (5,800));
	v0.addEdge(new Edge (6,600));
	v1.addEdge(new Edge(5, 160));
	v2.addEdge(new Edge(4,1000));
	System.out.println(v0);
	System.out.println(v1);
	System.out.println(v2);
    }
}
