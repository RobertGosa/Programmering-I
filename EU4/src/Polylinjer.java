
public class Polylinjer {
	
	public static Polylinje hittaKortasteGulaPolylinje(Polylinje[] thisPolylinje)

	{
    	
    	int antalGula = 0;

		for(int i = 0; i < thisPolylinje.length; i++)
			
		{

			if(thisPolylinje[i].getFarg() == "gul")

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

			if(thisPolylinje[i].getFarg() == "gul")

			{

				gulaPolylinjer[i2] = thisPolylinje[i];

				i2++;

			}

		}

		double kortaste = gulaPolylinjer[0].langd();

		int index = 0;

		for(int i = 1; i < gulaPolylinjer.length; i++)

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
