public class BrutalGreat {
	
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
		   //~ imprime(); 
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
		char[] str = new char[]{'g','r','e','a','t','y','o','u','d','i'};
		for (int i=0; i < p.length; i++) System.out.print(str[i]+": "+p[i] + " "); 
		//~ ADEGIORTUY
		//~ 3820961475 - position
			System.out.println(p[3]+""+p[8]+""+p[2]+""+p[0]+""+p[9]+""+p[6]+""+p[1]+""+p[4]+""+p[7]+""+p[5]);
		//~ System.out.println(); 
		//~ System.out.println("-----"); 
		
	} //--imprime


	
	public static void main(String[] args) {
		int[] vet = {0,1,2,3,4,5,6,7,8,9};
		BrutalGreat.permuta(vet);
	}
	
	public static boolean check(int[] vet){
		int g = vet[0];
		int r = vet[1];
		int e = vet[2];
		int a = vet[3];
		int t = vet[4];
		int y = vet[5];
		int o = vet[6];
		int u = vet[7];
		int d = vet[8];
		int i = vet[9];
		
		int eq1 = g*1000+r*100+e*10+a;
		int eq2 = t*1000+y*100+o*10+u;
		int eq3 = d*10000+i*1000+d*100+i*10+t;
		
		if(eq1 + eq2 == eq3 
			&& g != 0 
			&& t != 0  
			&& d != 0  
			&& (a+u)%10 == t
			//~ && (e+o+Math.floor((a + u)/10))%10 == i
			//~ && (r+y+Math.floor((e+o+Math.floor((a + u)/10))/10))%10 == d 
			//~ && (g+t+(r+y+Math.floor((e+o+Math.floor((a + u)/10))/10)))%10 == i
			){ 
			
			return true;
		}
		else return false;
	}
	
}



/*
 * Permutation code based in:
 * http://www.devmedia.com.br/permutacoes-de-objetos-um-algoritmo-recursivo-em-java/27512
 * */



    
