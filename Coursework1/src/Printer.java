public class Printer {
  public void arrayNumbers(int[] array) {
	boolean isEmpty = true;
	for (int element : array) {
	  if (element != 0) { 
		System.out.print(element + " "); 
		isEmpty = false;
	  }
	}
	if (isEmpty == true) { System.out.print("Empty array"); }
	System.out.println("");
  }
}
