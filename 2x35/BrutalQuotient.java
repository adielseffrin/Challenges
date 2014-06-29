public class BrutalQuotient {
	
	//numero da permutacao atual
	private static int cont=0; 
	private static int acc=0; 
	 
	//armazena a permutacao corrente 
	private static int[] p; 
	
	
	 /** 
	  * metodo principal: recebe o vetor cujos elementos que serao permutados 
	  *  @param vet 
	  */ 
	public static void permuta(int [] vet) { 
		  p = new int[vet.length]; 
		  permuta(vet,0); 
	} 
	
	/** 
   * método recursivo que implementa as permutacoes 
   * @param vet 
   * @param n 
   * */ 
   private static void permuta(int []vet, int n) { 
	   if (n==vet.length) { 
		   cont++; 
		   if(check(p)) imprime();
		}else { 
			for(int i=0; i < vet.length; i++) { 
				boolean achou = false; 
				for (int j = 0; j < n; j++) { 
					if (p[j]==vet[i]) achou = true; 
				} 
				if (!achou) { 
					p[n] = vet[i]; 
					permuta(vet,n+1); 
				} 
			} //--for 
		} //--if/else 
	} //--permuta
	
	/** imprime a permutacao corrente */ 
	private static void imprime() { 
		acc++;
		System.out.println(); 
		System.out.print("(" + acc + ") : "); 
		char[] str = new char[]{'a','b','c','d','e','f','g','h','i'};
		for (int i=0; i < p.length; i++) System.out.print(str[i]+": "+p[i] + " "); 
		System.out.println(p[0]+""+p[1]+""+p[2]+""+p[3]+""+p[4]+"/"+p[5]+""+p[6]+""+p[7]+""+p[8]);
				
	} //--imprime

	
	public static void main(String[] args) {
		int[] vet = {1,2,3,4,5,6,7,8,9};
		BrutalQuotient.permuta(vet);
	}
	
	public static boolean check(int[] vet){
		int a = vet[0];
		int b = vet[1];
		int c = vet[2];
		int d = vet[3];
		int e = vet[4];
		int f = vet[5];
		int g = vet[6];
		int h = vet[7];
		int i = vet[8];
				
		int eq1 = a*10000+b*1000+c*100+d*10+e;
		int eq2 = f*1000+g*100+h*10+i;
				
		if((double)eq1/eq2 == 9.0) return true;
		else return false;
	}
	
}

/*
 * Permutation code based in:
 * http://www.devmedia.com.br/permutacoes-de-objetos-um-algoritmo-recursivo-em-java/27512
 * */



    
