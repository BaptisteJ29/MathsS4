package versionFinale;

public class Matrice implements IMatrice {

	private double[][] matrice;
	private MatriceInverse matriceInverse;
	private Determinant determinant;
	private AfficheMatrice afficheMatrice;
	private MatriceFactory matriceFactory;

	public Matrice() {
		super();
		this.matriceFactory = new MatriceFactory();
		this.matrice = this.matriceFactory.creerMatrice();
		this.matriceInverse = new MatriceInverse();
		this.determinant = new Determinant();
		this.afficheMatrice = new AfficheMatrice();
	}

	public Matrice(double[][] matrice) {
		super();
		this.matrice = matrice;
		this.matriceInverse = new MatriceInverse();
		this.determinant = new Determinant();
		this.matriceFactory = new MatriceFactory();
		this.afficheMatrice = new AfficheMatrice();
	}

	public boolean isInversible() {
		return this.determinant.getDeterminant(this) != 0;
	}

	public Matrice getMatriceInverse() {
		try {
			return new Matrice(this.matriceInverse.getInverse(this));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void afficherMatriceInverse() {
		if (this.isInversible()) {
			this.getMatriceInverse().afficherMatrice();
		} else {
			System.err.println("La matrice n'est pas inversible.");
		}
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
	
	public double[][] getMatriceValuesTranspose() {
		return this.getMatriceTranspose().getMatrice();
	}

	public void afficherMatrice() {
		this.afficheMatrice.afficherMatrice(this);
	}
	
	public void afficherMatrice(int column, int rows) {
		this.afficheMatrice.afficherMatrice(this, this.getNbColumns(), this.getNbRows());
	}

	public double getDeterminant() {
		return this.determinant.getDeterminant(this);
	}
	
	public double getDeterminantCombinaisonLineaire() {
		return this.determinant.getDeterminantAvecCombLin(this);
	}

	public void creerMatrice() {
		this.matrice = this.matriceFactory.creerMatrice();
//		this.matriceInverse = new MatriceInverse(this);
//		this.determinant = new Determinant();
//		this.matriceFactory = new MatriceFactory();
//		this.afficheMatrice = new AfficheMatrice();
	}
	
	public double getDeterminantLigne(int rang) {
		return this.determinant.calculDetMatriceLigne(this, rang);
	}
	
	public double getDeterminantColonne(int rang) {
		return this.determinant.calculDetMatriceColonne(this, rang);
	}
	
	public void getComparaisonDet(int puissance) {
		System.out.println(this.determinant.comparaisonDet(this, puissance));
	}
	
	public void calculVanDerMonde() {
		VanDerMonde vanDerMonde = new VanDerMonde();
		vanDerMonde.saisiVanDerMond();
	}
	
	public void afficherMatriceExposant(int puissance) {
		Matrice a = calculMatriceExposant(this, this, puissance);
		a.afficherMatrice();
	}
	
	public Matrice getMatriceExposant(int puissance) {
		Matrice a = calculMatriceExposant(this, this, puissance);
		return a;
	}

	private Matrice calculMatriceExposant(Matrice matriceSi, Matrice matrice2, int puissance) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int l = 0, c = 0;
		
		for (int i = 0; i < matriceSi.getDimension(); i++, c = 0, l++) {
			for (int j = 0; j < matriceSi.getDimension(); j++, c++) {
				int calcul = 0;
				for (int k = 0; k < matriceSi.getDimension(); k++) {
					calcul += matrice2.getValueAt(i, k) * matriceSi.getValueAt(k, j);
				}
				matriceTempo.setValueAt(l, c, calcul);
			}
		}

		if (puissance == 2)
			return matriceTempo;
		else
			return calculMatriceExposant(matriceSi, matriceTempo, --puissance);
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
	public double getValueAt(int x, int y) {
		return this.matrice[x][y];
	}

	@Override
	public void setValueAt(int x, int y, double valeur) {
		this.matrice[x][y] = valeur;
	}
	
	public int getNbColumns() {
		return this.matrice.length;
	}
	
	public int getNbRows() {
		if (this.matrice.length != 0) {
			return this.matrice[0].length;
		} else {
			System.err.println("La matrice a une taille de 0.");
			return 0;
		}
	}
	
	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}
}
