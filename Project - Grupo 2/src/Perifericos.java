
public class Perifericos extends Equipamento{
	private String tipoPerifericos;
	
	public Perifericos(String codigo, String nome, String marca, String tipoP) {
		super(nome,codigo,marca,"Perifericos");
		this.tipoPerifericos = tipoP;
	}
	
	public String getTipoPerifericos() {
		return this.tipoPerifericos;
	}
	
	public void setTipoPerifericos(String tipoPerifericos) {
		this.tipoPerifericos = tipoPerifericos;
	}
	
	public String toString() {
		return super.toString() + "Tipo Periferico: " + this.getTipoPerifericos ();
	}

}
