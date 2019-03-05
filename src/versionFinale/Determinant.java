package versionFinale;

public class Determinant {

	public Determinant() {
		super();
	}

	public double getDeterminantAvecCombLin(Matrice matriceSi) {
		Matrice copy = matriceSi;
		return this.calculDeterminantAvecCombiLin(copy);
	}
	
	public double getDeterminant(Matrice matriceSi) {
		return this.calculDeterminant(matriceSi);
	}

	private double calculDeterminant(Matrice matriceSi) {
		return ((matriceSi.getDimension() == 2) ? this.calculDetMatriceCarre2(matriceSi) : this.calculDetMatriceCarreSup2(matriceSi));
	}
	
	private double calculDeterminantAvecCombiLin(Matrice matriceSi) {
		return ((matriceSi.getDimension() == 2) ? this.calculDetMatriceCarre2(matriceSi) : this.testOpti(matriceSi));
	}

	private double calculDetMatriceCarre2(Matrice matriceSi) {
		return ((matriceSi.getValueAt(0, 0) * matriceSi.getValueAt(1, 1))
				- (matriceSi.getValueAt(1, 0) * matriceSi.getValueAt(0, 1)));
	}

	private double calculDetMatriceCarreSup2(Matrice matriceSi) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
		int l = 0, c = 0;
		double determinant = 0.0;

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

			int valeurXY = ((p + 1) + 1) % 2;

