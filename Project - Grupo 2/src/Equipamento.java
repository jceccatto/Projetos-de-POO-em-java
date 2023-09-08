import java.io.Serializable;
public class Equipamento implements Serializable {
	private String codigo;
	private String nome;
	private String marca;
	private String tipo;


	public Equipamento(String nome, String codigo, String marca,String tipo ) {
		this.nome = nome;
		this.codigo = codigo;
		this.marca = marca;
		this.tipo = tipo;
	}

	public Equipamento () {	}


	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo() {
		this.tipo = tipo;
	}

	public String toString() {
		String retorno;
		retorno = "--------------------------" +
				"Marca: " + this.getMarca () +
				"--------------------------\n" +
				"Nome: " + this.getNome () + "\n" +
				"Codigo: " + this.getCodigo () + "\n" +
				"Tipo:  " + this.getTipo () + "\n";
		return retorno;
	}
}