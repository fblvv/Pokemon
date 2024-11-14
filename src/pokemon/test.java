package pokemon;

public class test {

    // Test pour la classe de base Pokemon0
    private static void testPokemon0() {
        Pokemon0 p1 = new Pokemon0("Rhinolove");
        Pokemon0 p2 = new Pokemon0("Chovsourir");

        p1.log(p1.toString());
        p2.log(p2.toString());

        p1.attaquer(p2);
        p2.log(p2.toString());
    }

    // Test pour les types de Pokémon (Eau et Feu)
    private static void testPokemonTypes() {
        PokemonEau eau = new PokemonEau("PokéEau");
        PokemonFeu feu = new PokemonFeu("PokéFeu");

        eau.log(eau.toString());
        feu.log(feu.toString());

        eau.attaquer(feu);  // Attaque de type Eau contre Feu (devrait être super efficace)
        feu.attaquer(eau);  // Attaque de type Feu contre Eau (attaque normale)

        eau.log(eau.toString());
        feu.log(feu.toString());
    }

    // Méthode principale pour exécuter les tests
    public static void main(String[] args) {
        System.out.println("\nTEST POKEMON0 \n");
        testPokemon0();

        System.out.println("\nTEST POKEMON TYPES \n");
        testPokemonTypes();
    }
}
