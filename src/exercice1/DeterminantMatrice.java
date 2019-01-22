package exercice1;

public class DeterminantMatrice {

	private double determinant;

	public DeterminantMatrice() {
		super();
		this.determinant = 0.0;
	}

	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}

	private double calculDeterminant(Matrice matriceSi) {
		return (matriceSi.getDimension() == 2) ? this.calculDetMatriceCarre2(matriceSi)
				: this.calculDetMatriceCarreSup2(matriceSi);
	}

	private double calculDetMatriceCarre2(Matrice matriceSi) {
		return (matriceSi.getValueAt(0, 0) * matriceSi.getValueAt(1, 1))
				- (matriceSi.getValueAt(1, 0) * matriceSi.getValueAt(0, 1));
	}

	private double calculDetMatriceCarreSup2(Matrice matriceSi) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
		int l = 0, c = 0;

		for (int p = 0; p < matriceSi.getDimension(); p++) {
			l = 0;
			c = 0;
			for (int i = 1; i < matriceSi.getDimension(); i++) {
				c = 0;
				for (int j = 0; j < matriceSi.getDimension(); j++) {

					if (i != 0 && p != j) {
						matriceTempo.setValueAt(l, c, matriceSi.getValueAt(i, j));
						c++;
					}
				}
				l++;
			}

			if (matriceTempo.getDimension() == 2) {
				if ((((p + 1) + 1) % 2) == 0) {
					this.determinant += matriceSi.getValueAt(0, p)
							* ((matriceTempo.getValueAt(0, 0) * matriceTempo.getValueAt(1, 1))
									- (matriceTempo.getValueAt(1, 0) * matriceTempo.getValueAt(0, 1)));
				} else {
					this.determinant -= matriceSi.getValueAt(0, p)
							* ((matriceTempo.getValueAt(0, 0) * matriceTempo.getValueAt(1, 1))
									- (matriceTempo.getValueAt(1, 0) * matriceTempo.getValueAt(0, 1)));
				}
			} else {
				if ((((p + 1) + 1) % 2) == 0) {
					this.determinant += this.calculDeterminant(matriceTempo) * matriceSi.getValueAt(0, p);
				} else {
					this.determinant -= this.calculDeterminant(matriceTempo) * matriceSi.getValueAt(0, p);
				}
			}
		}
		return this.determinant;
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
