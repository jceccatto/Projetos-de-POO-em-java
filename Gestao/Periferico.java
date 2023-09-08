package Gestao;

public class Periferico extends Equipamento{
	private String tipoPeriferico;
	
	public Periferico(String nome, String codigo, String marca, String tipoP) {
		super(codigo,marca,nome,"Periferico");
		this.tipoPeriferico = tipoP;
	}
	
	public String getTipoPeriferico() {
		return tipoPeriferico;
	}
	
	public void setTipoP(String tipoPeriferico) {
		this.tipoPeriferico = tipoPeriferico;
	}
	
	public String toString() {
		return super.toString() +
				"Tipo Perifirico: " + this.getTipoPeriferico();
	}

}
