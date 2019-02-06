package versionFinale;

public class MatriceInverse implements IMatrice {

	private Matrice matrice;

	public MatriceInverse(Matrice matrice) {
		this.matrice = matrice;
	}

	public Matrice getInverse() throws Exception {
		if (this.matrice.isInversible()) {
			Matrice matriceInverse = new Matrice(this.matrice.getMatrice());

			if (this.getDimension() == 2) {
				double temp = matriceInverse.getValueAt(0, 0);
				matriceInverse.setValueAt(0, 0, this.getValueAt(1, 1));
				matriceInverse.setValueAt(0, 1, -this.getValueAt(0, 1));
				matriceInverse.setValueAt(1, 0, -this.getValueAt(1, 0));
				matriceInverse.setValueAt(1, 1, temp);
			} else {
				matriceInverse = new Matrice(new double[this.getDimension()][this.getDimension()]);
				Matrice tmp = null;
				double det = this.matrice.getDeterminant();

				for (int i = 0; i < this.getDimension(); i++) {
					for (int j = 0; j < this.getDimension(); j++) {
						tmp = this.getNewMatrice(i, j);
						matriceInverse.setValueAt(i, j, Math.pow(-1, i + j) * (tmp.getDeterminant() / det));
					}
				}
			}

			return matriceInverse;
		} else {
			throw new Exception("La matrice n'est pas réversible.");
		}
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

	@Override
	public double getValueAt(int x, int y) {
		return this.matrice.getValueAt(x, y);
	}

	@Override
	public void setValueAt(int x, int y, double valeur) {
		this.matrice.setValueAt(x, y, valeur);
	}

	@Override
	public double[][] getMatrice() {
		return this.matrice.getMatrice();
	}

	@Override
	public void setMatrice(double[][] matrice) {
		this.matrice.setMatrice(matrice);
	}

	@Override
	public int getDimension() {
		return this.matrice.getDimension();
	}

}
