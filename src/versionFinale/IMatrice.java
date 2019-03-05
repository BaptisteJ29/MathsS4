package versionFinale;

public interface IMatrice {

	double getValueAt(int x, int y);
	void setValueAt(int x, int y, double valeur);
	double[][] getMatrice();
	int getDimension();
}
