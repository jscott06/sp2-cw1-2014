import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int counter = 0;
//  static int[] array2 = new int[100];

  static Scanner input = new Scanner( System.in );

  public static void main(String[] args) {
	  addNumberToArray(number());
	  addNumberToArray(number());
	  addNumberToArray(number());
	  

	  for (int element : array1) {
       System.out.println(element);
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
	  array1[counter] = number;
	  counter++;
  	}
  }