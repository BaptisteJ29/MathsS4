package versionFinale;

import java.util.Scanner;

public class VanDerMonde {
	
	public VanDerMonde() {
		super();
	}
	
	private void afficherDetVanDerMond(Matrice matriceSi) {
		StringBuilder res = new StringBuilder("Son determinant est : ");
		double det = 1.0;
		for (int i = matriceSi.getDimension() - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				// affichage des etapes du calcul de VanDerMond
				res.append("(");
				res.append(matriceSi.getValueAt(1, i));
				res.append(" - ");
				res.append(matriceSi.getValueAt(1, j));
				res.append(")");
				// calcul du determinant via VanDerMond
				det *= matriceSi.getValueAt(1, i) - matriceSi.getValueAt(1, j);
			}
		}
		res.append(" = ");
		res.append(det);
		System.out.println(res.toString());
	}
	
	public void saisiVanDerMond() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir la dimension de votre matrice de VanDerMond : ");
		String str = sc.nextLine();
	
		Matrice matrice = new Matrice(new double[Integer.parseInt(str)][Integer.parseInt(str)]);
	
		// remplissage de la matrice en ne saisissant que la 2eme ligne
		for (int i = 0; i < matrice.getDimension(); i++) {
			StringBuilder vandermonde = new StringBuilder();
			
			vandermonde.append("Saisir la ");
			vandermonde.append(String.valueOf(i + 1));
			vandermonde.append((i + 1 == 1) ? "ere " : "eme ");
			vandermonde.append("valeur de la 2eme ligne de votre matrice de Vandermonde :");
			System.out.println(vandermonde.toString());
			
			str = sc.nextLine();
			// remplissange de la colonne grace a la valeurs saisie
			for (int j = 0; j < matrice.getDimension(); j++) {
				matrice.setValueAt(j, i, Math.pow(Integer.parseInt(str), j));
			}
		}
		System.out.println("\nLa matrice de VanDerMond saisie est : ");
		matrice.afficherMatrice();
		this.afficherDetVanDerMond(matrice);
	}

}
