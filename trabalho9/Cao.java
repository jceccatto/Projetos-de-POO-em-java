package trabalho9;

public class Cao extends Mamifero{
	public String soar( ) {
		return "Som de cachorro";
	}
	
	public Cao(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "cachorro";
	}
}
