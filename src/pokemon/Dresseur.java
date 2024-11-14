package pokemon;

import java.util.ArrayList;

public class Dresseur {
	
	private String nom;
	private int argent;
	private SacADos sacADos;
	
	
	
	
	public Dresseur(String nom) {
		this.nom=nom;
		this.argent=0;
		this.sacADos= new SacADos(this);
	}
	
	
	public void capturerPokemon() {
		this.sacADos.capturerPokemon();
	}
	
	public int getnbPokemon() {
		return this.sacADos.getnbPokemon();
		}
	
	public boolean peutCombattre() {
	    // Vérifie si le joueur a de l'argent
		return this.argent >= 0 && this.sacADos.peutCombattre();
	}
	
	
	
	public Pokemon prochainPokemon() {
		for(Pokemon p : this.sacADos.getSacADos()) {
			if (!p.isKO()) {
	            return p;
	        }
		}
		
			return null;
	}
	
	
	// Méthode qui permet de voler 10 Pokédollars à un autre dresseur
    public void prendreArgent(Dresseur adversaire) {
        if (adversaire.argent >= 10) {
            adversaire.argent -= 10;
            this.argent += 10;
            System.out.println(this.nom + " a volé 10 Pokédollars à " + adversaire.nom + " !");
        } else {
            System.out.println(adversaire.nom + " n'a pas assez de Pokédollars pour être volé.");
        }
    }
    
    public void combattre(Dresseur d) {
		System.out.println(this.nom + " initie un combat contre " + d.nom + " !");

        // Tant que les deux dresseurs ont des Pokémon en état de combattre
        while (this.peutCombattre() && d.peutCombattre()) {
            // Récupérer les premiers Pokémon non KO de chaque dresseur
            Pokemon monPokemon = prochainPokemon();
            Pokemon sonPokemon = d.prochainPokemon();

            System.out.println(this.nom + " envoie " + monPokemon.getNom() + " !");
            System.out.println(d.nom + " envoie " + sonPokemon.getNom() + " !");

            // Le dresseur qui initie le combat a l'initiative
            boolean tourDeMoi = true;

            // Combat entre les deux Pokémon jusqu'à ce que l'un soit KO
            while (!monPokemon.isKO() && !sonPokemon.isKO()) {
                if (tourDeMoi) {
                    monPokemon.attaquer(sonPokemon);
                } else {
                    sonPokemon.attaquer(monPokemon);
                }
                // Changer de tour
                tourDeMoi = !tourDeMoi;
            }

            // Annonce du Pokémon KO
            if (monPokemon.isKO()) {
                System.out.println(monPokemon.getNom() + " de " + this.nom + " est KO !");
            }
            if (sonPokemon.isKO()) {
                System.out.println(sonPokemon.getNom() + " de " + d.nom + " est KO !");
            }
        }

        // Déterminer le gagnant et voler de l'argent
        if (this.peutCombattre()) {
            System.out.println(this.nom + " a gagné le combat !");
            this.prendreArgent(d);
        } else if (d.peutCombattre()) {
            System.out.println(d.nom + " a gagné le combat !");
            d.prendreArgent(this);
        } else {
            System.out.println("Le combat est nul, aucun dresseur n'a de Pokémon en état de combattre.");
        }
    }
    
    
    
    public void pokeCenter() {
        this.sacADos.pokeCenter();
    }

    // Redéfinition de la méthode toString pour afficher les informations du dresseur
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dresseur : ").append(nom).append("\n");
        sb.append("Argent : ").append(argent).append(" Pokédollars $\n");
        sb.append("Pokémons : ").append(this.getnbPokemon());
        
        return sb.toString();
    }
    
    public void log(String msg) {
        System.out.println("[Dresseur " + this.nom + "] : " + msg);
    }
    
    

}
