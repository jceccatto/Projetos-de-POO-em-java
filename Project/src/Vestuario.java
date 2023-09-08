public class Vestuario extends Equipamento {
	private String tipoVestuario;

	public Vestuario (String codigo, String tipoV)	{
		super (codigo);
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