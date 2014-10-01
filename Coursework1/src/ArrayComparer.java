import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int[] array2 = new int[100];
  static int elementsInCommon = 0;
  
  static int counter = 0;
  static int number;
  
  // Allows to choose on which array will work on
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
	print();
  }
  
  public static void print(){
	System.out.println("Values for array 1 is:");
	Printer.arrayNumbers(array1);
	System.out.println("Values for array 2 is:");
	Printer.arrayNumbers(array2);
	System.out.println("Common data:");
	Printer.arrayNumbers(findCommonNumbers());
	System.out.println("Number of common data is:");
	System.out.print(elementsInCommon);
	
	//TODO
//	System.out.println("Non-common values for array 1 is:");
//	System.out.println("Non-common values for array 2 is:");
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
  // get user input
  public static int number(){
	int number;
	System.out.println("Add integer, type 0 if you want to terminate");
	number = input.nextInt();
	return number;
  }  
 
  // add numbers to arrays
  public static void addNumberToArray(int number) {
	if (guard == 1) {
	  array1[counter] = number;
	} else {
	  array2[counter] = number;
	}
	counter++;
  }
}