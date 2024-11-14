package pokemon;

import java.util.ArrayList;

public class SacADos {
	
	private ArrayList<Pokemon>sacADos;
	private static final int MAX=3;
	private Pokeball pokeball;
	private Dresseur dresseur;
	
	public SacADos(Dresseur dresseur) {
		this.sacADos=new ArrayList<>();
		this.pokeball=new Pokeball(dresseur);
		this.dresseur=dresseur;
	}
	
	public int getnbPokemon() {
		return this.sacADos.size();
		}
	
	public void capturerPokemon() {
		if(this.sacADos.size()< MAX) {
			this.sacADos.add(this.pokeball.capturerPokemon(this.sacADos.size()));
		}else {
		this.dresseur.log("mon sac à dos est plein !");
		}
	}
	
	public boolean peutCombattre() {
	    
	    // Vérifie si au moins un Pokémon dans le sac à dos n'est pas KO
	    

	    // Si tous les Pokémon sont KO, retourne false
	    return false;
	}
	
	public void combattre(Dresseur d) {
		for (Pokemon p : this.sacADos) {
	        if (!p.isKO()) {
	        	p
	        }
			
		}
	}
	public void pokeCenter() {
        for (Pokemon p : sacADos) {
            p.soigner();
        }
        System.out.println( "tous les Pokémons sont soignés !");
    }

	public ArrayList<Pokemon> getSacADos() {
		return sacADos;
	}

}
