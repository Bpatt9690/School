import java.util.*;

public class EgyptianFraction{

	public static ArrayList<Integer> returnArray = new ArrayList<Integer>();

	public static int[] egyptianFraction(int numerator, int denominator){

		int[] defaultArray = new int[1];

		if(numerator == 0 || denominator == 0){

			defaultArray[0] = 0;

			return defaultArray;
		}

		else if(numerator > denominator)
			findLargestBite(numerator,denominator);
		

		else if(numerator == 1)
			returnArray.add(denominator);

		else if(numerator < denominator && denominator != 1 )
			findLargestBite(numerator,denominator);
		

		else if(numerator == denominator)
			returnArray.add(numerator/denominator);
	
		return convertArray(returnArray);

	}

	public static void findLargestBite(int numerator, int denominator){

		int numeratorTemp = 0;

		int divisorTemp = 0;

		if(numerator < denominator){
			
			divisorTemp = 0;

			numeratorTemp = numerator;

			while(true){

				divisorTemp++;

				numeratorTemp = (divisorTemp * numerator);

				 if(numeratorTemp > denominator){
					performCalculations(numerator,denominator,divisorTemp);
					break;
				}

			}

		}

		else if(numerator > denominator)
			performCalculations(numerator,denominator,1);
		
	}

	public static void performCalculations(int numerator,int denominator, int largestBite){

		int lcm = 0;

		int bMultiple = 0;

		int oMultiple = 0;

		returnArray.add(largestBite);

		lcm = leastCommonMultiple(largestBite,denominator);

		bMultiple = 1*(lcm/largestBite);

		oMultiple = numerator * (lcm/denominator);

		numerator = oMultiple - bMultiple;

		denominator = lcm;

		simplifyFraction(numerator,denominator);

	}


	public static void simplifyFraction(int numerator, int denominator){

		int commonDivisor = 0;

		int newNumerator = 0;

		int newDenominator = 0;

		for(int i = 1; i <= denominator; i++){
			if(numerator % i == 0 && denominator % i == 0){
				commonDivisor = i;
			}
		}

		newNumerator = numerator / commonDivisor;

		newDenominator = denominator / commonDivisor;

		egyptianFraction(newNumerator,newDenominator);

	}

	public static int leastCommonMultiple(int d1, int d2){

		int leastCM = 0;

		if(d1 > d2)
			leastCM = d1;

		else
			leastCM = d2;

		while(true){

			if(leastCM % d1 == 0 && leastCM % d2 == 0)
				break;

			leastCM++;
		}

		return leastCM;

	}

	public static int[] convertArray(ArrayList l){

		int size = l.size();

		int[] array = new int[size];

		int buffer;

		for(int i = 0; i < size; i++){

			buffer = Integer.parseInt(l.get(i).toString());

			array[i] = buffer;
		}

	return array;

	}

}
