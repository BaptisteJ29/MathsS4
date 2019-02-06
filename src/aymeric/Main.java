package aymeric;

public class Main {

	public static void main(String[] args) {

		double[][] matriceTest = { { 1, 2 }, { 3, 4 } };
		double[][] matriceTest2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] matrice = { { 5, 2, -2 }, { 1, 3, -3 }, { -1, 1, 1 } };
		double[][] matrice1 = { { 5, 2, -2, 1 }, { 1, 3, -3, 1 }, { -1, 1, 1, 1 }, { 3, -2, -7, 1 } };
		double[][] matrice2 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };
		double[][] matrice3 = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 } };
		
		Matrice uneMatriceTest = new Matrice(matriceTest2);

		System.out.println("Determinant matrice : " + uneMatriceTest.getDeterminant());
	}

}
