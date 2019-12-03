import java.util.*;
import java.math.*;

public class StringMatch{

	public static ArrayList<Integer> indexArray = new ArrayList<Integer>();

	public static int[] CheckStringMatch(char[] text_arr, char[] fragment_arr){

	int [] index = null;

	int[] nullArray = new int[1];

	if(text_arr == null || fragment_arr == null){
		return index;
	}

	int textArrLength = text_arr.length;

	int fragmentArrLength = fragment_arr.length; 

	long textHash = convertToHash(text_arr,textArrLength);

	long fragmentHash = convertToHash(fragment_arr,fragmentArrLength);

	if(textArrLength < fragmentArrLength){
		index = new int[0];
		return index;
	}

	else if(fragmentHash == 0 && textHash == 0){
		index = new int[0];
		return index;
	}

	else if(fragmentHash == 0 || textHash == 0){
		index = new int[0];
		return index;
	}

	else if(textHash == fragmentHash){
		index = new int[1];
		index[0] = 0;
		return index;
	}

	else if(textHash != fragmentHash){

		char[] array = null;

		for(int i = 0; i < (textArrLength - (fragmentArrLength-1)); i++){
		
			array = Arrays.copyOfRange(text_arr,i,textArrLength);

			textHash = convertToHash(array,fragmentArrLength);

			if(textHash == fragmentHash){
				indexArray.add(i);
			}
			
		}

		index = buildIndexArray(indexArray.size());

	}

	return index;

	}

	public static long convertToHash(char[] c, int size){

		long hashCode = 0;

		for(int i = 0; i < size; i++){
			hashCode += hashCode * 256 + c[i];
		}
		
		return hashCode;

	}

	public static int[] buildIndexArray(int size){

		int[] testArray = indexArray.stream().mapToInt(i -> i).toArray();

		indexArray.removeAll(indexArray);

		return testArray;

	}

}