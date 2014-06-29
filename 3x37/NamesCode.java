import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NamesCode {
	
	public static void main(String[] args) {
		int pos = 0;
		double prod = 0;
		String names = readFile("names.txt");
		String[] namesArray = names.split(",",-1);
		
		List<String> unsortList = new ArrayList<String>();
		
		for(int i = 0; i < namesArray.length; i++){
				unsortList.add(namesArray[i]);
		}
		
				
		//sort the list
		Collections.sort(unsortList);
 
		for(String temp: unsortList){
			pos++;
			prod += pos * generateCode(temp);
			System.out.println(temp+" - "+pos+" - "+generateCode(temp)+" - "+pos * generateCode(temp));
		}

		System.out.printf("%f",prod);
	}
	
	public static String readFile(String filename)
	{
	   String content = null;
	   File file = new File(filename); //for ex foo.txt
	   try {
		   FileReader reader = new FileReader(file);
		   char[] chars = new char[(int) file.length()];
		   reader.read(chars);
		   content = new String(chars);
		   reader.close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   return content;
	}
	
	public static int generateCode(String name){
		int code = 0;
		char[] letters = name.toCharArray();
		for(int i = 0; i < letters.length; i++){
			code += getLetterCode(letters[i]);
		}
		//~ System.out.println(letters.length);
		return code;
	}
	
	public static int getLetterCode(char letter){
			int out = 0;
			switch(letter){
				case 'a':
					out = 1;
					break;
				case 'b':
					out = 2;
					break;
				case 'c':
					out = 3;
					break;
				case 'd':
					out = 4;
					break;
				case 'e':
					out = 5;
					break;
				case 'f':
					out = 6;
					break;
				case 'g':
					out = 7;
					break;
				case 'h':
					out = 8;
					break;
				case 'i':
					out = 9;
					break;
				case 'j':
					out = 10;
					break;
				case 'k':
					out = 11;
					break;
				case 'l':
					out = 12;
					break;
				case 'm':
					out = 13;
					break;
				case 'n':
					out = 14;
					break;
				case 'o':
					out = 15;
					break;
				case 'p':
					out = 16;
					break;
				case 'q':
					out = 17;
					break;
				case 'r':
					out = 18;
					break;
				case 's':
					out = 19;
					break;
				case 't':
					out = 20;
					break;
				case 'u':
					out = 21;
					break;
				case 'v':
					out = 22;
					break;
				case 'w':
					out = 23;
					break;
				case 'x':
					out = 24;
					break;
				case 'y':
					out = 25;
					break;
				case 'z':
					out = 26;
					break;
				default:
					out = 0;
					break;
			}
			return out;
	}
	
}




    
