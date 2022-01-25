import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		int i, j;
		double[][] arbeitstabelle = 
				{{30.20, 5, 0, 0},
				{30.30, 7, 0, 67,27},
				{31.50, 12, 0, 43,32},
				{32.20, 1, 0, 1.44},
				{32.70, 18, 0, 8.82},
				{33.00, 30, 0, 4.80},
				{33.20, 35, 0, 1.40},
				{33.50, 33, 0, 0.33},
				{33.80, 30, 0, 4.80},
				{34.20, 20, 0, 12.80},
				{34.50, 18, 0, 21.78},
				{34.80, 4, 0, 7.84},
				{35.00, 2, 0, 5.12}};
		
		double x_summe = 0, x_gewicht_summe = 0, x_summe_gewicht_summe = 0, x_varianz_gewicht_summe = 0, x_mittel = 0;
		
		DecimalFormat df = new DecimalFormat("00.00");

		for (i = 0; i < arbeitstabelle.length; i++) {
			
			x_summe = x_summe + arbeitstabelle[i][0];
			
			x_gewicht_summe = x_gewicht_summe + arbeitstabelle[i][1];
			
			arbeitstabelle[i][2] = arbeitstabelle[i][0] * arbeitstabelle[i][1];
			
			x_summe_gewicht_summe = x_summe_gewicht_summe + arbeitstabelle[i][2];
			
			x_mittel = x_summe_gewicht_summe / x_gewicht_summe;
			
		}
		
		System.out.print("x" + "\t" + "f" + "\t" + "x*f" + "\t" + "(x-x)2*f");
		System.out.println();
		System.out.println("----------------------------------");
		
		for (i = 0; i < arbeitstabelle.length; i++) {
			
			arbeitstabelle[i][3] = Math.pow(Math.abs(arbeitstabelle[i][0] - x_mittel), 2) * arbeitstabelle[i][1];
			x_varianz_gewicht_summe = x_varianz_gewicht_summe + arbeitstabelle[i][3];
			System.out.print(df.format(arbeitstabelle[i][0]) + "\t");
			System.out.print(df.format(arbeitstabelle[i][1]) + "\t");
			System.out.print(df.format(arbeitstabelle[i][2]) + "\t");
			System.out.print(df.format(arbeitstabelle[i][3]) + "\t");
			System.out.println();
			
			
		}
		System.out.println("----------------------------------");
		System.out.print("\t" + df.format(x_gewicht_summe) + "\t" + df.format(x_summe_gewicht_summe) + "\t" + df.format(x_varianz_gewicht_summe));
		System.out.println();
		System.out.println();
		System.out.println("x_mittel: " + df.format(x_mittel));
		System.out.println("s2: " + df.format(x_varianz_gewicht_summe / x_gewicht_summe));
		System.out.println("s: " + df.format(Math.sqrt(x_varianz_gewicht_summe / x_gewicht_summe)));
		
	}

}
