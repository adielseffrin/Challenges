public class Fibonacci {
	public static void main(String[] args) {
		int firstArg;
		double fibo = 0;
		if (args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				try {
					firstArg = Integer.parseInt(args[0]);
					fibo = calculate(1,1,2,firstArg);
				} catch (NumberFormatException e) {
					System.err.println("Argument" + args[0] + " must be an integer.");
					System.exit(1);
				}
			}
			System.out.printf("%.30f", fibo);
		}
	}
	/*
	 * Do the fibonacci sum
	 * input: 
	 * 	double first - 1st number in the sum
	 * 	double second - 2ndnumber
	 * 	int nth - current iteraction
	 *  int limit - searched fibonacci number 
	 * 
	 * @return nth fibonacci number
	 * */
	public static double calculate(double first, double second,int nth, int limit){
		System.out.println("1:" + first + " - 2:" + second + " - ith:" + nth);
		double fib = 0;
		if(nth < limit){
			fib = calculate(second, first+second, ++nth, limit);	
		}else{
			fib = second;		
		}
		return fib;
	}
}




    
