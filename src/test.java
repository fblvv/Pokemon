
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        System.out.println("\nTEST POKEMON0\n");

		        // Création de deux objets Pokémon
		        Pokemon0 p1 = new Pokemon0("Rhinolove");
		        Pokemon0 p2 = new Pokemon0("Chovsourir");

		        // Affichage des informations initiales des Pokémon
		        p1.log(p1.toString());
		        p2.log(p2.toString());

		        // p1 attaque p2
		        p1.attaquer(p2);

		        // Affichage de l'état de p2 après l'attaque
		        p2.log(p2.toString());
		    }



	}

