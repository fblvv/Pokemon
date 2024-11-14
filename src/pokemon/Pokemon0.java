package pokemon;
import java.util.Random;

public class Pokemon0 {
    // Attributs de la classe Pokemon0
    private String nom;
    private int niveau;
    private int hp;
    private int atk;
    
    // Constructeur
    public Pokemon0(String nom) {
        this.nom = nom;
        
        // Niveau aléatoire entre 1 et 10
        this.niveau = new Random().nextInt(10) + 1;
        
        // Calcul des points de vie et de l'attaque de base
        this.hp = 2 * this.niveau;
        this.atk = (this.niveau / 2) + 1;
    }
    
    // Getters pour les attributs
    public String getNom() {
        return nom;
    }
    
    public int getNiveau() {
        return niveau;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getAtk() {
        return atk;
    }
    
    // Méthode pour vérifier si le Pokémon est KO
    public boolean isKO() {
        return this.hp == 0;
    }
    
    // Méthode pour soigner le Pokémon (restaure les HP de base)
    public void soigner() {
        this.hp = 2 * this.niveau;
        log("soigné : HP restauré à " + this.hp);
    }
    
    // Méthode pour attaquer un autre Pokémon
    public void attaquer(Pokemon0 p) {
        if (this.isKO()) {
            log("ne peut pas attaquer car il est KO.");
            return;
        }
        
        log("attaque " + p.getNom() + " avec " + this.atk + " points de dégât.");
        p.recevoirDegats(this.atk);
    }
    
    // Méthode pour recevoir des dégâts
    private void recevoirDegats(int points) {
        this.hp -= points;
        if (this.hp < 0) {
            this.hp = 0;
        }
        log("reçoit " + points + " points de dégât. HP restant : " + this.hp);
    }
    
    // Redéfinition de toString() pour afficher les informations du Pokémon
    @Override
    public String toString() {
        return "Je m'appelle " + this.nom + " !\n" +
               "    je suis de niveau " + this.niveau + "\n" +
               "    j'ai " + this.hp + " points de vie\n" +
               "    mon attaque de base est de " + this.atk;
    }
    
    // Méthode de log pour afficher des messages de log
    public void log(String msg) {
        System.out.println("[Pokemon " + this.nom + "] : " + msg);
    }
}
