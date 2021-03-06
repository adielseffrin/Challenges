public class PrimeSum {
	public static void main(String[] args) {
		String argument;
		int input=0, na = 0, counter = 1, output, aux;
		if (args.length > 0) {
			for(int i = 0; i < args.length; i+=2) {
				try {
					argument = args[i].substring(1);
					switch (argument) {
						case "i":
							System.out.println("Input number:" + Integer.parseInt(args[i+1]));
							input = Integer.parseInt(args[i+1]);
							na++;
							break;
					}
				} catch (NumberFormatException e) {
					System.err.println("Error");
					System.exit(1);
				}
			}
			if(na == 1){
				//the sum of first prime (1 is not prime)
				if(input == 1) output = 2;
				//sum of more than one prime
				else{
					output = 2;
					aux = 3;
					while(counter < input){
						if(isPrime(aux)){
							output += aux;
							counter++;
						}
						//prime bigger than 2 are odd number -> odd + 2 = next odd
						aux += 2;
					}
				}
				System.out.println("The sum of "+ input+" primes is "+ output);
			}else{
				System.err.println("Missing Arguments");
				System.exit(1);
			}
			
		}
		System.out.println("---");
	}
	
	
		
	/*
	 * Check if the nuber is prime
	 * 	int number
	 * @return boolean
	 * */
	public static boolean isPrime(int number){
		double sqrt = Math.sqrt(number);
		int limit = (int)Math.floor(sqrt);
		int i = 3;
		boolean exit = true;
		//if a number is even and not 2, it's not prime
		if(number != 2 && number%2==0){
				exit = false;
		}
		//if a number have not divisors lower then your square root, then the number is prime
		while(i <= limit){
			if(number%i==0) exit = false;
			i+=2;
		}
		
		return exit;
	}
	
}




    
