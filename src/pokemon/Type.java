package pokemon;

public enum Type {
	EAU("eau"),FEU("feu"),PLANTE("plante");
	
	private String type;
	
	private Type(String type) {
		this.type=type;
	}
	
	public String toStirng() {
		return this.type;
	}
	
	

}
