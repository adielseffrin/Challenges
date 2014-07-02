import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination {
	
	public static void main(String[] args) {
		int[] vec = {1,2,3,4};
		System.out.println(checkVec(11,vec));
	}
	
	public static List<List<int>> distribute(int sum){
		List<List<int>> listOfLists = Lists.newArrayList();
		for(int i = 1; i <= sum-3; i++){
			for(int j=1; j <= sum-2-i; j++){
				for(int k = 1; k <= sum-i-j-1; k++){
					listOfLists.add(Lists.newArrayList(i,j,k,sum-i-j-k));
				}
			}
		}
		return listOfLists;
	}
	
	/*
	 * Check if the given vector have the sum of elements equals a given value
	 * @params int size, int[] vec
	 * @return boolean
	 * */
	public static boolean checkVec(int size, int[] vec){
		int norm = 0;
		boolean response = false;
		for(int i = 0; i < vec.length; i++){
			norm += vec[i];
		}
		if(norm == size) response = true;
		return response;
	};
	
}




    
