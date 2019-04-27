	public interface Polylinje extends java.lang.Iterable<Punkt> {



		Punkt[] getHorn();



		String getFarg();



		int getBredd();



		double langd();



		String toString();



		void setFarg(String farg);



		void setBredd(int bredd);



		void laggTill(Punkt horn);



		void laggTillFramfor(Punkt horn, String hornNamn);



		void taBort(String hornNamn);

		
		java.util.Iterator<Punkt> iterator ();

	}
