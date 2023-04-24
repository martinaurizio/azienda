package azienda;

import java.sql.Date;

public class Pm extends Impiegato {
	private int matricola;
	private Date dataAssunzione;
	private String CF;
	private String CFAgente;	
	
	public Pm() {
		super();
		this.matricola = 0;
		this.dataAssunzione = null;
		this.CF = null;
		this.CFAgente = null;
	}

	public Pm(String nome, String cognome, int matricola, Date dataAssunzione, String cF,
			String cFAgente) {
		super(nome, cognome);
		this.matricola = matricola;
		this.dataAssunzione = dataAssunzione;
		CF = cF;
		CFAgente = cFAgente;
	}
	
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public String getCFAgente() {
		return CFAgente;
	}
	public void setCFAgente(String cFAgente) {
		CFAgente = cFAgente;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nomeNew) {
		nome = nomeNew;
	}
	public String getCognome() {
		return nome;
	}
	public void setCognome(String cognomeNew) {
		cognome = cognomeNew;
	}

	@Override
	public String toString() {
		return "Pm [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", dataAssunzione=" + dataAssunzione + ", CF=" + CF + ", CFAgente="
				+ CFAgente + "]";
	}	
}
