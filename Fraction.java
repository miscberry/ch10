public class Fraction{
    
    //instance variables (attributes, fields)
    private int numerator, denominator;
    
    //constructors
    public Fraction() { //default
	setNum(1);
	setDenom(1);
    }
    
    public Fraction(int n, int d) { //parameterized constructor
	setNum(n);
	setDenom(d);
    }
    
    public Fraction(String f) { //takes a String like "100/3"
	int slash = f.indexOf("/");
	setNum(Integer.parseInt(f.substring(0, slash)));
	setDenom(Integer.parseInt(f.substring(slash+1)));
    }
    
    public Fraction(Fraction f) { //copy constructor
	numerator = f.numerator;
	denominator = f.denominator;
    }
    
    //behaviour methods
    //accessor methods
    public int getNum() {
	return numerator;
    }
    public int getDenom() {
	return denominator;
    }
    
    public String toString() {
	return numerator + "/" + denominator;
    }
    
    public double toDouble() {
	return (double) numerator/denominator;
    }
    
    //mutator methods
    public void setNum(int n) {
	numerator = n;
    }
    
    public void setDenom(int d) {
	if(d != 0) 
	    denominator = d;
	else {
	    denominator = 1;
	    System.err.println("Error: Denominator can't be zero");
	}
    }
    
    public void reduce() {
	int g = gcf(numerator, denominator);
	numerator = numerator/g;
	denominator = denominator/g;
	if(denominator < 0) { //keep the negative sign on the numerator
	    numerator = -numerator;
	    denominator = -denominator;
	}
    }
    
    //static methods
    public static Fraction multiply(Fraction a, Fraction b) {
	int n = a.getNum()*b.getNum();
	int d = a.getDenom()*b.getDenom();
	Fraction product = new Fraction(n,d);
	product.reduce();
	return product;
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
	if(b.getNum() == 0) { //flipping 0/x would make a zero denominator
	    System.err.println("Error: Can't divide by zero");
	    return new Fraction();
	}
	Fraction flipped = new Fraction(b.getDenom(), b.getNum());
	return multiply(a, flipped);
    }
    
    public static Fraction add(Fraction a, Fraction b) {
	int n = a.getNum()*b.getDenom() + b.getNum()*a.getDenom();
	int d = a.getDenom()*b.getDenom();
	Fraction sum = new Fraction(n,d);
	sum.reduce();
	return sum;
    }
    
    public static Fraction subtract(Fraction a, Fraction b) {
	int n = a.getNum()*b.getDenom() - b.getNum()*a.getDenom();
	int d = a.getDenom()*b.getDenom();
	Fraction difference = new Fraction(n,d);
	difference.reduce();
	return difference;
    }
    
    //helper methods
    private static int gcf(int a, int b) { //Euclid's algorithm
	a = Math.abs(a);
	b = Math.abs(b);
	if(a == 0 || b == 0) { //the GCF of 0 and b is b
	    return Math.max(a, b);
	}
	while(a != b) {
	    if(a > b) {
		a = a-b;
	    } else {
		b = b-a;
	    }
	}
	return a;
    }
}
