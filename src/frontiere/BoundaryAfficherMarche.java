package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marche est vide, reveez plus tard.\n");
		} else {
			System.out.println(nomAcheteur + ",vous trouver au marche :\n ");
			int i = 0;
			while (infosMarche.length > i+1) {
				System.out.println(
						"-" + infosMarche[i] + " qui vend " + infosMarche[i + 1] + " " + infosMarche[i + 2]);
				i += 3;
			}
		}
	}
}
