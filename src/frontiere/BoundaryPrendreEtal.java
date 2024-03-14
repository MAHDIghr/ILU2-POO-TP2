package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desolée " + nomVendeur + " mais il faut"
					+ "etre un habitant de notre village pour commancer ici\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder" 
					+ "si je peux vous trouver un etal.\n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desolée " + nomVendeur + "je n'ai plus d'etal qui ne"
						+ "soit pas deja occupé\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait, il me reste un etal pour vous !\n"
				+ "Il me faudrait quelques renseignements :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur +" s'est installé à l'étal n°"
								+ numEtal);
		}
	}
}
