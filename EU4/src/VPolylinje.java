import java.util.Iterator;
import java.util.Random;

public class VPolylinje implements Polylinje {
	
		private Punkt[] punktVektor;
		private String farg;
		private int bredd = 1;
		
		public VPolylinje()
		{
			punktVektor = skapaSlumpmassigPunktVektor();
			this.farg = skapaFarg();
		}

		public static Punkt[] skapaSlumpmassigPunktVektor()
		{
			int antalPunkter = new Random().nextInt(5) + 1;

			Punkt[] punktVektor = new Punkt[antalPunkter];

			for(int i = 0; i < antalPunkter; i++)
			{
				int x = new Random().nextInt(10) + 1;

				int y = new Random().nextInt(10) + 1;

				String c = "" + (char) (new Random().nextInt(25) + 65); 

				punktVektor[i] = new Punkt(c, x, y);
			}
			return punktVektor;
	}
		
		public String skapaFarg()
		{
			int fargCode = new Random().nextInt(3);
			String farg = null;

			switch(fargCode)
			{
			case 0:
				farg = "röd";
				break;
			case 1:
				farg = "blå";
				break;
			case 2:
				farg = "gul";
				break;
			default:
				farg = null;
				break;
			}
			return farg;
	}
		
		public Punkt[] getHorn() {
			return punktVektor;
		}

		public String getFarg() {
			return this.farg;
		}

		public int getBredd() {
			return this.bredd;
		}

		public double langd() {
			 double langden = 0;
		        for (int i = 0; i < this.punktVektor.length; i++){
		            try {
		               langden =+  this.punktVektor[i].avstand(this.punktVektor[i + 1]);
		            }catch (IndexOutOfBoundsException e){
		                break;
		            }
		        }
		        return langden;
		}

		public void setFarg(String farg) {
			this.farg = farg;
		}
		
		public void setBredd(int bredd) {
			this.bredd = bredd;
		}

	
		public void laggTill(Punkt horn) {
			 Punkt[] h = new Punkt[this.punktVektor.length + 1];
		        int i = 0;
		        for (i = 0; i < this.punktVektor.length; i++)
		            h[i] = this.punktVektor[i];
		        h[i] = new Punkt (horn);
		        this.punktVektor = h;
		}

		public void laggTillFramfor(Punkt horn, String hornNamn) {
			Punkt[] h = new Punkt[this.punktVektor.length + 1];



			for(int i = 0, i2 = 0; i < this.punktVektor.length; i++, i2++)

			{

				if(this.punktVektor[i].getNamn().equals(hornNamn))

				{

					h[i] = horn;

					i++;

				}

				h[i] = this.punktVektor[i2];

			}

			this.punktVektor = h;
		}

		public void taBort(String hornNamn) {
			Punkt[] h = new Punkt[this.punktVektor.length - 1];

			int i = 0;

			int i2 = 0;

			for(i = 0; i < this.punktVektor.length; i++)

			{

				if(this.punktVektor[i].getNamn().equals(hornNamn))

				{

					continue;

				}else

				{

					h[i2] = this.punktVektor[i];

					i2++;

				}

			}
		}
		
		public class PolylinjeIterator
	    {
	        private int aktuell = -1;
	        public PolylinjeIterator ()
	        {
	            if (VPolylinje.this.punktVektor.length > 0)
	                aktuell = 0;
	        }
	        public boolean finnsHorn ()
	        {
	            return aktuell != -1;
	        }
	        public Punkt horn () throws java.util.NoSuchElementException {
	            if (!this.finnsHorn())
	                throw new java.util.NoSuchElementException("slut av iterationen");

	            Punkt horn = VPolylinje.this.punktVektor[aktuell];
	            return horn;
	        }
	        public void gaFram ()
	        {
	            if (aktuell >= 0 &&
	                    aktuell < VPolylinje.this.punktVektor.length - 1)
	                aktuell++;
	            else
	                aktuell = -1;
	        }
	    }

		public Iterator<Punkt> iterator() {
			return new Iterator<Punkt>() {
				PolylinjeIterator iterator = new PolylinjeIterator();
				public boolean hasNext() {
					return iterator.finnsHorn();
				}
				
				public Punkt next()
				{
					Punkt horn = iterator.horn();
					iterator.gaFram();
					return horn;
				}
			};
		}

		public String toString()
		{
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("{");
			for(int i = 0; i < this.getHorn().length; i++)
			{
				sBuilder.append(this.getHorn()[i].toString());
			}
			sBuilder.append(", Färg: " + this.farg + " Längd: " + this.langd());
			sBuilder.append("}");
			
	return sBuilder.toString(); 
	}
}
