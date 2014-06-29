public class BaseConverter {
	public static void main(String[] args) {
		String argument;
		int bi = 0,bo = 0, na = 0;
		double input=0, output = 0, out2 = 0;
		na = 0;
		if (args.length > 0) {
			for(int i = 0; i < args.length; i+=2) {
				try {
					argument = args[i].substring(1);
					//~ System.out.println(argument);
					switch (argument) {
						case "bi":
							System.out.println("Input base:" + Integer.parseInt(args[i+1]));
							bi = Integer.parseInt(args[i+1]);
							na++;
							break;
						case "bo":
							System.out.println("Output base:" + Integer.parseInt(args[i+1]));
							bo = Integer.parseInt(args[i+1]);
							na++;
							break;
						case "i":
							System.out.println("Input number:" + Double.parseDouble(args[i+1]));
							input = Double.parseDouble(args[i+1]);
							na++;
							break;
					}
				} catch (NumberFormatException e) {
					System.err.println("Error");
					System.exit(1);
				}
			}
			if(na == 3){
				output = toBase10(bi, input);
				out2 = fromBase10(bo, output);
				
			}else{
				System.err.println("Missing Arguments");
				System.exit(1);
			}
			
		}
		System.out.println("End:: (" + input + ")"+bi+" = (" + out2 + ")"+bo);
	}
	
	
	/*
	 * Convert any number in a base bi to the respective number in base 10
	 * input
	 * 	bi : base 
	 * 	input : number in base bi
	 * @return double output
	 * */
	public static double toBase10(int bi, double input){
		double output = 0;
		
		String inp = String.valueOf(input);
		int sizeReal = 0, size = inp.length();
		int[] intArray = new int[size];
		boolean next = true;
		for (int i = 0; i < size; i++) {
			if(inp.charAt(i) != '.' && next){
				 intArray[i] = Character.digit(inp.charAt(i), 10);
				 sizeReal++;
			}else next = false;
		}
		
		for (int i = 0; i < sizeReal; i++) {
			output += intArray[i]*(Math.pow(bi,sizeReal-i-1));
		}
				
		return output;
		
	}
	
	/*
	 * Convert any number in base 10 to the respective number in a base bo
	 * input
	 * 	bo : base 
	 * 	input : number in base 10
	 * @return double output
	 * */
	public static double fromBase10(int bo, double input){
		String outputS = "";
		int[] remain = new int[20];
		int i = 0;
		double output = 0;
		while(input != 0){
			remain[i] = (int)(input % bo);
			input = Math.floor(input/bo);
			++i;
		}
		
		for(int j = i-1; j >= 0; j--){
			outputS += String.valueOf(remain[j]);
		}
		output = Double.parseDouble(outputS);
		return output;
	}
	
}




    
