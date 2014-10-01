import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int[] array2 = new int[100];
  
  static int counter = 0;
  static int number;
  static String guard = "array1";
  
  static Scanner input = new Scanner( System.in );
  static Printer printer = new Printer();

  public static void main(String[] args) {
	while (guard != "stop"){
	  number = number();
	  isNumberZero(number);
	  if (isNumberInArray(number) == false) { addNumberToArray(number); }
	}
	
	print();
  }
  
  public static void print(){
	System.out.println("ARRAY1:");
	Printer.arrayNumbers(array1);
	System.out.println("ARRAY2:");
	Printer.arrayNumbers(array2);
  }
  
  public static boolean isNumberInArray(int number) {
	boolean isContained = false;
	if (guard == "array1") {
	  for (int element : array1) {
	    if (number == element) { isContained = true; }
	  }
	} else {
	  for (int element : array2) {
	    if (number == element) { isContained = true; }
	  }
	}
    return isContained;
  }
  public static void isNumberZero(int number) {
	  // true if 0 false if not zero
	if (number == 0) { 
	  if (guard == "array1") {
		guard = "array2";
		counter = 0;
      } else {
	    guard = "stop";
      }
	}
  }
  // get user input
  public static int number(){
	int number;
	System.out.println("Add integer, type 0 if you want to terminate");
	number = input.nextInt();
	return number;
  }  
  public static void addNumberToArray(int number) {
	if (guard == "array1") {
	  array1[counter] = number;
	} else {
	  array2[counter] = number;
	}
	counter++;
  }
}