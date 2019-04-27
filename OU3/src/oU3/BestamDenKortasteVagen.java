package oU3;

public class BestamDenKortasteVagen {

    public static void main(String[] args) {
    	java.util.Scanner in = new java.util.Scanner(System.in);

        System.out.println("Mata in antal mellan stationer f�r Z2 (m)");
        int m = in.nextInt();
        System.out.println("Mata in antal mellanstationer f�r Z3 (n)");
        int n = in.nextInt();
        
        double[] ai = new double[m+1]; // l�ngden mellan z1 till z2
        double[][] bij = new double[m+1][n+1]; // l�ngden mellan stationer
        double[] cj = new double[n+1];// z3 till z4
        
        for (int i = 1; i <= m; i++){
            System.out.println("skriv in l�ngden fr�n X till mellan station: U" + i);
            ai[i] = in.nextDouble();
            // s�tta v�rden p� mellans stationerna
            for (int j = 1; j <= n ; j++){
                System.out.println("Skriv in l�ngden fr�n U" + i +" till : V" + j);
                bij[i][j] = in.nextDouble();
            }
         }
        
        for (int j = 1; j <= n; j++){
            System.out.println("Skriv in l�ngden f�r: V" + j + " till: Y");
            cj[j] = in.nextDouble();
        }
       
       int[] kortasteVagarna = DenKortasteVagen.mellanstationer(ai, cj, bij);;
       double kortasteVagen = DenKortasteVagen.langd( ai, cj, bij);
       System.out.println("Kortaste v�gen �r " + kortasteVagen + " l�ng och g�r igenom stationerna U" + kortasteVagarna[0] + " och V" + kortasteVagarna[1] );
    }
}
    