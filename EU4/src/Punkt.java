public class Punkt 

	{

		private String namn;

		private int x;

		private int y;

		public Punkt (Punkt p){
	        this.namn = p.getNamn();
	        this.x = p.getX();
	        this.y = p.getY();
	    }

		public Punkt(String namn, int x, int y)

		{

			this.namn = namn;

			this.x = x;

			this.y = y;

		}



		public void setNamn(String namn)

		{

			this.namn = namn;

		}



		public void setX(int x)

		{

			this.x = x;

		}



		public void setY(int y)

		{

			this.y = y;

		}



		public String getNamn()

		{

			return namn;

		}



		public int getX()

		{

			return x;

		}



		public int getY()

		{

			return y;

		}
		
		public double avstand(Punkt p){

	        return Math.sqrt(Math.pow((p.getX() - this.x), 2) + Math.pow((p.getY()-this.y) , 2));

	    }



		public String toString()

		{

			 String s ="";
		        s = "(" + this.namn + " " + this.x + "," + this.y + ")";
		        return s;

		}

	}

