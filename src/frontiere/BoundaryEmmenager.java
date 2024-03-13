package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force = Clavier
							.entrerEntier("Bienvenue Villageois " + nomVisiteur 
									+ "\nQuelle est votre force ?\n");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide = Clavier.entrerEntier("Bienvenue druide " + nomVisiteur 
				+ "\nQuelle est votre force ?\n");
		int effetPotionMax = 0;
		int effetPotionMin = 1;
		do {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion "
					+ "la lus faible que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la"
					+ " plus forte que vous produisez ?\n");

			if (effetPotionMax < effetPotionMin) {
				System.out.println("attention Druide, vous etes trompe entre le"
						+ " minimum et le maximum\n");
			}
		} while (effetPotionMax < effetPotionMin);

		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, 
				effetPotionMax);
	}
}
