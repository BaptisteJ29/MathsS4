package versionFinale;

import java.util.Scanner;

public class Cramer {

	public Cramer() {
		super();
	}
	
	public void creationSystem() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int e = 0;

		System.out.println("Veuillez saisir le nombre d'equations dans votre systeme :");
		do {
			System.out.println("Attention, il doit y avoir au moins 2 equations");
			str = sc.nextLine();
			System.out.println("Vous avez saisi : " + str);
		} while (Integer.parseInt(str) < 2);

		Matrice matriceCoef = new Matrice(new double[Integer.parseInt(str)][Integer.parseInt(str)]);
		Matrice matriceRes = new Matrice(new double[Integer.parseInt(str)][1]);

		do {
			System.out.println("\nSaisie de l'equation n°" + (e + 1) + " de votre systeme");
			for (int i = 0; i < Integer.parseInt(str); i++) {
				System.out.println("Saisir le coeficient de la variable n°" + (i + 1));
				matriceCoef.setValueAt(e, i, Integer.parseInt(sc.nextLine()));
			}
			System.out.println("Saisir le resultat de cet equation :");
			matriceRes.setValueAt(e, 0, Integer.parseInt(sc.nextLine()));
			e++;
		} while (e < Integer.parseInt(str));

		System.out.println("\nVoici le systeme que vous avez saisi, transpose en matrice");
		System.out.println("Matrice des coeficients : ");
		matriceCoef.afficherMatrice();

		System.out.println("Matrice des resultats : ");
		matriceRes.afficherMatrice(matriceRes.getNbColumns(), matriceRes.getNbRows());

		double det = (matriceCoef.getDimension() == 2) ? matriceCoef.getDeterminant() : matriceCoef.getDeterminantLigne(0);

		System.out.println("Le determinant est : " + det);
		System.out.println((det == 0) ? "Ceci n'est pas un systeme de Cramer" : 
			systemeCramerSolution(matriceCoef, matriceRes, det));
		
//		sc.close();
	}
	
	private String systemeCramerSolution(Matrice matriceSi, Matrice matriceSol, double det) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int i = 0;
		double res = 0;
		StringBuilder solution = new StringBuilder("S = {(");

		for (int s = 0; s < matriceSi.getDimension(); s++) {

			// remplacer le code suivant par un clone()
			for (int x = 0; x < matriceSi.getDimension(); x++) {
				for (int y = 0; y < matriceSi.getDimension(); y++) {
					matriceTempo.setValueAt(x, y, matriceSi.getValueAt(x, y));
				}
			}
			res = 0;
			if (i == s) {
				for (int j = 0; j < matriceSol.getDimension(); j++) {
					matriceTempo.setValueAt(j, s, matriceSol.getValueAt(j, 0));
					res = matriceTempo.getDeterminantLigne(0) / det;
				}
				solution.append(res);
				solution.append(";");
			}
			matriceTempo.afficherMatrice();
			i++;
		}

		solution.append(")}");
		return solution.toString();
	}
}
