public class FractionDriver {
    
    public static void main(String[] args) {
	Fraction f1 = new Fraction();
	Fraction f2 = new Fraction(1,2);
	System.out.printf("%d/%d%n",f1.numerator, f1.denominator);
	System.out.printf("%d/%d%n",f2.numerator, f2.denominator);
    }
}
