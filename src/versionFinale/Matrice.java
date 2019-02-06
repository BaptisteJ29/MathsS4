package versionFinale;

public class Matrice implements IMatrice {

	private double[][] matrice;
	private MatriceInverse matriceInverse;
	private Determinant determinant;

	public Matrice(double[][] matrice) {
		super();
		this.matrice = matrice;
		this.matriceInverse = new MatriceInverse(this);
	}
	
	public boolean isInversible() {
		return this.determinant.getDeterminant(this) == 0;
	}
	
	public Matrice getMatriceInverese() {
		this.matriceInverse = new MatriceInverse(this);
		try {
			return this.matriceInverse.getInverse();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public Matrice getMatriceTranspose() {
		Matrice a = new Matrice(new double[this.getDimension()][this.getDimension()]);
		double tmp = 0.0;

		for (int i = 0; i < a.getDimension(); i++)
			for (int j = 0; j < a.getDimension(); j++) {
				tmp = this.getValueAt(j, i);
				a.setValueAt(i, j, tmp);
			}

		return a;
	}
	
	public double getDeterminant() {
		return this.determinant.getDeterminant(this);
	}
	
	@Override
	public int getDimension() {
		return this.matrice.length;
	}
	
	@Override
	public double[][] getMatrice() {
		return matrice;
	}
	
	@Override
	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}
	
	@Override
	public double getValueAt(int x, int y) {
		return this.matrice[x][y];
	}
	
	@Override
	public void setValueAt(int x, int y, double valeur) {
		this.matrice[x][y] = valeur;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < matrice.length; i++) {
			stringBuilder.append("| ");
			for (int j = 0; j < matrice[i].length; j++) {
				stringBuilder.append(this.getValueAt(i, j) + " ");
			}
			stringBuilder.append("|\n");
		}
		return stringBuilder.toString();
	}
}
