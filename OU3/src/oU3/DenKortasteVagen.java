package oU3;

public class DenKortasteVagen {

	public static double langd(double[] ai, double[] cj, double[][] bij) {
		double min = Double.MAX_VALUE;

		for (int i = 1; i <= ai.length - 1; i++) {
			for (int j = 1; j <= cj.length - 1; j++) {
				double kortvag = bij[i][j] + cj[j] + ai[i];
				System.out.println("X till station U" + (i) + " station V" + (j) + " och Y. Avstånd " + kortvag);
				if (kortvag < min) {
					min = kortvag;
				}
			}
			System.out.println();
		}

		return min;

	}

	public static int[] mellanstationer(double[] ai, double[] cj, double[][] bij) {
		int[] mellanstationer = new int[2];
		double min = Double.MAX_VALUE;

		for (int i = 1; i <= ai.length - 1; i++) {
			for (int j = 1; j <= cj.length - 1; j++) {
				double kortvag = bij[i][j] + cj[j] + ai[i];
				//System.out.println("X till station U" + (i) + ", station V" + (j) + " och Y. Avstånd " + kortvag);
				if (kortvag < min) {
					min = kortvag;
					mellanstationer[0] = i;
					mellanstationer[1] = j;
				}
			}
			System.out.println();
		}

		return mellanstationer;

	}

}