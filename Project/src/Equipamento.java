import java.io.Serializable;
public class Equipamento implements Serializable {
	private String codigo;


	public Equipamento(String codigo) {
		this.codigo = codigo;

	}

	public Equipamento () {	}


	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String toString() {
		String retorno;
		retorno = "--------------------------" +
				"Codigo: " + this.getCodigo () +
				"--------------------------\n";


		return retorno;
	}
}