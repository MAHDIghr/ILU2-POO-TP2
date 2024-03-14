package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public Gaulois[] trouverLesVendeursQuiVendsProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int QuantiteRestante(String nomVendeur, int nbProduit) {
		Etal etal =  controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}
	
	public void effectuerLachat(String nomVendeur,  int quantiteProduit) {
		Etal etal =  controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		etal.acheterProduit(quantiteProduit);
	}
}
