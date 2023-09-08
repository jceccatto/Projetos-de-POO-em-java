public class Hardware extends Equipamento{
	private String tipoHardware;

	public Hardware(String codigo, String tipoH) {
		super(codigo);
		this.tipoHardware = tipoH;
	}

	public String getTipoHardware() {
		return tipoHardware;
	}

	public void setTipoHardware(String tipoHardware) {
		this.tipoHardware = tipoHardware;
	}

	public String toString() {
		return super.toString() + "Tipo Hardware: " + this.getTipoHardware();
	}

}