// Nick and Liren
// Hash class
import java.util.Random;
public class hash {
    protected int[] table;
    protected int maxKeys, tablesize;
    public hash(int size, double loadingfactor) {
	maxKeys = (int)(size*loadingfactor+1);
	table = new int[size];
	tablesize = size;
	for (int i = 0; i < size; i ++) {
	    table[i] = -1;
	}
    }
    public double fill () {
	// returns the average number of successful comparisons
	double numComptotal = 0.0;
	int noKeys = 0; //number of keys in the table
	Random rand = new Random();
	int MAX = 5000000;
	int[] used = new int[5000000];
	for (int i =0; i < 5000000; i ++) {
	    used[i] = -1;
	}
	while (noKeys != maxKeys) {
	    int num = rand.nextInt(MAX+1) + 1;
	    if (used[num-1] == -1) {
		int comparison = hasher(num);
		numComptotal = numComptotal + comparison;
		used[num-1] = 0;
		noKeys = noKeys+1;
	    }  
	    //MAX = MAX + 20;
	}
	return (numComptotal/noKeys);
    }
    private int hasher(int i) {
	// hashing the integer into the table
	//h(x) = x%tablesize
	// returns number of successful comparisons
	int numComparisons = 0;
	int num = i%tablesize;
	boolean filled = false;
	if (table[num] == -1) {
	    table[num] = i;
	    numComparisons = 1;
	}
	else {
	    while (filled != true) {
		num = num + i%37+3;
		num = num%1009;

		//linear probing
		numComparisons = numComparisons + 1;
		if (table[num] == -1) {
		    table[num] = i;
		    filled = true;
		}
	    }
	}
	return numComparisons;
    }
    public double find() {
	// precondition i is not in the hash  
	// returns the number of comparisons
	int numComparison = 1;
	for (int j = 5000100; j< 1009+5000100-1; j++){
	    int idx = j % 1009;
	    while(table[idx] != -1){
		idx ++;
		idx = idx%1009;
		numComparison++;
	    }
	}
	return numComparison/1009.0;
    }


    public String toString() {
	String returner = "";
	for (int i = 0; i < tablesize; i ++) {
	    if (table[i] == -1) {
		returner = returner + " -1 ";
	    }
	    else
		returner = returner + table[i] +" ";
	}
	return returner;
    }
    public static void main(String[] args) {
	hash test1 = new hash(1009, .6);
	System.out.println("Average Number of successful Comparisons: " + test1.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test1.find());
	hash test2 = new hash(1009, .65);
	System.out.println("Average number of successful comparisons: " + test2.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test2.find());
	hash test3 = new hash(1009, .7);
	System.out.println("Average Number of successful Comparisons: " + test3.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test3.find());
	hash test4 = new hash(1009, .75);
	System.out.println("Average Number of successful Comparisons: " + test4.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test4.find());
hash test5 = new hash(1009, .8);
	System.out.println("Average Number of successful Comparisons: " + test5.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test5.find());
hash test6 = new hash(1009, .85);
	System.out.println("Average Number of successful Comparisons: " + test6.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test6.find());
hash test7 = new hash(1009, .9);
	System.out.println("Average Number of successful Comparisons: " + test7.fill());
	//	System.out.println("Average Number of unsuccessful Comparisons: "+ test7.find());
	hash test8 = new hash(1009, .95);
	System.out.println("Average Number of successful Comparisons: " + test8.fill());
	//		System.out.println("Average Number of unsuccessful Comparisons: "+ test8.find());
    }
}
