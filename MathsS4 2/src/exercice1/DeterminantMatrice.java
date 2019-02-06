package exercice1;

import java.util.Scanner;

public class DeterminantMatrice {

	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}

	public void creationSystem() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int e = 0;

		System.out.println("\nVeuillez saisir le nombre d'equations dans votre systeme:");
		do {
			System.out.println("Attention, il doit y avoir au moins 2 equations");
			str = sc.nextLine();
			System.out.println("Vous avez saisi : " + str);
		} while (Integer.parseInt(str) < 2);

		Matrice matriceCoef = new Matrice(new double[Integer.parseInt(str)][Integer.parseInt(str)]);
		Matrice matriceRes = new Matrice(new double[Integer.parseInt(str)][1]);

		do {
			System.out.println("\nSaisi de l'equation n°" + (e + 1) + " de votre systeme");
			for (int i = 0; i < Integer.parseInt(str); i++) {
				System.out.println("Saisir le coeficient de la variable n°" + (i + 1));
				matriceCoef.setValueAt(e, i, Integer.parseInt(sc.nextLine()));
			}
			System.out.println("Saisir le resultat de cet equation :");
			matriceRes.setValueAt(e, 0, Integer.parseInt(sc.nextLine()));
			e++;
		} while (e < Integer.parseInt(str));

		System.out.println("\nVoici le systeme que vous avez saisi, transpose en matrice");
		System.out.println("Matrice des coeficients");
		matriceCoef.afficherMatrice(matriceCoef.getMatrice(), matriceCoef.getDimension());

		System.out.println("Matrice des resultats");
		matriceRes.afficherMatrice(matriceRes.getMatrice(), matriceCoef.getDimension());

		double det = calculDeterminant(matriceCoef);
		if (det == 0) {
			System.out.println("Ceci n'est pas un system de Cramer");
		} else {
			System.out.println(systemeCramerSolution(matriceCoef, matriceRes, det));
		}
	}

	public String systemeCramer(Matrice matriceSi, Matrice matriceSol) {
		double det = calculDeterminant(matriceSi);
		if (det != 0) {
			return systemeCramerSolution(matriceSi, matriceSol, det);
		} else {
			return "Ce n est pas un systeme de Cramer";
		}
	}

	private String systemeCramerSolution(Matrice matriceSi, Matrice matriceSol, double det) {

		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int i = 0;
		double res = 0;
		String solution = "S = {(";

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
					res = calculDeterminant(matriceTempo) / det;
				}
				solution += res + ";";
			}
			i++;
		}

		solution += ")}";
		return solution;

	}

	private double calculDeterminant(Matrice matriceSi) {
		if (matriceSi.getDimension() == 2) {
			return this.calculDetMatriceCarre2(matriceSi);
		} else {
			return this.calculDetMatriceCarreSup2(matriceSi);
		}
	}

	private double calculDetMatriceCarre2(Matrice matriceSi) {
		return (matriceSi.getValueAt(0, 0) * matriceSi.getValueAt(1, 1))
				- (matriceSi.getValueAt(1, 0) * matriceSi.getValueAt(0, 1));
	}

	private double calculDetMatriceCarreSup2(Matrice matriceSi) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
		int l = 0, c = 0;
		double determinant = 0;

		for (int p = 0; p < matriceSi.getDimension(); p++) {
			l = 0;
			c = 0;
			for (int i = 1; i < matriceSi.getDimension(); i++) {
				c = 0;
				for (int j = 0; j < matriceSi.getDimension(); j++) {

					if (i != 0 && p != j) {
						matriceTempo.setValueAt(l, c, matriceSi.getValueAt(i, j));
						c++;
					}
				}
				l++;
			}

			if (matriceTempo.getDimension() == 2) {
				if ((((p + 1) + 1) % 2) == 0) {
					determinant += matriceSi.getValueAt(0, p) * calculDetMatriceCarre2(matriceTempo);
				} else {
					determinant -= matriceSi.getValueAt(0, p) * calculDetMatriceCarre2(matriceTempo);
				}
			} else {
				if ((((p + 1) + 1) % 2) == 0) {
					determinant += calculDetMatriceCarreSup2(matriceTempo) * matriceSi.getValueAt(0, p);
				} else {
					determinant -= calculDetMatriceCarreSup2(matriceTempo) * matriceSi.getValueAt(0, p);
				}
			}
		}
		return determinant;
	}

	private double[][] combinaisonLineaire(Matrice matriceSi) {
		double[][] matriceTempo = null;

		// recherche pour les lignes

		// recherche pour les colonnes

		return matriceTempo;
	}

	public void calculMatriceExposant(Matrice matriceSi, int puissance) {
		Matrice a = calculMatriceExposant(matriceSi, matriceSi, puissance);
		a.afficherMatrice(a.getMatrice(), a.getDimension());
	}

	private Matrice calculMatriceExposant(Matrice matriceSi, Matrice matrice2, int puissance) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int l = 0, c = 0;
		l = 0;
		for (int i = 0; i < matriceSi.getDimension(); i++) {
			c = 0;
			for (int j = 0; j < matriceSi.getDimension(); j++) {
				int calcul = 0;
				for (int k = 0; k < matriceSi.getDimension(); k++) {
					calcul += matrice2.getValueAt(i, k) * matriceSi.getValueAt(k, j);
				}
				matriceTempo.setValueAt(l, c, calcul);
				c++;
			}
			l++;
		}

		if (puissance == 2) {
			return matriceTempo;
		} else {
			puissance--;
			return calculMatriceExposant(matriceSi, matriceTempo, puissance);
		}
	}

	public String comparaisonDet(Matrice matriceSi, int puissance) {
		String bool = null;

		if (Math.pow(calculDeterminant(matriceSi),
				puissance) == calculDeterminant(calculMatriceExposant(matriceSi, matriceSi, puissance))) {
			bool = "Vrai";
		} else {
			bool = "Faux";
		}

		return bool + "\ndet(matrice)^" + puissance + " = " + Math.pow(calculDeterminant(matriceSi), puissance)
				+ " \ndet(matrice^" + puissance + ") = "
				+ calculDeterminant(calculMatriceExposant(matriceSi, matriceSi, puissance));
	}
}