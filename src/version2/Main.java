package version2;

public class Main {

	public static void main(String[] args) {
		double[][] mat = {{3, 2, -1}, {2, 0, 1}, {-1, 2, 1}};
		Matrice m1 = new Matrice(mat);
		

		System.out.println("Determinant : " + m1.getDeterminant());
		
		try {
			Matrice inverse = m1.getInverse();
			inverse.afficherMatrice(inverse.getMatrice(), inverse.getDimension());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
