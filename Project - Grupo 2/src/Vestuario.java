public class Vestuario extends Equipamento {
	private String tipoVestuario;

	public Vestuario (String nome, String codigo, String marca, String tipoV)	{
		super (nome, codigo, marca, "Vestuario");
		this.tipoVestuario = tipoV;
	}

	public String getTipoVestuario() {
		return this.tipoVestuario;
	}

	public void setTipoVestuario(String tipoVestuario) {
		this.tipoVestuario = tipoVestuario;
	}

	public String toString (){
		return super.toString() + "Tipo Vestuario: " + this.getTipoVestuario();
	}

}