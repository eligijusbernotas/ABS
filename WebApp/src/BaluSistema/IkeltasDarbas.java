package BaluSistema;

import java.io.Serializable;
import java.util.Date;

public class IkeltasDarbas implements Serializable{

	private static final long serialVersionUID = 1L;
	private String darboID;
	private String atsakymas;
	private float ivertinimas;
	private Date ikelimoData;
	private Date ivertinimoData;
	private String komentaras;
	private int studentoID;
	private String uzduotiesPav;
	
	public IkeltasDarbas(String atsakymas, int studentoID, String uzduotiesPav) {
		this.atsakymas = atsakymas;
		this.ivertinimas = 0;
		this.komentaras = "";
		this.studentoID = studentoID;
		this.uzduotiesPav = uzduotiesPav;
	}
	public IkeltasDarbas() {
		
	}
	public String getDarboID() {
		return darboID;
	}
	public void setDarboID(String darboID) {
		this.darboID = darboID;
	}
	public String getAtsakymas() {
		return atsakymas;
	}
	public void setAtsakymas(String atsakymas) {
		this.atsakymas = atsakymas;
	}
	public float getIvertinimas() {
		return ivertinimas;
	}
	public void setIvertinimas(float ivertinimas) {
		this.ivertinimas = ivertinimas;
	}
	public Date getIkelimoData() {
		return ikelimoData;
	}
	public void setIkelimoData(Date ikelimoData) {
		this.ikelimoData = ikelimoData;
	}
	public Date getIvertinimoData() {
		return ivertinimoData;
	}
	public void setIvertinimoData(Date ivertinimoData) {
		this.ivertinimoData = ivertinimoData;
	}
	public String getKomentaras() {
		return komentaras;
	}
	public void setKomentaras(String komentaras) {
		this.komentaras = komentaras;
	}
	public int getStudentoID() {
		return studentoID;
	}
	public void setStudentoID(int studentoID) {
		this.studentoID = studentoID;
	}
	public String getUzduotiesPav() {
		return uzduotiesPav;
	}
	public void setUzduotiesPav(String uzduotiesPav) {
		this.uzduotiesPav = uzduotiesPav;
	}
	@Override
	public String toString() {
		return "Studento kodas: " + studentoID +" Atsakymo vieta: " + atsakymas + ", ivertinimas: " + ivertinimas + ", ikelimo data: " + ikelimoData
				+ ", ivertinimo data: " + ivertinimoData + ", komentaras:\n" + komentaras + "\n";
	}
}
