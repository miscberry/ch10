import java.util.Random;
import java.util.Scanner;

public class FractionQuiz {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Random random = new Random();
	Fraction f1 = new Fraction();
	Fraction f2 = new Fraction();
	String[] signs = {"*", "/", "+", "-"};
	String s = "";
	String ans = "";
	int correct = 0;
	int total = 0;
	Fraction cAns = new Fraction();
	while(!ans.equals("quit")) {
	    f1.setNum(random.nextInt(9) + 1);
	    f1.setDenom(random.nextInt(9) + 1);
	    f1.reduce();
	    f2.setNum(random.nextInt(9) + 1);
	    f2.setDenom(random.nextInt(9) + 1);
	    f2.reduce();
	    s = signs[random.nextInt(4)];
	    System.out.printf("%s %s %s = ", f1, s, f2);
	    ans = in.nextLine();
	    if     (s.equals("*")) cAns = Fraction.multiply(f1, f2);
	    else if(s.equals("/")) cAns = Fraction.divide(f1, f2);
	    else if(s.equals("+")) cAns = Fraction.add(f1, f2);
	    else                   cAns = Fraction.subtract(f1, f2);
	    cAns.reduce();
	    if(!ans.equals("quit")) {
		if (ans.equals(cAns.toString())) {
		    System.out.printf("Correct!%n%n");
		    correct++;
		} else {
		    System.out.printf("Wrong, the answer was %s%n%n", cAns);
		}
		total++;
	    }
	}
	double percent = (double) correct / total;
	System.out.printf("You answered %d/%d correctly, for a score of %.2f percent!", correct, total, percent);
    }
    
}
