package exercice1;

public class Main {

	public static void main(String[] args) {

		double[][] matrice = { 
				{ 5, 2, -2 }, 
				{ 1, 3, -3 }, 
				{ -1, 1, 1 } };
		double[][] matrice1 = { 
				{ 5, 2, -2, 1 }, 
				{ 1, 3, -3, 1 }, 
				{ -1, 1, 1, 1 }, 
				{ 3, -2, -7, 1 } };
		double[][] matrice2 = { 
				{ 1, 1, 1, 1 }, 
				{ 1, 0, 1, 1 }, 
				{ 1, 1, 0, 1 }, 
				{ 1, 1, 1, 0 } };
		double[][] matrice3 = { 
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 } };
//		double dimension = 0;

//		Matrice uneMatrice = new Matrice(4);
//		uneMatrice.creaMatrice();
		// uneMatrice.afficherMatrice(matrice3, 3);
		// System.out.println("\n Le déterminant de la matrice est :");
		Matrice uneMatrice = new Matrice(matrice);
		Matrice uneMatrice1 = new Matrice(matrice1);
		Matrice uneMatrice2 = new Matrice(matrice2);
		Matrice uneMatrice3 = new Matrice(matrice3);
		System.out.println("Determinant matrice : " + uneMatrice.getDeterminant());
		System.out.println("Determinant matrice 1 : " + uneMatrice1.getDeterminant());
		System.out.println("Determinant matrice 2 : " + uneMatrice2.getDeterminant());
		System.out.println("Determinant matrice 3 : " + uneMatrice3.getDeterminant());
		System.out.println("Attendu : " + uneMatrice.test(matrice1));
	}

}
