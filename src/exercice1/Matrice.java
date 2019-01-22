package exercice1;

import java.util.Scanner;

public class Matrice {

	private double[][] matrice;
	private int dimension;

	public Matrice(int dimension) {
		this.dimension = dimension;
	}

	public void creaMatrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir la dimension de la matrice :");
		String str = sc.nextLine();
		double[][] matrice = new double[Integer.parseInt(str)][Integer.parseInt(str)];
		System.out.println("Vous avez saisi : " + str);
		for (int i = 0; i < (Integer.parseInt(str)); i++) {
			for (int j = 0; j < Integer.parseInt(str); j++) {
				System.out.println("Saisir la valeur pour les coordonnées : " + (i + 1) + " : " + (j + 1));
				String valeur = sc.nextLine();
				matrice[i][j] = Integer.parseInt(valeur);
			}
		}
		afficherMatrice(matrice, dimension);
	}

	public void afficherMatrice(double[][] matrice, int dimension) {
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
	}

	public double test(double[][] matriceT) {
		double[][] matriceTempo = new double[matriceT.length - 1][matriceT.length - 1];
		int l = 0, c = 0;
		double det = 0;

		// System.out.println();
		for (int p = 0; p < matriceT.length; p++) {
			l = 0;
			c = 0;
			for (int i = 1; i < matriceT.length; i++) {
				c = 0;
				for (int j = 0; j < matriceT[0].length; j++) {

					if (i != 0 && p != j) {
						matriceTempo[l][c] = matriceT[i][j];
						c++;
					}
				}
				l++;
			}
			// afficherMatrice(matriceTempo, 3);

			if (matriceTempo.length == 2) {
				if ((((p + 1) + 1) % 2) == 0) {
					det += matriceT[0][p]
							* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
					// System.out.println(" + Le Déterminant est : " + (det) +
					// "");
				} else {
					det -= matriceT[0][p]
							* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
					// System.out.println(" - Le Déterminant est : " + (det) +
					// "");
				}
			} else {
				if ((((p + 1) + 1) % 2) == 0) {
					det += test(matriceTempo) * matriceT[0][p];
				} else {
					det -= test(matriceTempo) * matriceT[0][p];
				}
			}
		}
		// System.out.println("Determinant de la matrice finale : " + det +
		// "\n");
		return det;
	}
}