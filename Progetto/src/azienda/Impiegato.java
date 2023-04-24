package azienda;

/**
 * The class Impiegato contains the main information about an employee.
 * @author Martina Urizio
 *
 */

public class Impiegato {
	protected String nome;
	protected String cognome;
	
	public Impiegato() {
		super();
		this.nome = null;
		this.cognome = null;
	}
	
	public Impiegato(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
