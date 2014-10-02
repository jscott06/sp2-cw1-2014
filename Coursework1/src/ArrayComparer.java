import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int[] array2 = new int[100];
  static int elementsInCommon = 0;
  
  static int counter = 0;
  static int number;
  static boolean bothArraysEmpty = true;
  
  // guard is used for switching through arrays and for stopping the loop
  // guard 1 => array1, guard 2 => array2, guard != (2 || 1) => stop
  static int guard = 1;
  
  static Scanner input = new Scanner( System.in );
  static Printer printer = new Printer();

  public static void main(String[] args) {
	while (guard == 1 || guard == 2){
	  number = number();
	  if (isZero(number) == false) {
		switch (guard) {
          case 1:  if (isNumberInArray(number, array1) == false) { addNumberToArray(number); }
                   break;
          case 2:  if (isNumberInArray(number, array2) == false) { addNumberToArray(number); }
                   break;
          default: break;
		}
	  }
	}
	if (bothArraysEmpty == false){
	  print();
	} else {
	  System.out.println("Both arrays are empty");
	}
  }
  
  public static void print(){
	System.out.print("Values for array 1 is: ");
	Printer.arrayNumbers(array1);
	System.out.print("Values for array 2 is: ");
	Printer.arrayNumbers(array2);
	System.out.print("Common data: ");
	Printer.arrayNumbers(findCommonNumbers());
	System.out.print("Number of common data is: ");
	System.out.println(elementsInCommon);
	System.out.print("Non-common values for array 1 is: ");
	Printer.arrayNumbers(findNonCommonValues(array1, array2));
	System.out.print("Non-common values for array 2 is: ");
	Printer.arrayNumbers(findNonCommonValues(array2, array1));
  }
  
  public static int[] findNonCommonValues(int[] mainArray, int[] checkArray){
	int[] nonCommonValues = new int[100];

	for (int i = 0; i<100; i++){
	  if (isNumberInArray(mainArray[i], checkArray) == false && mainArray[i] != 0){
		nonCommonValues[i] = mainArray[i];
	  }
	}
	return nonCommonValues;
  }
  
  public static int[] findCommonNumbers(){
	int[] commonNumbers = new int[100];
	for (int i = 0; i<100; i++){
	  // need to take out of the equation all the zeros
      if (isNumberInArray(array1[i], array2) == true && array1[i] != 0){
        commonNumbers[i] = array1[i];
        elementsInCommon++;
	  }
	}
	return commonNumbers;
  }
  
  
  // Checks if provided number is contained in provided array
  public static boolean isNumberInArray(int number, int[] array){
	  boolean isContained = false;
	for (int element : array) {
	  if (number == element) { isContained = true; }
	}
	return isContained; 
  }

  // Checks if inserted number is 0, if true also add 1 to guard
  public static boolean isZero(int number){
	if (number == 0){
	  guard++;
	  return true;
	} else {
	  return false;
	}
  }
  // Ask user input
  public static int number(){
	int number;
	if (guard == 1) {
	  System.out.println("Enter data for array 1 (0 to finish):");
	} else {
	  System.out.println("Enter data for array 2 (0 to finish):");
	}
	number = input.nextInt();
	return number;
  }  
 
  // Add numbers to arrays
  public static void addNumberToArray(int number) {
	bothArraysEmpty = false; // I am adding a number to any of the 2 therefore bothArraysEmpty = false
	if (guard == 1) {
	  array1[counter] = number;
	} else {
	  array2[counter] = number;
	}
	counter++;
  }
}