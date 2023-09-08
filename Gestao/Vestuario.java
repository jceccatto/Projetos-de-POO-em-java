package Gestao;

public class Vestuario extends Equipamento {
	private String tipoVestuario;
	
	public Vestuario (String nome, String codigo, String fornecedor, String tipoV)	{
		super (codigo, fornecedor, nome, "Vestuario");
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