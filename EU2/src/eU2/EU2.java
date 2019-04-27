package eU2;

public class EU2 {

	public static void main (String args[]) {
		int[] X = new int[] {4, 2, 5, 7, 8, 2, 7, 2, 6, 0};
		sortera(X.length-1, X);
	}
	
	public static void sortera(int n, int[] X)
	{
		int i = 0;
		int j;
		while (i < n)
		{
			j = i + 1;
			while (j <= n)
			{
				if (X[j] < X[i])
				{
					int temp = X[j];
					X[j] = X[i];
					X[i] = temp;
					System.out.println (java.util.Arrays.toString (X));
				}
				j++;
			}
		i++;
		}
		System.out.println(X[0]);
	}
}