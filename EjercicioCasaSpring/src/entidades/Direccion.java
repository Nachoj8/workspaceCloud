package entidades;

public class Direccion {
	private String nombreVia;
	private String tipoVia;
	private String cp;
	
	public Direccion() {
		super();
	}

	public Direccion(String nombreVia, String tipoVia, String cp) {
		super();
		this.nombreVia = nombreVia;
		this.tipoVia = tipoVia;
		this.cp = cp;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion: " + nombreVia + " , " + tipoVia + ", CP: " + cp + "\n";
	}
	
	
}
