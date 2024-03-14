package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui !\n");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = donneesEtal[0].equals("true");
			if (etalOccupe) {
				System.out.println(
						"Vous avez vendu " + donneesEtal[2] + " sur " + donneesEtal[3] + " " + donneesEtal[4] + ".");
				System.out.println("\nEn revoir" + nomVendeur + ", passez une bonne journee\n");
			}
		}

	}

}
