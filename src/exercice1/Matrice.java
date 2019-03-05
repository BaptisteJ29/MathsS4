package exercice1;

import java.util.List;
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
				System.out.println("Saisir la valeur pour les coordonnees : " + (i + 1) + " : " + (j + 1));
				this.matrice[i][j] = Integer.parseInt(sc.nextLine());
			}
		}

		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.println("Saisir la valeur pour les coordonnees (" + (i + 1) + " ; " + (j + 1) + ") :");
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
				throw new IllegalArgumentException("Vous devez saisir un nombre entier positif superieur a 0.");
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Vous devez saisir un nombre entier positif.");
		}
		System.out.println("Vous avez saisi : " + this.dimension);
	}

	public boolean isInversible() {
		return (this.getDeterminant() != 0.0);
	}

	public Matrice getInverse() throws Exception {
		if (this.isInversible()) {
			Matrice matriceInverse = this;

			if (this.getDimension() == 2) {
				double temp = matriceInverse.getValueAt(0, 0);
				matriceInverse.setValueAt(0, 0, this.getValueAt(1, 1));
				matriceInverse.setValueAt(0, 1, -this.getValueAt(0, 1));
				matriceInverse.setValueAt(1, 0, -this.getValueAt(1, 0));
				matriceInverse.setValueAt(1, 1, temp);
			} else {
				matriceInverse = new Matrice(new double[this.getDimension()][this.getDimension()]);
				Matrice tmp = null;
				double det = this.getDeterminant();

//				// On remplit la liste avec des listes.
//				for (int i = 0; i < this.getDimension(); i++) {
//					temp.add(new ArrayList<>());
//				}

				for (int i = 0; i < this.getDimension(); i++) {
					for (int j = 0; j < this.getDimension(); j++) {
						tmp = this.getNewMatrice(i, j);
						matriceInverse.setValueAt(i, j, Math.pow(-1, i + j) * (tmp.getDeterminant() / det));
					}
				} 
			}

			return matriceInverse.getMatriceTranspose();
		} else {
			throw new Exception("La matrice n'est pas réversible.");
		}
	}

	// transpose la matrice
	public Matrice getMatriceTranspose() {
		Matrice a = new Matrice(new double[this.getDimension()][this.getDimension()]);
		double tmp = 0;

		for (int i = 0; i < a.getDimension(); i++)
			for (int j = 0; j < a.getDimension(); j++) {
				tmp = this.getValueAt(j, i);
				a.setValueAt(i, j, tmp);
			}

		return a;
	}

	private Matrice getNewMatrice(int l, int c) {
		Matrice mat = new Matrice(new double[this.getDimension() - 1][this.getDimension() - 1]);
		int k = -1;
		int m = 0;

		for (int i = 0; i < this.getDimension(); i++) {
			k++;

			if (i == l) {
				k--;
				continue;
			}

			m = -1;

			for (int j = 0; j < this.getDimension(); j++) {
				m++;

				if (j == c) {
					m--;
					continue;
				}

				mat.setValueAt(k, m, this.getValueAt(i, j));
			}
		}

		return mat;
	}

	private List<List<Double>> createListValues(List<List<Double>> temp) {
		// On ajoute toutes les valeurs de la matrice dans les listes.
		for (int i = 0; i < this.getDimension(); i++) {
			for (int j = 0; j < this.getDimension(); j++) {
				temp.get(i).add(this.getValueAt(i, j));
			}
		}

		return temp;
	}

	public double getMoinsUn(int l, int c, int valeur) {
		return (l + c % 2 == 0) ? valeur : -valeur;
	}

	// ----------GETTERS--SETTERS-----------

	public int getDimension() {
		return this.dimension;
	}

	public double[][] getMatrice() {
		return matrice;
	}
	
	public DeterminantMatrice getDeterminantMatrie() {
		return this.determinant;
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