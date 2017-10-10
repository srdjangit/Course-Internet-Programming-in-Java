/*
 * Klasa SwapNumbers vršiæe zamjenu mjesta 2 broja bez pomocne promjenjive
 */
package info.milanlatinovic.swap;

public class SwapElementsWithoutThirdVariableExample {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
         
         int num1 = 10;
         int num2 = 20;
        
         System.out.println("Prije zamjene");
         System.out.println("Vrijednost broja 1 :" + num1);
         System.out.println("Vrijednost broja 2 :" + num2);
        

         num1 = num1 + num2;
 
         num2 = num1 - num2;
   
         num1 = num1 - num2;
       
        
         System.out.println("Prije zamjene");
         System.out.println("Vrijednost broja 1 :" + num1);
         System.out.println("Vrijednost broja 2 :" + num2);
	 }

}
