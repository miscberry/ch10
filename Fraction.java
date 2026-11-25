import java.util.Random;

public class Fraction{
    
    private int numerator, denominator;
    Random random = new Random();
    
    public Fraction() {
	setNum(random.nextInt(9) + 1);
	setDenom(random.nextInt(9) + 1);
    }
    
    public Fraction(int n, int d) {
	setNum(n);
	setDenom(d);
    }
    
    public Fraction(String f) {
	int slash = f.indexOf("/");
	setNum(Integer.parseInt(f.substring(0, slash)));
	setDenom(Integer.parseInt(f.substring(slash+1)));
    }
    
    public Fraction(Fraction f) {
	numerator = f.numerator;
	denominator = f.denominator;
    }
    
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
	if(denominator < 0) {
	    numerator = -numerator;
	    denominator = -denominator;
	}
    }
    
    public boolean equals(Fraction f) {
	return getNum() == f.getNum() && getDenom() == f.getDenom();
    }
    
    public static Fraction multiply(Fraction a, Fraction b) {
	int n = a.getNum()*b.getNum();
	int d = a.getDenom()*b.getDenom();
	Fraction product = new Fraction(n,d);
	product.reduce();
	return product;
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
	if(b.getNum() == 0) {
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
    
    private static int gcf(int a, int b) {
	a = Math.abs(a);
	b = Math.abs(b);
	if(a == 0 || b == 0) {
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
