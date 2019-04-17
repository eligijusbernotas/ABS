package BaluSistema;

import java.io.Serializable;
import java.util.ArrayList;

public class Destytojas implements Comparable<Destytojas>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String vardas, pavarde;
	private ArrayList<Kursas> kursai = new ArrayList<Kursas>();
	
	public Destytojas(int id, String vardas, String pavarde) {
		this.id = id;
		this.vardas = vardas;
		this.pavarde = pavarde;
	}
	public Destytojas() {
		
	}
	
	public String toString() {
		
		return id + ", " + vardas + " " + pavarde; 
 	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	
	public Kursas pridetiKursa(String kodas, String pav){
		Kursas naujas = new Kursas(kodas, pav, this.id);
		kursai.add(naujas);
		return naujas;
	}
	public ArrayList<Kursas> getKursai() {
		return kursai;
	}

	@Override
	public int compareTo(Destytojas arg0) {
		// TODO Auto-generated method stub
		return arg0.vardas.compareTo(this.vardas);
	}

	public void priskirtiKursa(Kursas kursas) {
		kursai.add(kursas);
		
	}
	

	
}
