package versionFinale;

public class MatriceInverse implements IMatrice {

//	private Matrice matrice;

//	public MatriceInverse(Matrice matrice) {
//		super();
//		this.matrice = matrice;
//	}
	
	private double[][] matriceInverse;
	
	public MatriceInverse() {
		super();
	}

//	public Matrice getInverse() {
//		Matrice matriceInverse = this.matrice;
//		Matrice comatrice = new Matrice(new double[this.matrice.getDimension()][this.matrice.getDimension()]);
//		double det = this.matrice.getDeterminant();
//		
//		if (this.getDimension() == 2) {
//			double temp = matriceInverse.getValueAt(0, 0);
//			comatrice.setValueAt(0, 0, this.getValueAt(1, 1));
//			matriceInverse.setValueAt(0, 0, this.getValueAt(1, 1) * (1 / det));
//			comatrice.setValueAt(0, 1,  -(this.getValueAt(0, 1)));
//			matriceInverse.setValueAt(0, 1, -(this.getValueAt(0, 1) * (1 / det)));
//			comatrice.setValueAt(1, 0,  -(this.getValueAt(1, 0)));
//			matriceInverse.setValueAt(1, 0, -this.getValueAt(1, 0) * (1 / det));
//			comatrice.setValueAt(1, 1,  temp);
//			matriceInverse.setValueAt(1, 1, temp * (1/det));
//		} else {
//			matriceInverse = new Matrice(new double[this.getDimension()][this.getDimension()]);
//			Matrice tmp = null;
//
//			for (int i = 0; i < this.getDimension(); i++) {
//				for (int j = 0; j < this.getDimension(); j++) {
//					tmp = this.getNewMatrice(i, j);
//					comatrice.setValueAt(j, i, tmp.getDeterminant() * Math.pow(-1, i + j));
//					matriceInverse.setValueAt(i, j, Math.pow(-1, i + j) * (tmp.getDeterminant() / det));
//				}
//			}
//			matriceInverse = matriceInverse.getMatriceTranspose();
//		}
//		this.afficherMatriceInverse(comatrice, det);
//		return matriceInverse;
//	}
	
	public double[][] getInverse(Matrice matrice) {
		this.matriceInverse = matrice.getMatrice();
		Matrice comatrice = new Matrice(new double[matrice.getDimension()][matrice.getDimension()]);
		double det = matrice.getDeterminant();
		
		if (this.getDimension() == 2) {
			double temp = matriceInverse[0][0];
			comatrice.setValueAt(0, 0, this.getValueAt(1, 1));
			this.matriceInverse[0][0] = this.getValueAt(1, 1) * (1 / det);
			comatrice.setValueAt(0, 1,  -(this.getValueAt(0, 1)));
			this.matriceInverse[0][1] = -(this.getValueAt(0, 1) * (1 / det));
			comatrice.setValueAt(1, 0,  -(this.getValueAt(1, 0)));
			this.matriceInverse[1][0] = -this.getValueAt(1, 0) * (1 / det);
			comatrice.setValueAt(1, 1,  temp);
			this.matriceInverse[1][1] = temp * (1/det);
		} else {
			this.matriceInverse = new double[this.getDimension()][this.getDimension()];
			Matrice tmp = null;

			for (int i = 0; i < this.getDimension(); i++) {
				for (int j = 0; j < this.getDimension(); j++) {
					tmp = this.getNewMatrice(i, j);
					comatrice.setValueAt(j, i, tmp.getDeterminant() * Math.pow(-1, i + j));
					matriceInverse[i][j] = Math.pow(-1, i + j) * (tmp.getDeterminant() / det);
				}
			}
			Matrice m = new Matrice(this.matriceInverse);
			this.matriceInverse = m.getMatriceValuesTranspose();
		}
		this.afficherMatriceInverse(comatrice, det);
		return matriceInverse;
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

	public void afficherMatriceInverse(Matrice matrice, double determinant) {
		StringBuilder stringBuilder = new StringBuilder("(1/");
		stringBuilder.append(determinant);
		stringBuilder.append(") *");

		System.out.println(stringBuilder.toString());
		matrice.afficherMatrice();
	}

	@Override
	public double getValueAt(int x, int y) {
		return this.matriceInverse[x][y];
	}

	@Override
	public void setValueAt(int x, int y, double valeur) {
		this.matriceInverse[x][y] = valeur;
	}

	@Override
	public double[][] getMatrice() {
		return this.matriceInverse;
	}

	@Override
	public int getDimension() {
		return this.matriceInverse.length;
	}

}
