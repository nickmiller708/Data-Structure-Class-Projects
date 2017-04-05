//Nick Miller and Yixin Liu;
//tests the binary search and the average number of locations referenced each time.

import java.util.Random;
public class binSearch {
    public static int count = 0; 
    public static int binarySearch(int anArray[], int first, int last, int value) {
	/* Attempts to find value in the array locations anArray[first] up to and including anArray[last]. Returns -1 if the value is not foudn, otherwise it returns the location where it is found */
	int index;
	
	if (first > last) // the array section is empty
	    index = -1;
	else {
	    int mid = (first + last)/2;
	    count ++;
	    if (value == anArray[mid])
		index = mid;
	    else if (value < anArray[mid])
		index = binarySearch(anArray,first,mid-1,value);
	    else
		index = binarySearch(anArray, mid+1, last, value);
	}
	return index;
    }
    public static int count() {
	return count; }
    public static void main(String[] args) {
	Random rand = new Random();
	int MAX = 10;
	int A[] = new int[MAX];
	A[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    A[j] = A[j-1] + rand.nextInt(10) + 1;}
	int BIG = A[MAX-1];
	int average = 100; //total number of times we are going to search through an array
	double totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(A, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	double averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 10 for 100 searches is:  " + averagetotal);
	
	// NOW DOING FOR SIZE 100 ARRAY
	MAX = 100;
	int B[] = new int[MAX];
	B[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    B[j] = B[j-1] + rand.nextInt(10) + 1;}
	BIG = B[MAX-1];
	average = 100;
	totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(B, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 100 for 100 searches is:  " + averagetotal);
	// NOW DOING FOR SIZE 1000 ARRAY
	MAX = 1000;
	int C[] = new int[MAX];
	C[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    C[j] = C[j-1] + rand.nextInt(10) + 1;}
	BIG = C[MAX-1];
	average = 1000;
	totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(C, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 1000 for 1000 searches is:  " + averagetotal);
	// NOW DOING FOR SIZE 10000 ARRAY
	MAX = 10000;
	int D[] = new int[MAX];
	D[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    D[j] = D[j-1] + rand.nextInt(10) + 1;}
	BIG = D[MAX-1];
	average = 1000;
	totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(D, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 10,000 for 1000 searches is:  " + averagetotal);
	// NOW DOING FOR SIZE 100,000 ARRAY
	MAX = 100000;
	int E[] = new int[MAX];
	E[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    E[j] = E[j-1] + rand.nextInt(10) + 1;}
	BIG = E[MAX-1];
	average = 1000;
	totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(E, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 100,000 for 1000 searches is:  " + averagetotal);
	// NOW DONIG FOR SIZE 1,000,000 ARRAY
	MAX = 1000000;
	int F[] = new int[MAX];
	F[0] = rand.nextInt(10) + 1;
	for (int j = 1; j < MAX; j++) {
	    F[j] = F[j-1] + rand.nextInt(10) + 1;}
	BIG = F[MAX-1];
	average = 10000;
	totalcount = 0;
	for (int search = 1; search < average; search++) {
	    int x = rand.nextInt(BIG + 5);
	    int y = binarySearch(F, 0, MAX-1, x);
	    int z = count();
	    totalcount = totalcount + z;
	    count = 0;
	}
	averagetotal = totalcount/average;
	System.out.println("The average number of locations searched in an array size 1,000,000 for 10,000 searches is:  " + averagetotal); 
    }
}
