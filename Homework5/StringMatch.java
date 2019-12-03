import java.util.*;
import java.math.*;

public class StringMatch{

	public static ArrayList<Integer> indexArray = new ArrayList<Integer>();

	public static int[] CheckStringMatch(char[] text_arr, char[] fragment_arr){

	int [] index = null;

	int[] nullArray = new int[1];

	int textArrLength = text_arr.length;

	int fragmentArrLength = fragment_arr.length; 

	long textHash = convertToHash(text_arr,textArrLength);

	long fragmentHash = convertToHash(fragment_arr,fragmentArrLength);



	//System.out.println("The text length is "+textArrLength);

	//System.out.println("The fragment Arr is "+fragmentArrLength);


	if(text_arr == null || fragment_arr == null){
		index = new int[0];
		return index;
	}

	else if(textArrLength < fragmentArrLength){
		index = new int[0];
		return index;
	}

	if(textHash == fragmentHash){
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

	public static void main(String[] args){
	
		char[] text_arr = {'H','a','l','i','m',' ','g','e','t','s',' ','a','l','i','g','n','m','e','n','t'};

		char[] fragment_arr = {'a','l','i'};

		CheckStringMatch(text_arr,fragment_arr);

	}
	
}