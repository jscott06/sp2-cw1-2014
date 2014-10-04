public class Printer {
  public void arrayNumbers(int[] array) {
	for (int element : array) { // Iterate through each element of the array
	  if (element != 0) { // and print every number that is not zero
		System.out.print(element + " "); 
	  }
	}
	System.out.println("");
  }
}
