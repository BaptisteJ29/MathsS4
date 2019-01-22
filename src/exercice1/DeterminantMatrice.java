package exercice1;

public class DeterminantMatrice {

	public DeterminantMatrice() {
		super();
	}
	
	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}
	
	private double calculDeterminant(double[][] matrice) {
		return this.calculDeterminant(new Matrice(matrice));
	}
	
	private double calculDeterminant(Matrice matriceSi) {
		if (matriceSi.getDimension() == 2) {
			return (matriceSi.getValueAt(0, 0) * matriceSi.getValueAt(1, 1)) - (matriceSi.getValueAt(1, 0) * matriceSi.getValueAt(0, 1));
		} else {
			double[][] matriceTempo = new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1];
			int l = 0, c = 0;
			double det = 0;

			// System.out.println();
			for (int p = 0; p < matriceSi.getDimension(); p++) {
				l = 0;
				c = 0;
				for (int i = 1; i < matriceSi.getDimension(); i++) {
					c = 0;
					for (int j = 0; j < matriceSi.getLengthAtX(0); j++) {

						if (i != 0 && p != j) {
							matriceTempo[l][c] = matriceSi.getValueAt(i, j);
							c++;
						}
					}
					l++;
				}
				// afficherMatrice(matriceTempo, 3);

				if (matriceTempo.length == 2) {
					if ((((p + 1) + 1) % 2) == 0) {
						det += matriceSi.getValueAt(0, p)
								* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
						// System.out.println(" + Le Déterminant est : " + (det) +
						// "");
					} else {
						det -= matriceSi.getValueAt(0, p)
								* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
						// System.out.println(" - Le Déterminant est : " + (det) +
						// "");
					}
				} else {
					if ((((p + 1) + 1) % 2) == 0) {
						det += this.calculDeterminant(matriceTempo) * matriceSi.getValueAt(0, p);
					} else {
						det -= this.calculDeterminant(matriceTempo) * matriceSi.getValueAt(0, p);
					}
				}
			}
			// System.out.println("Determinant de la matrice finale : " + det +
			// "\n");
			return det;
		}
	}
}

//if (matriceSi.length == 2) {
//	return (matriceSi[0][0] * matriceSi[1][1]) - (matriceSi[1][0] * matriceSi[0][1]);
//} else {
//	double[][] matriceTempo = new double[matriceSi.length - 1][matriceSi.length - 1];
//	int l = 0, c = 0;
//	double det = 0;
//
//	// System.out.println();
//	for (int p = 0; p < matriceSi.length; p++) {
//		l = 0;
//		c = 0;
//		for (int i = 1; i < matriceSi.length; i++) {
//			c = 0;
//			for (int j = 0; j < matriceSi[0].length; j++) {
//
//				if (i != 0 && p != j) {
//					matriceTempo[l][c] = matriceSi[i][j];
//					c++;
//				}
//			}
//			l++;
//		}
//		// afficherMatrice(matriceTempo, 3);
//
//		if (matriceTempo.length == 2) {
//			if ((((p + 1) + 1) % 2) == 0) {
//				det += matriceSi[0][p]
//						* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
//				// System.out.println(" + Le Déterminant est : " + (det) +
//				// "");
//			} else {
//				det -= matriceSi[0][p]
//						* ((matriceTempo[0][0] * matriceTempo[1][1]) - (matriceTempo[1][0] * matriceTempo[0][1]));
//				// System.out.println(" - Le Déterminant est : " + (det) +
//				// "");
//			}
//		} else {
//			if ((((p + 1) + 1) % 2) == 0) {
//				det += test(matriceTempo) * matriceSi[0][p];
//			} else {
//				det -= test(matriceTempo) * matriceSi[0][p];
//			}
//		}
//	}
//	// System.out.println("Determinant de la matrice finale : " + det +
//	// "\n");
//	return det;
//}
