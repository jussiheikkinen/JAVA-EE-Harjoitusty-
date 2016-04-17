package com.models;

import java.io.Serializable;

public class Hevonen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String omistaja;
	private String valmentaja;	
	private Integer ika;
	private Integer id;
	private String sukupuoli;
	private String laji;
	private String nimi;
	
	public Hevonen(){}	
		
	public String getValmentaja() {
		return valmentaja;
	}
	public void setValmentaja(String valmentaja) {
		this.valmentaja = valmentaja;
	}
	public Integer getIka() {
		return ika;
	}
	public void setIka(Integer ika) {
		this.ika = ika;
	}
	public String getLaji() {
		return laji;
	}
	public void setLaji(String laji) {
		this.laji = laji;
	}
	public String getOmistaja() {
		return omistaja;
	}
	public void setOmistaja(String omistaja) {
		this.omistaja = omistaja;
	}
	public String getSukupuoli() {
		return sukupuoli;
	}
	public void setSukupuoli(String sukupuoli) {
		this.sukupuoli = sukupuoli;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

}
