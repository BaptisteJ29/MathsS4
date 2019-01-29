package version2;

public class Main {

	private static final double[][] CONTENU_MATRICE_TEST = { { 1, 2 }, { 3, 4 } };
	private static final double[][] CONTENU_MATRICE_1 = { { 5, 2, -2 }, { 1, 3, -3 }, { -1, 1, 1 } };
	private static final double[][] CONTENU_MATRICE_2 = { { 5, 2, -2, 1 }, { 1, 3, -3, 1 }, { -1, 1, 1, 1 },
			{ 3, -2, -7, 1 } };
	private static final double[][] CONTENU_MATRICE_3 = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 },
			{ 1, 1, 1, 0 } };
	private static final double[][] CONTENU_MATRICE_4 = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
			{ 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } };

	public static void main(String[] args) {

		test(465);

//		System.out.println("Attendu : -2 \tRésultat : " + matriceTest.getDeterminant());
	}
	
	public static void test(int nbMatrice) {
		int dimension;
		Matrice matrice;
		DeterminantMatrice determinant;
		
		switch (nbMatrice) {
		case 0 :
			matrice = new Matrice();
			matrice.creerMatrice();
			 break;
		case 1 : 
			matrice = new Matrice(CONTENU_MATRICE_1);
			break;
		case 2 : 
			matrice = new Matrice(CONTENU_MATRICE_2);
			break;
		case 3 : 
			matrice = new Matrice(CONTENU_MATRICE_3);
			break;
		case 4 : 
			matrice = new Matrice(CONTENU_MATRICE_4);
			break;
			default :
				matrice = new Matrice(CONTENU_MATRICE_TEST);
				 break;
		}
		
		System.out.println(matrice);
		determinant = new DeterminantMatrice(matrice);
		System.out.println(determinant);
	}
}
