package oU4;

import java.util.Scanner;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	    public static void main(String[] args) {
	    	
	    	 System.out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
	        
	        Scanner in = new Scanner(System.in);
	        String tal1 = "";
	        String tal2 = "";
	        //do {
	        	System.out.println("Det första naturliga heltalet:");
	            tal1 = in.next();
	            System.out.println("Det andra naturliga heltalet:");
	            tal2 = in.next();

	        //}
	        /*while (Integer.parseInt(tal2)<= 0 || Integer.parseInt(tal1) <= 0);
	        
	        int tTva = Integer.parseInt(tal2);
	        int tEtt = Integer.parseInt(tal1);
	        if (tTva > tEtt){
	            int temp = tEtt;
	            tEtt = tTva;
	            tTva = temp;
	        }

	        tal1= Integer.toString(tEtt);
	        tal2= Integer.toString(tTva);*/

	        
	        String summa = addera(tal1, tal2);
	        visa(tal1, tal2, summa, '+');
	        
	        String differans = subtrahera(tal1,tal2);
	        visa(tal1,tal2, differans,'-');

	    }

	    public static String addera(String tal1, String tal2) {
	    	 StringBuilder sBuilder = new StringBuilder();
	         int length = tal1.length();
	         tal2 = matchLength(length,tal2); 
	         int carry = 0;
	         int i = 0;

	         if (tal2.length() > length) 
	         {
	             length = tal2.length();
	             tal1 = matchLength(length, tal1);
	         }

	         tal1 = new StringBuilder(tal1).reverse().toString(); 
	         tal2 = new StringBuilder(tal2).reverse().toString();

	         while (i < length || carry == 1)  
	         {
	             int temp; 
	             if (i < length){
	                 
	                 temp = (tal1.charAt(i) - 48) + (tal2.charAt(i)-48) + carry;

	             }else {
	                 temp = carry;
	             }

	             carry = 0;

	             if (temp > 9) 
	             {
	                 carry = 1;
	                 sBuilder.append(temp % 10); 

	             }else {
	                 sBuilder.append(temp);
	             }
	             i++;
	         }
	         return new StringBuilder(sBuilder.toString()).reverse().toString(); 
	     }

	    public static String subtrahera(String tal1, String tal2){
	    	StringBuilder sBuilder = new StringBuilder(); 
			int length = tal1.length(); 
			tal2 = matchLength(length, tal2); 
			int carry = 0;
			int i = 0;

			if(tal2.length() > length)  
			{
				length = tal2.length(); 
				tal1 = matchLength(length, tal1); 
			}
			
			tal1 = new StringBuilder(tal1).reverse().toString();  
			tal2 = new StringBuilder(tal2).reverse().toString(); 

			while(i < length || carry == 1) 
			{
				int temp; 
				if(i < length)
				{
					
					temp = (tal1.charAt(i) - 48) 
							- (tal2.charAt(i) - 48)
							- carry;
				}else
				{
					temp = carry;
				}

				carry = 0;

				if(temp < 0)
				{
					carry = 1;
					sBuilder.append(10 + temp); 
				}else
				{
					sBuilder.append(temp);
				}
				i++;
			}
			if(sBuilder.length() != 1) 
			{
			if(sBuilder.charAt(sBuilder.length() - 1) == 48) 
			{
				sBuilder.deleteCharAt(sBuilder.length() - 1); 
			}
			}
			return new StringBuilder(sBuilder.toString()).reverse().toString(); 
	}
	    
	    public static void visa(String tal1, String tal2, String resultat, char operator) {
	        
	        int len1 = tal1.length();
	        int len2 = tal2.length();
	        int len = resultat.length();
	        int maxLen = Math.max(Math.max(len1, len2), len);
	        tal1 = sattLen(tal1, maxLen - len1);
	        tal2 = sattLen(tal2, maxLen - len2);
	        resultat = sattLen(resultat, maxLen - len);
	        System.out.println("  " + tal1);
	        System.out.println("" + operator + " " + tal2);
	        for (int i = 0; i < maxLen + 2; i++)
	        System.out.print("-");
	        System.out.println();
	        System.out.println(" " + resultat + "\n");
	    }

	    public static String sattLen(String s, int antal) {
	        StringBuilder sb = new StringBuilder(s);
	        for (int i = 0; i < antal; i++)
	            sb.insert(0, " ");
	        return sb.toString();
	    }

public static String matchLength (int length, String tal){
    StringBuilder sBuilder = new StringBuilder();
    while (sBuilder.length() < (length-tal.length())){
        sBuilder.append(0);
    }
    sBuilder.append(tal);
    return sBuilder.toString();
}
}
