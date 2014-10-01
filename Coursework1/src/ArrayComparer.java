import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int[] array2 = new int[100];
  static int[] sumArray = new int[200];
  
  static int counter = 0;
  static int number;
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
	addArrays();
	print();
  }
  
  public static void print(){
	System.out.println("ARRAY1:");
	Printer.arrayNumbers(array1);
	System.out.println("ARRAY2:");
	Printer.arrayNumbers(array2);
	System.out.println("SUMARRAY:");
	Printer.arrayNumbers(sumArray);
  }
  
  public static void addArrays(){
	for (int i = 0; i<100; i++){
	  sumArray[i] = array1[i];
	}
	for (int j = 100; j<200; j++){
	  if (isNumberInArray(array2[j-100], sumArray) == false) { sumArray[j] = array2[j-100]; }
	}
  }
  
  public static boolean isNumberInArray(int number, int[] array){
	  boolean isContained = false;
	for (int element : array) {
	  if (number == element) { isContained = true; }
	}
	return isContained; 
  }
  
  public static boolean isNumberInArray(int number) {
	boolean isContained = false;
	if (guard == 1) {
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
  public static void addNumberToArray(int number) {
	if (guard == 1) {
	  array1[counter] = number;
	} else {
	  array2[counter] = number;
	}
	counter++;
  }
}