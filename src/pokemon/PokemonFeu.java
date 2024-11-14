package pokemon;

public class PokemonFeu extends Pokemon{
	
	public PokemonFeu(String nom){
		super(nom,Type.FEU);
		
	}


	@Override
    public void attaquer(Pokemon p) {
        if (this.isKO()) {
            log("ne peut pas attaquer car il est KO.");
            return;
        }

        int degats = this.getAtk();

        // Appliquer les règles d'efficacité
        if (p.getType() == Type.PLANTE) {
            degats *= 2;
            log("est super efficace contre " + p.getNom() + " !");
        } else if (p.getType() == Type.EAU || p.getType() == Type.FEU) {
            degats /= 2;
            log("est peu efficace contre " + p.getNom() + ".");
        }

        // Attaquer le Pokémon cible
        p.subir(this);
    }

	@Override
	public void subir(Pokemon p) {
		int degats = p.getAtk();

        // Appliquer les règles d'efficacité
        if (p.getType() == Type.EAU) {
            this.hp -= degats * 2;
            
        } else if (p.getType() == Type.PLANTE || p.getType() == Type.FEU) {
        	this.hp -= degats / 2;
        }
		
	}

}
