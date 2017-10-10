package info.milanlatinovic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cyrcle {

	 public static void main(String[] args) throws IOException {
         
         int poluprecnik = 0;
         System.out.println("Unesite poluprecnik: ");
        
         try
         {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 poluprecnik = Integer.parseInt(br.readLine());
         }
         
         catch(NumberFormatException ne)
         {
                 System.out.println("Pogresna vrijednost " + ne);
                 System.exit(0);
         }

         double povrsina = Math.PI * poluprecnik * poluprecnik;
         double obim = Math.PI * poluprecnik * 2;
        
         System.out.println("Povrsina:  " + povrsina);
         System.out.println("Obim:  " + obim);
 }
}
