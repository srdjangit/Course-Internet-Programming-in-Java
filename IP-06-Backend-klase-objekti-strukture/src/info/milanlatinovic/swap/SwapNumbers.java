/*
 * Klasa SwapNumbers vršiæe zamjenu mjesta 2 broja upotrebom pomoæne promjenjive.
 */

package info.milanlatinovic.swap;

public class SwapNumbers {

	/**
	 * @param args
	 */
	  public static void main(String[] args) {
          
          int num1 = 10;
          int num2 = 20;
         
          System.out.println("Prije zamjene");
          System.out.println("Vrijednost broja 1 :" + num1);
          System.out.println("Vrijednost broja 2 :" + num2);
         
       
          swap(num1, num2);
	  }

	  private static void swap(int num1, int num2) {
         
          int temp = num1;
          num1 = num2;
          num2 = temp;
         
          System.out.println("Nakon zamjene");
          System.out.println("Vrijednost broja 1 :" + num1);
          System.out.println("Vrijednost broja 2 :" + num2);
         
	  }

}
