import java.util.Random;

public abstract class Pokemon {

	    // Attributs de la classe Pokemon0
	    private String nom;
	    private int niveau;
	    private int hp;
	    private int atk;
	    private Random random;
	    private String type;
	    
	    // Constructeur
	    public Pokemon(String nom,String type) {
	        this.nom = nom;
	        this.random = new Random();
	        
	        // Niveau aléatoire entre 1 et 10
	        this.niveau = this.random.nextInt(10) + 1;
	        
	        this.type=type;
	        
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
	    
	    // Méthode abstraite
	    public abstract void attaquer(Pokemon0 p);
	    
	    
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
	    
	    public abstract void subir(Pokemon p);
	}


