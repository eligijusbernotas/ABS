package BaluSistema;

import java.io.Serializable;

public class Kursas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kodas;
	private String pavadinimas;
	private int destytojoID;
	
	public Kursas(String kodas, String pavadinimas, int destID) {
		this.kodas = kodas;
		this.pavadinimas = pavadinimas;
		this.destytojoID = destID;
	}
	
	public Kursas() {
		
	}


	public int getDestytojoID() {
		return destytojoID;
	}

	public void setDestytojoID(int destytojoID) {
		this.destytojoID = destytojoID;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	
	public String getKodas() {
		return kodas;
	}


	public void setKodas(String kodas) {
		this.kodas = kodas;
	}
	
	public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Kursas obj2 = (Kursas)obj;
	      if((this.kodas == obj2.getKodas()) && (this.pavadinimas.equals(obj2.getPavadinimas()))) {
	         return true;
	      }
	      return false;
	   }
	   
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( kodas + pavadinimas ).hashCode();
	      return tmp;
	   }


//	public ArrayList<Destytojas> getDestytojai() {
//		return destytojai;
//	}
//
//
//	public void setDestytojai(ArrayList<Destytojas> destytojai) {
//		this.destytojai = destytojai;
//	}
//
//
//	public ArrayList<Grupe> getGrupes() {
//		return grupes;
//	}
//
//
//	public void setGrupes(ArrayList<Grupe> grupes) {
//		this.grupes = grupes;
//	}
//
//
//	public void setUzduotys(ArrayList<Uzduotis> uzduotys) {
//		this.uzduotys = uzduotys;
//	}
//
//
//	public void pridetiGrupe(Grupe g) {
//		grupes.add(g);
//		g.pridetiKursa(this);
//	}
//	
//	public void pasalintiGrupe(String kodas) {
//		grupes.remove(getGrupeById(kodas));
//	}
//	
//	public void pridetiDestytoja(Destytojas d) {
//		destytojai.add(d);
//		d.priskirtiKursa(this);
//	}
//	public void pasalintiDestytoja(int kodas) {
//		destytojai.remove(getDestytojasById(kodas));
//	}
//	
//	public void pridetiUzduoti(String pav, String salyga, String vertinimoTvarka, int maxBalai, String terminas) {
//		Uzduotis nauja = new Uzduotis(pav, salyga, vertinimoTvarka, maxBalai, terminas);
//		uzduotys.add(nauja);
//	}
//	
//	public ArrayList<Uzduotis> getUzduotys() {
//		return uzduotys;
//	}
//	
//	public Uzduotis getUzduotisByPav(String pav) {
//		for(Uzduotis i : uzduotys) {
//			if(i.getPavadinimas().equals(pav)) {
//				return i;
//			}
//		}
//		return null;
//	}
	
//	public void uzdaarytiAtsIkelima(String pav) {
//		getUzduotisByPav(pav).setGalimaIkelti(false);
//	}
//	
//	public Grupe getGrupeById(String kodas) {
//		for(Grupe i : grupes) {
//			if(i.getKodas().equals(kodas)) {
//				return i;
//			}
//		}
//		return null;
//	}
//	
//	public Destytojas getDestytojasById(int kodas) {
//		for(Destytojas i : destytojai) {
//			if(i.getId() == kodas) {
//				return i;
//			}
//		}
//		return null;
//	}
//

	@Override
	public String toString() {
		return pavadinimas;
	}
	

	

}
