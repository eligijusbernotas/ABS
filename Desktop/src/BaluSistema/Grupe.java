package BaluSistema;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Grupe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kodas;
	private int stojimoMetai;
	private String specPavadinimas;
	private Set<Kursas> kursai;
	
	public Set<Kursas> getKursai() {
		return kursai;
	}

	public void setKursai(Set<Kursas> kursai) {
		this.kursai = kursai;
	}



	private static SessionFactory sessionFactory = null;
	
	public Grupe() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	
	public Grupe(int stojimoMetai, String kodas, String specPavadinimas) {
		this.kodas = kodas;
		this.stojimoMetai = stojimoMetai;
		this.specPavadinimas = specPavadinimas;
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public String getKodas() {
		return kodas;
	}

	public void setKodas(String kodas) {
		this.kodas = kodas;
	}

	public int getStojimoMetai() {
		return stojimoMetai;
	}

	public void setStojimoMetai(int stojimoMetai) {
		this.stojimoMetai = stojimoMetai;
	}

	public String getKursoPavadinimas() {
		return specPavadinimas;
	}

	public void setKursoPavadinimas(String kursoPavadinimas) {
		this.specPavadinimas = kursoPavadinimas;
	}

	public String getSpecPavadinimas() {
		return specPavadinimas;
	}

	public void setSpecPavadinimas(String specPavadinimas) {
		this.specPavadinimas = specPavadinimas;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		Grupe.sessionFactory = sessionFactory;
	}


	public void pridetiStudenta(int id, String vardas, String pavarde) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Studentas naujas = new Studentas(id, vardas, pavarde, kodas);
			s.save(naujas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
	}
	
	public List<Studentas> getStudentai(){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Studentas> list = s.createQuery("FROM Studentas").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	

	@Override
	public String toString() {
		return kodas + ", stojimo metai: " + stojimoMetai + ", kurso pavadinimas: " + specPavadinimas +"\n";
	}

}
