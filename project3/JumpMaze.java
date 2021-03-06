/* Nick Miller and Josh Boldt
   This is the maze class */
import ch06.lists.*;
import java.util.*;
import java.io.*;
import ch03.stacks.*;
public class JumpMaze {
    int[][] Maze;
    ArrayIndexedList frontier;
    RefUnsortedList explored;
    int row, column;
    int goalrow, goalcolumn;
    public JumpMaze(String filename, int row, int column) {
	try { 
	    FileReader fin = new FileReader(filename);
	    Scanner myscan = new Scanner(fin);
	    Maze = new int[row][column];
	    this.row = row;
	    this.column = column;
	    for (int r = 0; r < row; r++)
		for (int c = 0; c < column; c++){
		    int myint = myscan.nextInt();
		    Maze[r][c] = myint;
		    if (myint == 0) {
			goalrow = r;
			goalcolumn = c;
		    }
		}
	}
	catch (Exception  e) {
	    System.out.println("File not found!");
	}
    }
    public JumpMaze(int row, int column) {
	Maze = new int [row][column];
	boolean zeromade = false;
	this.row = row;
	this.column = column;
	Random rn = new Random();
	for (int r = 0; r < row; r++)
	    for (int c = 0; c < column; c++) {
		int myint = rn.nextInt(10);
		
		Maze[r][c] = myint; 
		
	
    public  void  Mazeprocess() { 
	// process of solving the maze. If there is a solution, will print the path. Else, it will print that there is no solution possible
	MazeNode initial = new MazeNode(0,0, null, "start");
	frontier = new ArrayIndexedList<MazeNode>();
	explored = new RefUnsortedList<MazeNode>();
	frontier.add(initial);
	MazeNode currNode;
	int currRow ;
	int currColumn;
	boolean winner = false;
	MazeNode goal = new MazeNode(goalrow, goalcolumn, null, "Stop");
	while ((frontier.size() != 0) && (winner!= true)) {
	    currNode = (MazeNode) frontier.get(0);
	    frontier.remove(0);
	    currRow = currNode.getRow();
	    currColumn = currNode.getColumn();
	    explored.add(currNode);
	    int jumpsize = Maze[currRow][currColumn];
	    winner = getMoves(currNode, goal, jumpsize);  
	}
	if (winner == true) {
	    ArrayListStack<String> result = new ArrayListStack<String>();
	    result.push("end of solution");
	    MazeNode tempNode = (MazeNode) frontier.get(0);
	    MazeNode endgoal = new MazeNode(goal.getRow(), goal.getColumn(), tempNode, "end");
	    String printer = "";
	    String a = "";
	    while (endgoal != null) {
		a = endgoal.toString();
		result.push(a);
		endgoal = endgoal.getParent();}
	    while (!result.isEmpty()) {
		printer = printer + result.top() + "\n ";
		result.pop();
	    }
	    System.out.println(printer);
	}
	else {
	    System.out.println("Solution not found");
	}
    }
	private  boolean getMoves(MazeNode e, MazeNode goal, int jumpsize) {
	    /* computes any possible move with the int Jumpsize and compares those child nodes to the goal node. If any child node equals the goal node, then the function returns true. Else, returns false */
	int up = 0;
	int left = 0;
	int down = 0;
	int right = 0;
	up = e.getRow() - jumpsize;
	left = e.getColumn() - jumpsize ;
	right = e.getColumn() + jumpsize;
	down = e.getRow() + jumpsize;
	boolean returner = false;
	if (up >=  0) {
	    MazeNode adder = new MazeNode(up, e.getColumn(), e, "U");
	    if ((frontier.contains(adder) == false) && (explored.contains(adder) == false))
		frontier.add(adder);
	    if (adder.equals(goal) == true)
		returner = true;
	}
	if ((down  < row) && (returner == false))  {
	    MazeNode adder = new MazeNode(down, e.getColumn(), e, "D");
	    if ((frontier.contains(adder) == false) && (explored.contains(adder) == false))
		frontier.add(adder);
	    if (adder.equals(goal) == true) {
		returner = true;
	    }
	    
	}
	if ((left >= 0) && (returner == false)) {
	    MazeNode adder = new MazeNode(e.getRow(), left, e, "L");
	    if ((frontier.contains(adder) == false) && (explored.contains(adder) == false))
		frontier.add(adder);
	    if (adder.equals(goal) == true) {
		returner = true;
	    }
	}
	if ((right < column) && (returner == false)) {
	    MazeNode adder = new MazeNode(e.getRow(), right, e, "R");
	    if ((frontier.contains(adder) == false) && (explored.contains(adder) == false))
		frontier.add(adder);
	    if (adder.equals(goal) == true) {
		returner = true;
	    }
	}
	return returner;
    }
    
    public String toString() {
	return explored.toString();
    }
    public static void main(String[] args) {
	JumpMaze test1 = new JumpMaze("ints.txt", 3, 4);
	test1.Mazeprocess();
	JumpMaze test2 = new JumpMaze("winner.txt", 2, 2); //should be a winner
	test2.Mazeprocess();
	JumpMaze test3 = new JumpMaze("HerExample.txt", 5, 5);
	test3.Mazeprocess();
	JumpMaze test4 = new JumpMaze("Large File.txt", 7, 7);
	test4.Mazeprocess();
    }
}
