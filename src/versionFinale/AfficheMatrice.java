package versionFinale;

public class AfficheMatrice {
	
	private StringBuilder affichage;
	
	public AfficheMatrice() {
		super();
		this.affichage = new StringBuilder();
	}
	
	public void afficherMatrice(Matrice matrice) {
		for (int i = 0; i < matrice.getDimension(); i++) {
			this.affichage.append("| ");
			for (int j = 0; j < matrice.getDimension(); j++) {
				this.affichage.append(matrice.getValueAt(i, j) + " ");
			}
			this.affichage.append("|\n");
		}
		System.out.println(this.affichage.toString());
	}
	
	public void afficherMatrice(Matrice matrice, int cols, int rows) {
		for (int i = 0; i < cols; i++) {
			this.affichage.append("| ");
			for (int j = 0; j < rows; j++) {
				this.affichage.append(matrice.getValueAt(i, j) + " ");
			}
			this.affichage.append("|\n");
		}
		System.out.println(this.affichage.toString());
	}
}
