package oU5;

import java.util.Random;

public class ValjPolylinje extends Polylinje{

    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args) {

        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje();
        for (Polylinje p:polylinjer )
       System.out.println(p.toString());
        
        Polylinje Polly = hittaKortasteGulaPolylinje(polylinjer);
        System.out.println("");
        System.out.println("HERE:" + Polly.langd());

    }

    public static Punkt slumpPunkt () {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);
        return new Punkt(n, x, y);
    }

    public static Polylinje slumpPolylinje () {

        Polylinje polylinje = new Polylinje();
        int antalHorn = 2 + rand.nextInt(7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];
        Punkt valdPunkt;
        String s ;
        char valtChar;
        int valtChari;
        while (antalValdaHorn < antalHorn) {
            valdPunkt = slumpPunkt();
            s = valdPunkt.getNamn();
            valtChar = s.charAt(0);
            valtChari = (int)valtChar - 65;

            if (valdaNamn[valtChari]) {
                continue;
            }else {
                polylinje.laggTill(valdPunkt);
                valdaNamn[valtChari] = true;
                antalValdaHorn++;
            }

        }
	int randomColor = rand.nextInt(3);
	if(randomColor == 0){
		polylinje.setFarg("gul");
	} else if(randomColor == 1){
		polylinje.setFarg("röd");
	} else if(randomColor == 2){
		polylinje.setFarg("blå");
	}
	
        return polylinje;

    }
    
    public static Polylinje hittaKortasteGulaPolylinje(Polylinje[] thisPolylinje)

	{
    	
    	int antalGula = 0;

		for(int i = 0; i < thisPolylinje.length; i++)

		{

			if(thisPolylinje[i].getFarg().equals("gul"))

			{

				antalGula++;

			}

		}

		if(antalGula == 0)

		{

			throw new NullPointerException("\n Inga gula Polylinjer!");

		}

		Polylinje[] gulaPolylinjer = new Polylinje[antalGula];

		int i2 = 0;

		for(int i = 0; i < thisPolylinje.length; i++)

		{

			if(thisPolylinje[i].getFarg().equals("gul"))

			{

				gulaPolylinjer[i2] = thisPolylinje[i];

				i2++;

			}

		}

		double kortaste = gulaPolylinjer[0].langd();

		int index = 0;

		for(int i = 0; i < gulaPolylinjer.length; i++)

		{

			if(gulaPolylinjer[i].langd() < kortaste)

			{

				kortaste = gulaPolylinjer[i].langd();
				index = i;

			}

		}
		
		return gulaPolylinjer[index];
	}

}
