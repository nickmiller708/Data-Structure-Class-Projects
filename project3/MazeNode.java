/* Nick Miller and Josh Boldt
   This is the maze node class */
import support.LLNode;
public class MazeNode {
    private int row, column;
    private MazeNode  parent;
    private String direction;
    private int jumpvalue;
    public MazeNode(int row, int column,  MazeNode parent, String direction) {
	this.row = row;
	this.column = column;
	this.parent = parent;
	this.direction = direction;;
    }

    public int getRow() {
	return row;
    }
    public int getColumn() { 
	return column; }
    public String getDirection() {
	return direction;
    }
    public MazeNode getParent() {
	return parent;
    }
    public boolean equals(Object o) {
	MazeNode thing = (MazeNode) o;
	if ((thing.getRow() == row) && (thing.getColumn() == column)) 
	    return true;
	else
	    return false;
    }
    public int compareTo(MazeNode e) {
	if (e.getRow() == row) {
	    if (e.getColumn() == column) 
		return 0;
	    else if (e.getColumn() < column)
		return -1;
	    else
		return 1;
	}
	else {
	    if (e.getRow() < row) 
		return -1;
	    else
		return 1;
	}
    }
    public String toString() {
	String returner = "";
	returner = "row: " + row+ " " + "column: " + column+ " " + "direction: " + " " + direction;
	return returner;
    }
    public static void main(String[] args) {

	MazeNode test1 = new MazeNode(3,3,null,"Up");
	MazeNode test2 = new MazeNode(2,2,null, "Down");
	MazeNode test3 = new MazeNode(3,3, null, "Left");
	System.out.println(test1.equals(test2));
	System.out.println(test1.equals(test3));
	System.out.println(test1.compareTo(test2));
	System.out.println(test1.compareTo(test3));
	System.out.println(test1);
	System.out.println(test2);
	System.out.println(test3);
    }
}
		
