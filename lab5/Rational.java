//Nick Miller and Minh Duc Nguyen
//Rational.java UPDATED
//Lab 5
//The program ran as expected.

import java.util.Scanner;
import java.lang.Math.*;
public class Rational
{
    protected int num,de,cas ;

    //CONSTRUCTOR 1
    public Rational()
    {
	num = 0;
	de = 1;
	cas=1;
    }
    //CONSTRUCTOR 2
    public Rational(int mynum1)
    {
	num = mynum1;
	de = 1;
	cas=2;
    }
    //CONSTRUCTOR 3 edited to look for trying to make a fraction with a 0 denominator
    public Rational(int mynum2,int myde) throws BadDataException
    {
	if (myde == 0) {
	    throw new BadDataException("You tried to make a fraction with a zero!") ;
	}
	else {
	    
	    num=mynum2;
	    de=myde;
	    cas=3;
	}
	
    }

    //GCD
    private int gcd(int m, int n)
    {
	if (n == 0)
	    return m;
	boolean sth=true;
	while ( sth){
	    int r=m%n;
	    if (r==0){
		sth=false;
		    }
	    else{
		m=n;
		n=r;
		
	    }}return n;
	
    }

    //REDUCE
    private void reduce()
    {
	int gcd1= gcd(num,de);
	num=num/gcd1;
	de=de/gcd1;

	if ((num>0)&&(de>0)){
	    num=num;
	    de=de;}
	else{ if((num>0)&&(de<0)){
		num=0-num;
		de=Math.abs(de);}
	    else{
		if((num<0)&&(de<0)){
		    num=Math.abs(num);
		    de=Math.abs(de);}
		else{
		    if ((num<0)&&(de>0)){
			num=num;
			de=de;}}}}}

    //OBSERVER
    public int get_numerator()
    {
	return num;
    }
    public int get_denomenator()
    {
	return de;
    }


    //toString
    public String toString(){
	if (cas==3){
	    String c = new String("Your rational number is:  "+num+"/"+de+".");
	    return c;}
	else{
	    String c=new String("Your rational number is:  "+num+".");
	    return c;
	}
    }


    //ARITHMETIC
    //ADD
    public Rational add(Rational r){
	int num2=r.get_numerator();
	int de2=r.get_denomenator();
	int num3=(num*de2)+(num2*de);
	int de3=de*de2;
	Rational a=new Rational(num3,de3);
	a.reduce();
	return a;}
	
    //SUBTRACTION
    public Rational subtract(Rational r){
	int num2=r.get_numerator();
	int de2=r.get_denomenator();
	int num3=(num*de2)-(num2*de);
	int de3=de*de2;
	Rational a=new Rational(num3,de3);
	a.reduce();
	return a;}
    //MULTIPLY
    public Rational multiply(Rational r){
	int num2=r.get_numerator();
	int de2=r.get_denomenator();
	int num3=num2*num;
	int de3=de*de2;
	Rational a=new Rational(num3,de3);
	a.reduce();
	return a;}
    //DIVIDE edited to account for Arithmetic Exception
    public Rational divide(Rational r) throws ArithmeticException
    {
	int num2=r.get_numerator();
	int de2=r.get_denomenator();
	int num3=num*de2;
	int de3=de*num2;
	if  (num2 == 0) {
	    throw new ArithmeticException("Can't divide by 0");
	}
	else{	 
	Rational a=new Rational(num3,de3);
	a.reduce();
	return a;}}

    //MAIN-TEST
     public static void main(String[] args)

     {

	 System.out.println();
	 System.out.println("NICK MILLER & MINH DUC THUONG NGUYEN - RATIONAL TESTING UPDATED!");
	 Rational r=new Rational(1,2);
	 Rational s=new Rational(0,8);
	 Rational t=new Rational(6,8);
	 Rational a=new Rational();
	 Rational b=new Rational(10);
	 try {
	     Rational c=new Rational(12,0);
	     System.out.println(c);
	 }
	 catch (BadDataException e) {
	     System.out.println(e);
	 }
	 System.out.println(r);
	 System.out.println(s);
	 System.out.println(t);
	 System.out.println(a);
	 System.out.println(b);
	 t.reduce();
	 System.out.println(t);
	 System.out.println(t.get_numerator());
	 System.out.println(t.get_denomenator());

	 System.out.println(r.add(t)+"(SUM)");
	 System.out.println(r.subtract(t)+"(SUBTRACTION)");
	 System.out.println(r.multiply(t)+"(MULTIPLICATION)");
	 try {
	 System.out.println(r.divide(s)+"(DIVISION)");
	 } 
	 //illegal division, will throw an exception 
	 catch (ArithmeticException e) {
	     System.out.println(e);
	 }
	 System.out.println(r.divide(t)+"(DIVISION)");
     }	 
 }

