package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean isHabitant = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!isHabitant) {
			System.out.println("Je suis desole " + nomAcheteur + " mais il faut etre"
					+ " un habitant de notre village pour commancer ici.\n");
		} else {
			String produitSouhaitee = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			Gaulois[] vendeursDuProduit = controlAcheterProduit.trouverLesVendeursQuiVendsProduit(produitSouhaitee);
			if (vendeursDuProduit == null) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
			} else {
				System.out.println("Chez quel commercant voullez vous " + "acheter des " + produitSouhaitee + "?\n");
				for (int i = 0; i < vendeursDuProduit.length; i++) {
					System.out.println(i + 1 + " - " + vendeursDuProduit[i].getNom() + "\n");
				}
			}
			int numVendeur = Clavier.entrerEntier("");
			Gaulois Vendeur = vendeursDuProduit[numVendeur - 1];
			effectuerLachatDuProduit(Vendeur.getNom(), produitSouhaitee, nomAcheteur);

		}
	}

	private void effectuerLachatDuProduit(String nomVendeur, String produitSouhaitee, String nomAcheteur) {
		System.out.println(nomAcheteur + "se d�place jusqu'� l'�tal du vendeur" + nomVendeur + ".\n");
		int nbProduitAchete = Clavier
				.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produitSouhaitee + " voulez-vous acheter\n");
		int quantiteRest = controlAcheterProduit.QuantiteRestante(nomVendeur, nbProduitAchete);
		if (quantiteRest == 0) {
			System.out.println(nomAcheteur + " veut acheter " + nbProduitAchete + " " + produitSouhaitee
					+ ", malheureusement il n'y en a plus !\n");
		} else if (quantiteRest < nbProduitAchete) {
			controlAcheterProduit.effectuerLachat(nomVendeur, quantiteRest);
			System.out.println(nomAcheteur + " veut acheter " + nbProduitAchete + " " + produitSouhaitee
					+ " malheureusement " + nomVendeur + " n'en a plus que " + quantiteRest + "\n" + nomAcheteur
					+ " ach�te tout le stock de " + nomVendeur + ".\n");
		} else {
			controlAcheterProduit.effectuerLachat(nomVendeur, nbProduitAchete);
			System.out.println(
					nomAcheteur + " ach�te " + nbProduitAchete + " " + produitSouhaitee + " � " + nomVendeur + ".\n");
		}
	}

}
