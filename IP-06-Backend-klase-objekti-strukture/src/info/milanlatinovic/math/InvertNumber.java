/*
 * Klasa InvertNumber vrsi invertovanje ulaznog broja
 */

package info.milanlatinovic.math;

public class InvertNumber {
	
	 public static void main(String[] args) {
		 
	
         int broj = 1234;
         int invertovaniBroj = 0;
         int temp = 0;
        
         while(broj > 0){
                
               
                 temp = broj%10;
                
            
                 invertovaniBroj = invertovaniBroj * 10 + temp;
                 broj = broj/10;
                  
         }
        

         System.out.println("Invertovani broj je: " + invertovaniBroj);
 }
}
