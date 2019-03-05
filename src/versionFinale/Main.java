package versionFinale;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double[][] mat = {{3, 2, -1}, {2, 0, 1}, {-1, 2, 1}};
		double[][] mat2 = {{1, 8, 20}, {2, -4, 5}, {-1, 20, -5}};
		double[][] mat3 = {{1, 1, 2}, {-1, 5, 3}, {1, 7, -1}};
		double[][] mat4 = {{3, 5}, {2, 4}};
		double[][] mat5 = {{10, 2}, {30, 6}};
		double[][] mat6 = {{1, 8, 20}, {0, 0, 0}, {-1, 20, -5}};
		double[][] mat7 = {{1, 1, 1}, {5, 2, 3}, {25, 4, 9}};

		Matrice m1 = new Matrice(mat);
		Matrice m2 = new Matrice(mat2);
		Matrice m3 = new Matrice(mat3);
		Matrice m4 = new Matrice(mat4);
		Matrice m5 = new Matrice(mat5);
		Matrice m6 = new Matrice(mat6);
		Matrice m7 = new Matrice(mat7);

//		EXERCICE 1 : Calcul du déterminant et affichage de la matrice
//		System.out.println("Determinant : " + m1.getDeterminant());
//		m1.afficherMatrice();
		
//		EXERCICE 2 : Combinaison linéaires
//		System.out.println("Determinant : " + m1.getDeterminantCombinaisonLineaire());
		
//		EXERCICE 3 : Puissance de matrice et puissance déterminant
//		Matrice m1Exp2 = m1.getMatriceExposant(3);
//		Ou :
//		m1.afficherMatriceExposant(2);
//		m1.getComparaisonDet(2);
		
//		EXERCICE 4 : Calcul avec une matrice de Vandermonde
//		Matrice matrice = new Matrice();
//		matrice.calculVanDerMonde();

//		EXERCICE 5 : Inversion de la matrice
//		System.out.println("Matrice 1 : ");
//		m1.afficherMatriceInverse();
//		System.out.println("Matrice 2 : ");
//		m2.afficherMatriceInverse();
//		System.out.println("Matrice 3 : ");
//		m3.afficherMatriceInverse();
//		System.out.println("Matrice 4 : ");
//		m4.afficherMatriceInverse();
//		System.out.println("Matrice 5 : ");
//		m5.afficherMatriceInverse();
//		System.out.println("Matrice 6 : ");
//		m6.afficherMatriceInverse();
//		System.out.println("Matrice 7 : ");
//		m7.afficherMatriceInverse();
		
//		EXERCICE 6 : Système de Cramer et sa résolution
//		Cramer cramer = new Cramer();
//		cramer.creationSystem();
		
		Main.createMenu();
	}

	private static void createMenu() {
		Matrice matrice = null;
		boolean exit = false;
		
		do {
			StringBuilder menu = new StringBuilder("Menu principal :\n");
			menu.append("\t1) Creer une matrice\n");
			menu.append("\t2) Voir la matrice\n");
			menu.append("\t3) Trouver le determinant de la matrice\n");
			menu.append("\t4) Inverser la matrice\n");
			menu.append("\t5) Systeme de Cramer\n");
			menu.append("\t6) Matrice de Vandermonde\n");
			menu.append("\t7) Quitter le programme\n");

			System.out.println(menu.toString());
			
			
			switch (Main.getUserChoice()) {
			case 1 :
				matrice = new Matrice();
				break;
			case 2 :
				if (matrice != null)
					matrice.afficherMatrice();
				else
					System.err.println("Vous devez d'abord creer une matrice.");
				break;
			case 3 :
				if (matrice != null) {
					StringBuilder determinant = new StringBuilder("Determinant : ");
					determinant.append(String.valueOf(matrice.getDeterminant()));
					System.out.println(determinant.toString());
				} else
					System.err.println("Vous devez d'abord creer une matrice.");
				break;
			case 4 :
				if (matrice != null)
					matrice.afficherMatriceInverse();
				else
					System.err.println("Vous devez d'abord creer une matrice.");
				break;
			case 5 :
				Cramer cramer = new Cramer();
				cramer.creationSystem();
				break;
			case 6 :
				VanDerMonde vandermonde = new VanDerMonde();
				vandermonde.saisiVanDerMond();
				break;
			case 7:
				exit = true;
				System.out.println("Vous avez quittez le programme.");
				break;
			default :
				System.err.println("Vous devez selectioner une option appartenant au menu.");
				Main.createMenu();
				break;
			}
			System.out.println("\n\n");
		} while(!exit);

	}

	private static int getUserChoice() {
		try {
			Scanner sc = new Scanner(System.in);
			int res = sc.nextInt();
//			sc.close();
			return res;
		} catch (IllegalArgumentException e) {
			System.err.println("Vous devez entrer un nombre.");
			Main.getUserChoice();
		}
		return 0;
	}

}
