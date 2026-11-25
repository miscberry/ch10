public class EstimatingPi {
    public static void main(String[] args) {
	Fraction est = new Fraction(3,1);
	Fraction MILU = new Fraction( 355, 113 );
	final double EPSILON = Math.abs( Math.PI - MILU.toDouble() );
	
	while(Math.abs( Math.PI - est.toDouble() ) >= EPSILON) {
	    if(est.toDouble() < Math.PI) {
		est.setNum(est.getNum() + 1);
	    } else {
		est.setDenom(est.getDenom() + 1);
	    }
	}
	
	System.out.print(est);
    }
}
