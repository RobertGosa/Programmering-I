package enTriangelOchDessCirklar;

import java.text.DecimalFormat;

public class EnTriangelOchDessCirklar {

    public static void main(String[] args)  {
    	
    	DecimalFormat numberFormat = new DecimalFormat("#.##");
        java.util.Scanner in = new java.util.Scanner(System.in);

        String meny="";




        while (meny != "avsluta"){

            System.out.println("ett for Inskriven, tva for Omskriven, avsluta for exit.");

                meny = in.nextLine();

            System.out.println("Ditt svar �r: " + meny);
            if (meny != null) {
                switch (meny) {
                    case "ett":
                        System.out.println("Skriv in l�ngden for f�rsta sidan.");
                        double fSida = in.nextDouble();
                        System.out.println("Skriv in l�ngden for andra sidan.");
                        double aSida = in.nextDouble();
                        System.out.println("Skriv in l�ngden for tredje sidan.");
                        double csida = in.nextDouble();
                        in.nextLine();
                        System.out.println(numberFormat.format(Triangel.inskriven(fSida, aSida, csida)));
                        break;
                    case "tva":
                        System.out.println("Skriv in l�ngden for f�rsta sidan.");
                        fSida = in.nextDouble();
                        System.out.println("Skriv in l�ngden for andra sidan.");
                        aSida = in.nextDouble();
                        System.out.println("Skriv in l�ngden for tredje sidan.");
                        csida = in.nextDouble();
                        in.nextLine();
                        System.out.println(numberFormat.format(Triangel.omskriven(fSida, aSida, csida)));
                        break;
                    case "avsluta":
                        meny = "avsluta";
                        break;
                }
            }


        }



    }
}