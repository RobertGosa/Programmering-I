package eU1;

public class Main {
	
	public static void main (String args[]) {
		
		int[] intArray = new int[] {2,1,5,7,8,4,6,2,6,7,2,7,2,2,3,5,8,0,7,8};
		min(intArray);
		System.out.println("------");
		newMin(intArray);
	}
	
	public static int min (int[] element) throws IllegalArgumentException
	{
	if (element.length == 0)
	throw new IllegalArgumentException ("tom samling");
	
	int[] sekvens = element;
	int antaletPar = sekvens.length / 2;
	int antaletOparadeElement = sekvens.length % 2;
	int antaletTankbaraElement = antaletPar + antaletOparadeElement;
	int[] delsekvens = new int[antaletTankbaraElement];
	int i = 0;
	int j = 0;
	System.out.println (java.util.Arrays.toString (sekvens));
	while (antaletPar > 0)
	{
	i = 0;
	j = 0;
	while (j < antaletPar)
	{
	delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
	i += 2;
	}
	if (antaletOparadeElement == 1)
	delsekvens[j] = sekvens[antaletPar * 2];
	sekvens = delsekvens;
	antaletPar = antaletTankbaraElement / 2;
	antaletOparadeElement = antaletTankbaraElement % 2;
	antaletTankbaraElement = antaletPar + antaletOparadeElement;
	System.out.println (java.util.Arrays.toString (sekvens));
	// spårutskrift 2 
	// (för att kunna se vad som händer i början)
	// if (antalVarv++ == 10)
//	    System.exit (0);
	}
		return sekvens[0];
	}
	
	public static int newMin (int[] element) {
		int min = element[0];
		for(int i = 1; i < element.length; i++) {
			if(min > element[i]) {
				min = element[i];
			}
			System.out.println(min);
		}
		return min;
	}
	
}
