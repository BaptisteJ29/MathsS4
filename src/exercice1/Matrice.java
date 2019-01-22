package exercice1;

import java.util.Scanner;

public class Matrice {

	private double[][] matrice;
	private int dimension;
	private DeterminantMatrice determinant;

	public Matrice() {
		this.demanderDimension();
		this.matrice = new double[this.dimension][this.dimension];
		this.determinant = new DeterminantMatrice();
		this.creaMatrice();
	}

//	public Matrice(int dimension) {
//		this.dimension = dimension;
//		this.determinant = new DeterminantMatrice();
//		this.matrice = new double[this.dimension][this.dimension];
//	}

	public Matrice(double[][] matrice) {
		this.matrice = matrice;
		this.determinant = new DeterminantMatrice();
		this.dimension = this.matrice.length;
	}

	private void creaMatrice() {
		Scanner sc = new Scanner(System.in);
//		String str = "";

//		System.out.println("Veuillez saisir la dimension de la matrice :");
//		str = sc.nextLine();
		this.demanderDimension();

//		double[][] matrice = new double[Integer.parseInt(str)][Integer.parseInt(str)];
//		System.out.println("Vous avez saisi : " + str);

//		for (int i = 0; i < (Integer.parseInt(str)); i++) {
//			for (int j = 0; j < Integer.parseInt(str); j++) {
//				System.out.println("Saisir la valeur pour les coordonnÃ©es : " + (i + 1) + " : " + (j + 1));
//				this.matrice[i][j] = Integer.parseInt(sc.nextLine());
//			}
//		}

		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.println("Saisir la valeur pour les coordonnées (" + (i + 1) + " ; " + (j + 1) + ") :");
				try {
					this.matrice[i][j] = sc.nextDouble();
				} catch (IllegalArgumentException e) {
					System.err.println("Vous devez saisir un nombre.");
				}
			}
		}

		this.afficherMatrice(matrice, dimension);
	}

	public void afficherMatrice(double[][] matrice, int dimension) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < matrice.length; i++) {
			stringBuilder.append("| ");
			for (int j = 0; j < matrice[i].length; j++) {
//				System.out.print(matrice[i][j] + " ");
				stringBuilder.append(this.getValueAt(i, j));
				stringBuilder.append(" ");
			}
			stringBuilder.append("|\n");
//			System.out.println();
		}

		System.out.println(stringBuilder.toString());
	}

	private void demanderDimension() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez saisir la dimension de la matrice :");
		try {
			this.dimension = sc.nextInt();

			if (this.dimension <= 0) {
				throw new IllegalArgumentException("Vous devez saisir un nombre entier positif supérieur à 0.");
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Vous devez saisir un nombre entier positif.");
		}

		System.out.println("Vous avez saisi : " + this.dimension);
	}

	public double test(double[][] matriceSi) {
		if (matriceSi.length == 2) {
			return (matriceSi[0][0] * matriceSi[1][1]) - (matriceSi[1][0] * matriceSi[0][1]);
		} else {
			double[][] matriceTempo = new double[matriceSi.length - 1][matriceSi.length - 1];
			int l = 0, c = 0;
			double det = 0;

			// System.out.println();
			for (int p = 0; p < matriceSi.length; p++) {
				l = 0;
				c = 0;
				for (int i = 1; i < matriceSi.length; i++) {
					c = 0;
					for (int j = 0; j < matriceSi[0].length; j++) {

						if (i != 0 && p != j) {
							matriceTempo[l][c] = matriceSi[i][j];
							c++;
						}
					}
					l++;
				}
				// afficherMatrice(matriceTempo, 3);

				if (matriceTempo.length == 2) {
					if ((((p + 1) + 1) % 2) == 0) {
						det += matriceSi[0][p]
								* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
						// System.out.println(" + Le DÃ©terminant est : " + (det) +
						// "");
					} else {
						det -= matriceSi[0][p]
								* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
						// System.out.println(" - Le DÃ©terminant est : " + (det) +
						// "");
					}
				} else {
					if ((((p + 1) + 1) % 2) == 0) {
						det += test(matriceTempo) * matriceSi[0][p];
					} else {
						det -= test(matriceTempo) * matriceSi[0][p];
					}
				}
			}
			// System.out.println("Determinant de la matrice finale : " + det +
			// "\n");
			return det;
		}
	}

	public int getDimension() {
		return this.dimension;
	}

	public double getValueAt(int x, int y) {
		return this.matrice[x][y];
	}
	
	public void setValueAt(int x, int y, double valeur) {
		this.matrice[x][y] = valeur;
	}

//	public double getLengthAtX(int x) {
//		return this.matrice[x].length;
//	}
//
//	public double getLengthAtY(int y) {
//		return this.matrice[y].length;
//	}

	public double getDeterminant() {
		return this.determinant.getDeterminant(this);
	}

	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}
}