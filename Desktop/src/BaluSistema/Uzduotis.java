package BaluSistema;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Uzduotis implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pavadinimas;
	private String salyga;
	private String vertinimoTvarka;
	private float maxBalai;
	private Date terminas;
	private boolean galimaIkelti;
	private String kursoKodas;

	
	public Uzduotis() {
		
	}
	
	public Uzduotis(String pavadinimas, String salyga, String vertinimoTvarka, float maxBalai, 
String terminas, String kursoKodas, boolean galimaIkelti) throws ParseException {
		this.pavadinimas = pavadinimas;
		this.salyga = salyga;
		this.vertinimoTvarka = vertinimoTvarka;
		this.maxBalai = maxBalai;
		DateFormat tmp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.terminas = tmp.parse(terminas);
		this.galimaIkelti = galimaIkelti;
		this.kursoKodas = kursoKodas;
	}

	public Date getTerminas() {
		return terminas;
	}

	public void setTerminas(Date terminas) {
		this.terminas = terminas;
	}


	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getSalyga() {
		return salyga;
	}

	public void setSalyga(String salyga) {
		this.salyga = salyga;
	}

	public String getVertinimoTvarka() {
		return vertinimoTvarka;
	}

	public void setVertinimoTvarka(String vertinimoTvarka) {
		this.vertinimoTvarka = vertinimoTvarka;
	}

	public float getmaxBalai() {
		return maxBalai;
	}

	public void setmaxBalai(float maxBalai) {
		this.maxBalai = maxBalai;
	}

	
	public boolean isGalimaIkelti() {
		return galimaIkelti;
	}

	public void setGalimaIkelti(boolean galimaIkelti) {
		this.galimaIkelti = galimaIkelti;
	}
	
	public float getMaxBalai() {
		return maxBalai;
	}

	public void setMaxBalai(int maxBalai) {
		this.maxBalai = maxBalai;
	}

	public String getKursoKodas() {
		return kursoKodas;
	}

	public void setKursoKodas(String kursoKodas) {
		this.kursoKodas = kursoKodas;
	}

//	public ArrayList<IkeltasDarbas> getIkeltiDarbai(){
//		return ikeltiDarbai;
//	}
//	
//	public void pridetiDarba(IkeltasDarbas d) {
//		ikeltiDarbai.add(d);
//	}
//	public IkeltasDarbas getDarbasById(int id) {
//		for(IkeltasDarbas o : ikeltiDarbai) {
//			if(o.getStudentas().getId() == id) {
//				return o;
//			}
//		}
//		return null;
//	}

	@Override
	public String toString() {
		return pavadinimas + ", salyga: " + salyga + "\n" + "vertinimoTvarka: " + vertinimoTvarka
				+ "\n" + "maxBalai: " + maxBalai + "\n" + "terminas: " + terminas + "\n" + "galimaIkelti: " + galimaIkelti
				+ "\n" + "ikeltiDarbai: ";
	}
	
	
	
	


}

