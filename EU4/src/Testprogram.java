
public class Testprogram {

	public static void main (String [] args) {
		Punkt a = new Punkt ("a", 10, 10);
		Punkt b = new Punkt ("b", 20, 20);
		Punkt c = new Punkt ("c", 30, 30);
		Punkt d = new Punkt ("d", 40, 40);
		Punkt[] f = {a, b, c};
		Polylinje polylinje = new VPolylinje ();
		Polylinje polylinje2 = new VPolylinje ();
		Polylinje polylinje3 = new NPolylinje (f);
		Polylinje polylinje4 = new NPolylinje (f);
		polylinje3.setFarg("gul");
		polylinje3.laggTill(d);
		polylinje3.taBort("a");
		polylinje3.laggTillFramfor(d, "c");
		System.out.println(polylinje3.toString());
		System.out.println("");
		Polylinje[] p = {polylinje, polylinje2, polylinje3, polylinje4};
		for (Punkt horn : polylinje)
		System.out.println(horn);
		System.out.println("");
		Polylinje pg = Polylinjer.hittaKortasteGulaPolylinje(p);
		System.out.println (pg);
	}
	
}
