/* Nick and Haofei
   the edge class */
public class Edge {
    protected int toCity; // the index of the c ity to which this edge leads
    protected int weight;
    public Edge(int toC, int wt) {
	toCity = toC;
	weight = wt;
    }
    public int getCity() {
	//return the index of the vertex to which the edge points
	return toCity;
    }
    public int getWeight() {
	return weight;
    }
}
