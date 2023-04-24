package azienda;

public class Progetto {
	private String codice;
	private String CF;
	
	public Progetto(String codice, String cF) {
		super();
		this.codice = codice;
		CF = cF;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	
	@Override
	public String toString() {
		return "Progetto [codice=" + codice + ", CF=" + CF + "]";
	}
}
