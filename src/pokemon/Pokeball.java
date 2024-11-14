package pokemon;
import java.util.Random;

public class Pokeball {
	
	private Dresseur dresseur;
	
	public Pokeball(Dresseur dresseur) {
		this.dresseur=dresseur;
	}
	
	public Pokemon capturerPokemon(int i) {
		Pokemon p = null;
		Random random = new Random();
		Type[] types = Type.values();
		
		Type type = types[random.nextInt(types.length)];
		
		if(type == Type.EAU) {
			p = new PokemonEau("Pokemon"+i+"");
		}else if (type == Type.FEU) {
			 p = new PokemonFeu("Pokemon"+i+"");
		}else {
			p = new PokemonPlante("Pokemon"+i+"");
		}
		return p ;
		
	}

}
