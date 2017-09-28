package info.milanlatinovic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {

	 public static void main(String[] args) throws IOException {
         
         int a = 0, b = 0;
         
         System.out.println("Unesite stranicu a: ");
        
         try
         {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 a = Integer.parseInt(br.readLine());
         }
         
         catch(NumberFormatException ne)
         {
                 System.out.println("Pogrešna vrijednost " + ne);
                 System.exit(0);
         }
         
         System.out.println("Unesite stranicu b: ");
         
         try
         {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 b = Integer.parseInt(br.readLine());
         }
         
         catch(NumberFormatException ne)
         {
                 System.out.println("Pogrešna vrijednost " + ne);
                 System.exit(0);
         }

         double povrsina = a * b;
         double obim = (a + b) * 2;
        
         System.out.println("Povrsina:  " + povrsina);
         System.out.println("Obim:  " + obim);
 }
}
