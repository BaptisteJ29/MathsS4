package exercice1;

public class Main {

	public static void main(String[] args) {

		double[][] matriceTest = { { 1, 2 }, { 3, 4 } };
		double[][] matrice = { { 5, 2, -2 }, { 1, 3, -3 }, { -1, 1, 1 } };
		double[][] matrice1 = { { 5, 2, -2, 1 }, { 1, 3, -3, 1 }, { -1, 1, 1, 1 }, { 3, -2, -7, 1 } };
		double[][] matrice2 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };
		double[][] matrice3 = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 } };

		double[][] matriceInversible = { { 3, 5 }, { 2, 4 } };
		double[][] matriceNonInversible = { { 10, 2 }, { 30, 6 } };


//		Matrice mInversible = new Matrice(matriceInversible);
//		Matrice mNonInversible = new Matrice(matriceNonInversible);
//		try {
//			Matrice inverseMatrice = mInversible.getInverse();
//			inverseMatrice.afficherMatrice(inverseMatrice.getMatrice(), inverseMatrice.getDimension());
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
		double[][] mat = {{3, 1, 2, 5}, {6, 1, 1, 2}, {9, 5, -3, 2}, {-1, 6, -3, -7}};
		Matrice m1 = new Matrice(mat);
		try {
			Matrice inverse = m1.getInverse();
			inverse.afficherMatrice(inverse.getMatrice(), inverse.getDimension());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m1.getDeterminant());
//		
//		try {
//			Matrice inverse = m1.getInverse();
//			inverse.afficherMatrice(inverse.getMatrice(), inverse.getDimension());
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

		// double dimension = 0;

		// Matrice uneMatrice = new Matrice(4);
		// uneMatrice.creaMatrice();
		// uneMatrice.afficherMatrice(matrice3, 3);
		// System.out.println("\n Le déterminant de la matrice est :");
//		Matrice uneMatriceTest = new Matrice(matriceTest);
//		Matrice uneMatrice = new Matrice(matrice);
//		Matrice uneMatrice1 = new Matrice(matrice1);
//		Matrice uneMatrice2 = new Matrice(matrice2);
//		Matrice uneMatrice3 = new Matrice(matrice3);
//		 System.out.println("Determinant matrice : " + uneMatrice.getDeterminant());
//		 System.out.println("Determinant matrice 1 : " +
//		 uneMatrice1.getDeterminant());
//		 System.out.println("Determinant matrice 2 : " +
//		 uneMatrice2.getDeterminant());
//		 System.out.println("Determinant matrice 3 : " +
//		 uneMatrice3.getDeterminant());

//		System.out.println("Attendu : " + uneMatriceTest.getDeterminant());
	}

}
