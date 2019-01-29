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

	public Matrice(double[][] matrice) {
		this.matrice = matrice;
		this.determinant = new DeterminantMatrice();
		this.dimension = this.matrice.length;
	}

	private void creaMatrice() {
		Scanner sc = new Scanner(System.in);
		String str = "";

		System.out.println("Veuillez saisir la dimension de la matrice :");
		str = sc.nextLine();
		this.demanderDimension();

		double[][] matrice = new double[Integer.parseInt(str)][Integer.parseInt(str)];
		System.out.println("Vous avez saisi : " + str);

		for (int i = 0; i < (Integer.parseInt(str)); i++) {
			for (int j = 0; j < Integer.parseInt(str); j++) {
				System.out.println("Saisir la valeur pour les coordonnÃ©es : " + (i + 1) + " : " + (j + 1));
				this.matrice[i][j] = Integer.parseInt(sc.nextLine());
			}
		}

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
				stringBuilder.append(this.getValueAt(i, j) + " ");
			}
			stringBuilder.append("|\n");
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

	// ----------GETTERS--SETTERS-----------
	
	public int getDimension() {
		return this.dimension;
	}

	public double[][] getMatrice() {
		return matrice;
	}

	public double getValueAt(int x, int y) {
		return this.matrice[x][y];
	}

	public void setValueAt(int x, int y, double valeur) {
		this.matrice[x][y] = valeur;
	}

	public double getDeterminant() {
		return this.determinant.getDeterminant(this);
	}

	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}
}