			determinant += (matriceTempo.getDimension() == 2)
					? matriceSi.getValueAt(0, p) * calculDetMatriceCarre2(matriceTempo) * Math.pow(-1, valeurXY)
					: calculDetMatriceCarreSup2(matriceTempo) * matriceSi.getValueAt(0, p) * Math.pow(-1, valeurXY);
		}
		return determinant;
	}

	public double testOpti(Matrice matriceSi) {
		double compteurH = 0, compteurHMax = 0;
		double compteurV = 0, compteurVMax = 0;
		int x = 0, y = 0;

		for (int i = 0; i < matriceSi.getDimension(); i++) {
			compteurH = 0;
			compteurV = 0;
			for (int j = 0; j < matriceSi.getDimension(); j++) {
				if (matriceSi.getValueAt(i, j) == 0) {
					compteurH++;
				}
				if (matriceSi.getValueAt(j, i) == 0) {
					compteurV++;
				}
			}
			if (compteurH > compteurHMax) {
				compteurHMax = compteurH;
				x = i;
			}
			if (compteurV > compteurVMax) {
				compteurVMax = compteurV;
				y = i;
			}
		}

		if (compteurHMax < matriceSi.getDimension() - 1 && compteurVMax < matriceSi.getDimension() - 1) {
			return ((compteurHMax >= compteurVMax) ? combinaisonLineaire(matriceSi, x, true)
					: combinaisonLineaire(matriceSi, y, false));
		} else if (compteurHMax == 0 && compteurVMax == 0) {
			return calculDetMatriceLigne(matriceSi, 0);
		} else if (compteurHMax >= compteurVMax) {
			return calculDetMatriceLigne(matriceSi, x);
		} else {
			return calculDetMatriceColonne(matriceSi, y);
		}
	}

	public double combinaisonLineaire(Matrice matriceSi, int rang, boolean choixLigne) {
		double coef = 0;
		int fixe = -1;
		Matrice affichage = null;

		if (choixLigne) {
			for (int i = 0; i < matriceSi.getDimension(); i++) {
				if (matriceSi.getValueAt(rang, i) == 0) {
					continue;
				} else if (fixe == -1) {
					fixe = i;
				} else {
					coef = matriceSi.getValueAt(rang, i) / matriceSi.getValueAt(rang, fixe);
					affichage = ligneMiseAZero(matriceSi, fixe, i, coef);
				}

			}
		} else {
			for (int i = 0; i < matriceSi.getDimension(); i++) {
				if (matriceSi.getValueAt(i, rang) == 0) {
					continue;
				} else if (fixe == -1) {
					fixe = i;
				} else {
					coef = matriceSi.getValueAt(i, rang) / matriceSi.getValueAt(fixe, rang);
					affichage = colonneMiseAZero(matriceSi, fixe, i, coef);
				}
			}
		}
		affichage.afficherMatrice();
		return calculDeterminant(affichage);
	}

	public String comparaisonDet(Matrice matriceSi, int puissance) {
		String bool = (Math.pow(calculDeterminant(matriceSi),
				puissance) == calculDeterminant(matriceSi.getMatriceExposant(puissance))) ? "Vrai"
						: "Faux";

		return bool + "\ndet(matrice)^" + puissance + " = " + Math.pow(calculDeterminant(matriceSi), puissance)
				+ " \ndet(matrice^" + puissance + ") = "
				+ calculDeterminant(matriceSi.getMatriceExposant(puissance));
	}

	public double calculDetMatriceLigne(Matrice matriceSi, int rang) {
		if (matriceSi.getDimension() > 2) {
			Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
			int l = 0, c = 0;
			double determinant = 0.0;

			for (int p = 0; p < matriceSi.getDimension(); p++, l = 0, c = 0) {
				l = 0;
				c = 0;
				for (int i = 0; i < matriceSi.getDimension(); i++) {
					c = 0;
					for (int j = 0; j < matriceSi.getDimension(); j++) {

						if (i != rang && p != j) {
							matriceTempo.setValueAt(l, c, matriceSi.getValueAt(i, j));
							c++;
						}
					}
					if (i != rang) {
						l++;
					}
				}

				if (matriceTempo.getDimension() == 2) {
					if ((((p + 1) + rang + 1) % 2) == 0 && matriceSi.getValueAt(rang, p) != 0) {
						determinant += matriceSi.getValueAt(rang, p) * calculDetMatriceCarre2(matriceTempo);
					} else {
						determinant -= matriceSi.getValueAt(rang, p) * calculDetMatriceCarre2(matriceTempo);
					}
				} else {
					if ((((p + 1) + rang + 1) % 2) == 0 && matriceSi.getValueAt(rang, p) != 0) {
						determinant += calculDetMatriceLigne(matriceTempo, rang) * matriceSi.getValueAt(rang, p);
					} else {
						determinant -= calculDetMatriceLigne(matriceTempo, rang) * matriceSi.getValueAt(rang, p);
					}
				}
			}
			return determinant;
		}
		return 0;
	}

	public double calculDetMatriceColonne(Matrice matriceSi, int rang) {
		Matrice matriceTempo = new Matrice(new double[matriceSi.getDimension() - 1][matriceSi.getDimension() - 1]);
		int l = 0, c = 0;
		double determinant = 0;

		for (int p = 0; p < matriceSi.getDimension(); p++) {
			l = 0;
			c = 0;
			for (int i = 0; i < matriceSi.getDimension(); i++) {
				l = 0;
				for (int j = 0; j < matriceSi.getDimension(); j++) {

					if (i != rang && p != j) {
						matriceTempo.setValueAt(l, c, matriceSi.getValueAt(j, i));
						l++;
					}
				}
				if (i != rang) {
					c++;
				}
			}

			if (matriceTempo.getDimension() == 2) {
				if ((((p + 1) + rang + 1) % 2) == 0 && matriceSi.getValueAt(p, rang) != 0) {
					determinant += matriceSi.getValueAt(p, rang) * calculDetMatriceCarre2(matriceTempo);
				} else {
					determinant -= matriceSi.getValueAt(p, rang) * calculDetMatriceCarre2(matriceTempo);
				}
			} else {
				if ((((p + 1) + rang + 1) % 2) == 0 && matriceSi.getValueAt(p, rang) != 0) {
					determinant += calculDetMatriceLigne(matriceTempo, rang) * matriceSi.getValueAt(p, rang);
				} else {
					determinant -= calculDetMatriceLigne(matriceTempo, rang) * matriceSi.getValueAt(p, rang);
				}
			}
		}
		return determinant;
	}

	private Matrice ligneMiseAZero(Matrice matriceSi, int fixe, int indiceL, double coef) {
		for (int i = 0; i < matriceSi.getDimension(); i++) {
			double nouvelleVal = (matriceSi.getValueAt(i, indiceL) - (coef * matriceSi.getValueAt(i, fixe)));
			matriceSi.setValueAt(i, indiceL, nouvelleVal);
		}
		return matriceSi;
	}

	private Matrice colonneMiseAZero(Matrice matriceSi, int fixe, int indiceL, double coef) {
		for (int i = 0; i < matriceSi.getDimension(); i++) {
			double nouvelleVal = (matriceSi.getValueAt(indiceL, i) - (coef * matriceSi.getValueAt(fixe, i)));
			matriceSi.setValueAt(indiceL, i, nouvelleVal);
		}
		return matriceSi;
	}
}
