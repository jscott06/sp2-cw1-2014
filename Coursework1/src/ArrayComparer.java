import java.util.Scanner;

public class ArrayComparer {

  final static int HUNDRED = 100;
  final static int ONE = 1;
  final static int TWO = 2;
  
  static int[] array1 = new int[HUNDRED];
  static int[] array2 = new int[HUNDRED];
  static int elementsInCommon = 0;
  static int counter = 0;
  static boolean bothArraysEmpty = true;
  static Scanner input = new Scanner(System.in);

  // guard is used for switching through arrays and for stopping the loop
  // guard 1 => array1, guard 2 => array2, guard != (2 || 1) => stop
  static int guard = 1;

  public static void main(String[] args) {
	int number;
	while (guard == ONE || guard == TWO){ // While guard is 1 or 2 keeps asking for user input (1 for array1 and 2 for array2)
	  number = getNumber();
	  if (isZero(number) == false) {
		switch (guard) {
          case 1:  if (isNumberInArray(number, array1) == false) { addNumberToArray(number); }
                   break;
          case 2:  if (isNumberInArray(number, array2) == false) { addNumberToArray(number); }
                   break;
		}
	  }
	}
	// If both arrays are empty skip calculations and print message
	if (bothArraysEmpty == false){
	  print();
	} else {
	  System.out.println("Both arrays are empty");
	}
  }

  public static void print(){
	Printer printer = new Printer(); // Creates a new instance of the Printer class
	System.out.print("Values for array 1 is: ");
	printer.arrayNumbers(array1);
	System.out.print("Values for array 2 is: ");
	printer.arrayNumbers(array2);
	System.out.print("Common data: ");
	printer.arrayNumbers(findCommonValues());
	System.out.print("Number of common data is: ");
	System.out.println(elementsInCommon);
	System.out.print("Non-common values for array 1 is: ");
	printer.arrayNumbers(findNonCommonValues(array1, array2));
	System.out.print("Non-common values for array 2 is: ");
	printer.arrayNumbers(findNonCommonValues(array2, array1));
  }

  public static int[] findNonCommonValues(int[] mainArray, int[] checkArray){
	int[] nonCommonValues = new int[HUNDRED];

	for (int i = 0; i<HUNDRED; i++){
	  // When number is NOT contained in checkArray and is not a 0, add number to nonCommonValues array
	  if (isNumberInArray(mainArray[i], checkArray) == false && mainArray[i] != 0){
		nonCommonValues[i] = mainArray[i];
	  }
	}
	return nonCommonValues;
  }

  public static int[] findCommonValues(){
	int[] commonValues = new int[HUNDRED];
	for (int i = 0; i<HUNDRED; i++){
	  // When number is contained in array2 and is not a 0, add number to commonValues array
      if (isNumberInArray(array1[i], array2) == true && array1[i] != 0){
        commonValues[i] = array1[i];
        elementsInCommon++;
	  }
	}
	return commonValues;
  }

  // Checks if number is contained in provided array
  public static boolean isNumberInArray(int number, int[] array){
	boolean isContained = false;
	for (int element : array) {
	  if (number == element) { isContained = true; }
	}
	return isContained; 
  }

  // Checks if inserted number is 0
  public static boolean isZero(int number){
	if (number == 0){
	  guard++; // When number = 0, add 1 to the guard
	  return true;
	} else {
	  return false;
	}
  }

  // Ask user input
  public static int getNumber(){
	int number;
	if (guard == ONE) {
	  System.out.println("Enter data for array 1 (0 to finish):");
	} else {
	  System.out.println("Enter data for array 2 (0 to finish):");
	}
	number = input.nextInt();
	return number;
  }  

  // Adds number to array depending on value of the guard
  public static void addNumberToArray(int number) {
	bothArraysEmpty = false; // Adding a number to any of the 2 arrays therefore bothArraysEmpty = false
	if (guard == ONE) {
	  array1[counter] = number;
	} else {
	  array2[counter] = number;
	}
	counter++;
  }
}