package oU5;

import java.util.Arrays;

public class Polylinje
{

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;
    public Polylinje ()
    {
        this.horn = new Punkt[0];
    }

    public Polylinje (Punkt[] horn, String farg)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) {
            this.horn[i] = new Punkt (horn[i]);
        }
    }


    public String toString () {
        String s = "";

        s = "{ " + "[" + Arrays.toString(this.horn) + "] Färg: " +  this.farg + " Längd: " + this.langd() + "}";
        return s;
    }
    
    public Punkt[] getHorn () {
        Punkt[] kopia = new Punkt[this.horn.length];
        for (int i = 0; i < horn.length; i++){

            kopia[i] = horn[i];

        }
        return kopia;
    }
    public String getFarg () {
        return this.farg;
    }
    public int getBredd () {
        return this.bredd;
    }
    public void setFarg (String farg) {
        this.farg = farg;
    }
    public void setBredd (int bredd) {
        this.bredd = bredd;
    }
    public double langd () {
        double langden = 0;
        for (int i = 0; i < this.horn.length; i++){
            try {
               langden =+  this.horn[i].avstand(this.horn[i + 1]);
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return langden;
    }


    public void laggTill (Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }
    
    public int findPunkt(String hornNamn)

	{

		int i = 0;

		for(i = 0; i < this.horn.length; i++)

		{

			if(this.horn[i].getNamn() == hornNamn)

			{

				break;

			}

		}

		return i;

	}
    
    public void laggTillFramfor(Punkt horn, String hornNamn)

	{

		Punkt[] h = new Punkt[this.horn.length + 1];



		for(int i = 0, i2 = 0; i < this.horn.length; i++, i2++)

		{

			if(this.horn[i].getNamn().equals(hornNamn))

			{

				h[i] = horn;

				i++;

			}



			h[i] = this.horn[i2];

		}

		this.horn = h;

	}
    
    public void taBort(String hornNamn)

	{

		Punkt[] h = new Punkt[this.horn.length - 1];

		int i = 0;

		int i2 = 0;

		for(i = 0; i < this.horn.length; i++)

		{

			if(this.horn[i].getNamn().equals(hornNamn))

			{

				continue;

			}else

			{

				h[i2] = this.horn[i];

				i2++;

			}

		}

	}
}
