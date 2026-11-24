public class FractionDriver {
    
    public static void main(String[] args) {
	//constructors
	Fraction f1 = new Fraction();
	Fraction f2 = new Fraction(2,6);
	Fraction f3 = new Fraction("1/3");
	Fraction f4 = new Fraction(f3);
	Fraction f5 = new Fraction(5,0); //error, denominator becomes 1
	System.out.println("Default: " + f1);
	System.out.println("2,6: " + f2);
	System.out.println("\"1/3\": " + f3);
	System.out.println("Copy of f3: " + f4);
	System.out.println("5,0: " + f5);
	
	//accessors
	System.out.printf("%d/%d%n", f2.getNum(), f2.getDenom());
	System.out.println(f3.toDouble());
	
	//mutators
	f2.reduce();
	System.out.println("2/6 reduced: " + f2);
	Fraction f6 = new Fraction(252,-105);
	f6.reduce();
	System.out.println("252/-105 reduced: " + f6);
	f4.setNum(3);
	f4.setDenom(4);
	System.out.println("f4 set to: " + f4 + ", f3 is still " + f3);
	
	//static methods
	Fraction half = new Fraction(1,2);
	Fraction third = new Fraction(1,3);
	System.out.println(half + " * " + third + " = " + Fraction.multiply(half, third));
	System.out.println(half + " / " + third + " = " + Fraction.divide(half, third));
	System.out.println(half + " + " + third + " = " + Fraction.add(half, third));
	System.out.println(half + " - " + third + " = " + Fraction.subtract(half, third));
	System.out.println(third + " - " + half + " = " + Fraction.subtract(third, half));
	
	//seven sevenths adds up to exactly 1 (doubles give 0.9999999999999998)
	Fraction seventh = new Fraction(1,7);
	Fraction sum = new Fraction(0,1);
	for (int i = 0; i < 7; i++) {
	    sum = Fraction.add(sum, seventh);
	}
	System.out.println("1/7 added 7 times = " + sum);
    }
}
