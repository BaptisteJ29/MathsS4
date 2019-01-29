package exercice1;

public class DeterminantMatrice {

	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}

	private double calculDeterminant(Matrice matriceSi) {
		// if (matriceSi.getDimension() == 2)
		// return this.calculDetMatriceCarre2(matriceSi);
		// else
		// return this.calculDetMatriceCarreSup2(matriceSi);
		calculMatriceExposant(matriceSi);

		return 0;
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

	private Matrice calculMatriceExposant(Matrice matriceSi) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension()][matriceSi.getDimension()]);
		int l = 0, c = 0;
		double valTempo = 0;

		l = 0;
		for (int i = 0; i < matriceSi.getDimension(); i++) {
			c = 0;
			for (int j = 0; j < matriceSi.getDimension(); j++) {
				int calcul = 0;
				for (int k = 0; k < matriceSi.getDimension(); k++) {
					calcul += matriceSi.getValueAt(i, k) * matriceSi.getValueAt(k, j);
				}
				valTempo = 0;
			}

			// matriceTempo.afficherMatrice(matriceTempo.getMatrice(),
			// matriceTempo.getDimension());
			return matriceTempo;
		}
	}

static int[][] multiplier(int[][] MA, int[][] MB) throws Exception{
	
	int[][] MC;
    
	int l,c;
	 
	 l = 0;
     for (int i = 0;i < MA.length;i++){ /// Ligne de MA
    	 c = 0;
        for (int n = 0;n < MB[0].length;n++){ /// colonne de  MB
        	
            int calcul= 0;
            for (int m = 0;m < MB.length;m++){  /// colone de MA et ligne de MB
            	
           	 System.out.printf("%4d    * %4d", MA[i][m],MB[m][n]);
           	
                calcul += MA[i][m] * MB[m][n];
                if (m == 0)
               	System.out.printf("    + ");
            }

            System.out.printf(" = %4d   ",calcul);
            MC[l][c] = calcul;
            c++;
        }
        System.out.printf("n");
        l++;
     }
     
     
	return MC;
}
