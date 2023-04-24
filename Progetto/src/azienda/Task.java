package azienda;

import java.sql.Date;

public class Task {
	private String ID;
	private String codice;
	private String descrizione;
	private boolean status;
	private Date deadline;
	private String CF_pm;
		
	public Task(String iD, String codice, String descrizione, boolean status, Date deadline, String cF) {
		super();
		ID = iD;
		this.codice = codice;
		this.descrizione = descrizione;
		this.status = status;
		this.deadline = deadline;
		CF_pm = cF;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getCF_pm() {
		return CF_pm;
	}
	public void setCF_pm(String cF) {
		CF_pm = cF;
	}

	@Override
	public String toString() {
		return "Task [ID=" + ID + ", codice=" + codice + ", descrizione=" + descrizione + ", status=" + status
				+ ", deadline=" + deadline + ", CF_pm=" + CF_pm + "]";
	}
	
}
