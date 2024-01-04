public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;    
	

	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int periods = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
				
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, periods, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);


		System.out.println(endBalance(loan, rate, periods, 10000));
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter = 0;
		double g = loan / n;
	    while  (endBalance(loan, rate, n, g) > 0) {
	    	g = g + epsilon;
			iterationCounter++;
		}
    	return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter = 0;   
    	double lo = loan / n,
    	       hi = loan,
    	       g = (lo + hi) / 2;
    	while  ((hi - lo) > epsilon) {  
    	    if (endBalance(loan, rate, n, g) * endBalance(loan, rate, n, lo) > 0)
    		    lo = g;
    		else
    		    hi = g;
    	    g = (lo + hi) / 2;
    	    iterationCounter++;
    	}
        return g;
    }

	private static double endBalance(double loan, double rate, int n, double payment) {
		rate = rate / 100;
		double balance = loan;		
		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * (1 + rate);
		}		
		return balance;
	}
}