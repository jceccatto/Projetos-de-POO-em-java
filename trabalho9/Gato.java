package trabalho9;

public class Gato extends Mamifero {
	public String soar() {
		return "Som de gato"; 
	}
	
	public Gato(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Gato";
	}

}
