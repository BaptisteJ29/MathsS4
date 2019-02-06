package versionFinale;

import version2.Matrice;

public class Main {

	public static void main(String[] args) {
		double[][] mat = {{3, 2, -1}, {2, 0, 1}, {-1, 2, 1}};
		Matrice m1 = new Matrice(mat);
		

		System.out.println("Determinant : " + m1.getDeterminant());
	}

}
