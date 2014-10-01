import java.util.Scanner;

public class ArrayComparer {

  static int[] array1 = new int[100];
  static int counter = 0;
//  static int[] array2 = new int[100];

  static Scanner input = new Scanner( System.in );

  public static void main(String[] args) {
	  addNumberToArray(1);
	  addNumberToArray(9);
	  addNumberToArray(23);

	  for (int element : array1) {
       System.out.println(element);
	  }
  }
	  
  public static void addNumberToArray(int number) {
		  array1[counter] = number;
		  counter++;
	  }
  }