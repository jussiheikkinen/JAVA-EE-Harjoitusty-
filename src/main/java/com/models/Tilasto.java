package com.models;

import java.io.Serializable;

public class Tilasto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer kolmoset;
	private Integer kakkoset;
	private Integer voitot;
	private Integer startit;
	private String sukupuoli;
	
	public Tilasto(){};

	public Integer getKakkoset() {
		return kakkoset;
	}
	public void setKakkoset(Integer kakkoset) {
		this.kakkoset = kakkoset;
	}
	public Integer getStartit() {
		return startit;
	}
	public void setStartit(Integer startit) {
		this.startit = startit;
	}
	public Integer getVoitot() {
		return voitot;
	}
	public void setVoitot(Integer voitot) {
		this.voitot = voitot;
	}
	public String getSukupuoli() {
		return sukupuoli;
	}
	public void setSukupuoli(String sukupuoli) {
		this.sukupuoli = sukupuoli;
	}
	public Integer getKolmoset() {
		return kolmoset;
	}
	public void setKolmoset(Integer kolmoset) {
		this.kolmoset = kolmoset;
	}
	
}
