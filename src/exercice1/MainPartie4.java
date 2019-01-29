package exercice1;

public class MainPartie4 {

	public static void main(String[] args) {
		double a = 3.0;
		double b = 4.0;
		double c = 5.0;
		
		double matriceTest[][] = {
				{1.0, 			 1.0, 			 1.0},
				{a, 			 b, 			 c},
				{Math.pow(a, 2), Math.pow(b, 2), Math.pow(c, 2)},
		};
		
		Matrice uneMatriceTest = new Matrice(matriceTest);
		
		System.out.println(uneMatriceTest.getDeterminant());
	}
}
