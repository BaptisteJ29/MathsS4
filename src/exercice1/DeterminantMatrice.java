package exercice1;

public class DeterminantMatrice {

	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}

	private double calculDeterminant(Matrice matriceSi) {
		if (matriceSi.getDimension() == 2) {
			return this.calculDetMatriceCarre2(matriceSi);
		} else {
			return this.calculDetMatriceCarreSup2(matriceSi);
		}
	}

	private double calculDetMatriceCarre2(Matrice matriceSi) {
		return (matriceSi.getValueAt(0, 0) * matriceSi.getValueAt(1, 1))
				- (matriceSi.getValueAt(1, 0) * matriceSi.getValueAt(0, 1));
	}

	private double calculDetMatriceCarreSup2(Matrice matriceSi) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
		int l = 0, c = 0;
		double determinant = 0;

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
					determinant += matriceSi.getValueAt(0, p) * calculDetMatriceCarre2(matriceTempo);
				} else {
					determinant -= matriceSi.getValueAt(0, p) * calculDetMatriceCarre2(matriceTempo);
				}
			} else {
				if ((((p + 1) + 1) % 2) == 0) {
					determinant += calculDetMatriceCarreSup2(matriceTempo) * matriceSi.getValueAt(0, p);
				} else {
					determinant -= calculDetMatriceCarreSup2(matriceTempo) * matriceSi.getValueAt(0, p);
				}
			}
		}
		return determinant;
	}

	private double[][] combinaisonLineaire(Matrice matriceSi) {
		double[][] matriceTempo = null;

		// recherche pour les lignes

		// recherche pour les colonnes

		return matriceTempo;
	}
	
	public void calculMatriceExposant(Matrice matriceSi, int puissance) {
		Matrice a = calculMatriceExposant(matriceSi, matriceSi, puissance);
		a.afficherMatrice(a.getMatrice(), a.getDimension());
	}

	private Matrice calculMatriceExposant(Matrice matriceSi, Matrice matrice2, int puissance) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int l = 0, c = 0;
		l = 0;
		for (int i = 0; i < matriceSi.getDimension(); i++) {
			c = 0;
			for (int j = 0; j < matriceSi.getDimension(); j++) {
				int calcul = 0;
				for (int k = 0; k < matriceSi.getDimension(); k++) {
					calcul += matrice2.getValueAt(i, k) * matriceSi.getValueAt(k, j);
				}
				matriceTempo.setValueAt(l, c, calcul);
				c++;
			}
			l++;
		}
		
		if (puissance == 2) {
			return matriceTempo;
		} else {
			puissance--;
			return calculMatriceExposant(matriceSi, matriceTempo, puissance);
		}
	}

	public String comparaisonDet(Matrice matriceSi, int puissance) {
		String bool = null;

		if (Math.pow(calculDeterminant(matriceSi),
				puissance) == calculDeterminant(calculMatriceExposant(matriceSi, matriceSi, puissance))) {
			bool = "Vrai";
		} else {
			bool = "Faux";
		}

		return bool + "\ndet(matrice)^" + puissance + " = " + Math.pow(calculDeterminant(matriceSi), puissance)
				+ " \ndet(matrice^" + puissance + ") = "
				+ calculDeterminant(calculMatriceExposant(matriceSi, matriceSi, puissance));
	}
}