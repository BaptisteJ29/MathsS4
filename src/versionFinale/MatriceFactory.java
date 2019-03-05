package versionFinale;

import java.util.Scanner;

public class MatriceFactory {

	private double[][]matriceValeurs;
	private int dimension;
	
	public MatriceFactory() {
		this.dimension = 0;
	}
	
	public double[][] creerMatrice() {
		Scanner sc = new Scanner(System.in);
		
		this.demanderDimension();
		this.matriceValeurs = new double[this.dimension][this.dimension];

		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.println("Saisir la valeur pour les coordonnees (" + (i + 1) + " ; " + (j + 1) + ") :");
				try {
					matriceValeurs[i][j] = sc.nextDouble();
				} catch (IllegalArgumentException e) {
					System.err.println("Vous devez saisir un nombre.");
				}
			}
		}
		
		return this.matriceValeurs;
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
}
