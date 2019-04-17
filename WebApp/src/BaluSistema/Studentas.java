package BaluSistema;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Studentas implements Comparable<Studentas>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String vardas;
	private String pavarde;
	private String grupesKodas;
	private ArrayList<IkeltasDarbas> ikeltiDarbai = new ArrayList<IkeltasDarbas>();
	
	public Studentas() {
		
	}
	
	public Studentas(int id, String vardas, String pavarde, String grupesKodas) {
		this.id = id;
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.grupesKodas = grupesKodas;
	}
	public String getVardas() {
		return vardas;
	}
	public String getPavarde() {
		return pavarde;
	}
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
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
	
//	public void pridetiDarba(String atsLoc, Uzduotis uzd) throws IOException {
//		if(uzd.isGalimaIkelti()) {
//		Path loc = Paths.get(atsLoc);
//		String dst = new String(System.getProperty("user.dir") + File.separator + this.getId());
//		new File(dst).mkdirs();
//		File tmp = new File(dst + File.separator + loc.getFileName().toString());
//		IkeltasDarbas d = new IkeltasDarbas(Files.copy(loc, tmp.toPath(), StandardCopyOption.REPLACE_EXISTING), LocalDateTime.now(), this, uzd);
//		ikeltiDarbai.add(d);
//		uzd.pridetiDarba(d);
//		} else System.out.println("Uzduoties atsakymo pateikimas nebegalimas\n");
//	}
	
//	public IkeltasDarbas getDarbasByID(String id) {
//		for(IkeltasDarbas o : ikeltiDarbai) {
//			if(o.getUzduotis().getPavadinimas().equals(pav)) {
//				return o;
//			}
//		}
//		return null;
//	}
	
	@Override
	public String toString() {
		return id + ", " + vardas + " " + pavarde;
	}
	public int compareTo(Studentas arg0) {
		// TODO Auto-generated method stub
		return Integer.compare(this.id, arg0.id);
	}
	public String getGrupesKodas() {
		return grupesKodas;
	}
	public void setGrupesKodas(String grupesKodas) {
		this.grupesKodas = grupesKodas;
	}
}
