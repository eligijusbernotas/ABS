package BaluSistema;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class BaluSistema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SessionFactory sessionFactory = null;

	public BaluSistema() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void pridetiDest(int id,String vardas, String pavarde) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Destytojas naujas = new Destytojas(id, vardas, pavarde);
			s.save(naujas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		
	}
	
	public List<Uzduotis> getKursoUzduotis(String kursoKodas){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Uzduotis> uzduotys = s.createQuery("FROM Uzduotis WHERE kurso_kodas = '" + kursoKodas + "'").list();
			t.commit();
			return uzduotys;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public void pridetiUzduoti(String pav, String salyga, String vertTvarka, float maxBalai, String terminas,
			String kursoKodas, boolean galimaIkelti) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Uzduotis naujas = new Uzduotis(pav, salyga, vertTvarka, maxBalai, terminas, kursoKodas, galimaIkelti);
			s.save(naujas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
	}
	
	public List<Uzduotis> getUzduotys(){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Uzduotis> uzduotys = s.createQuery("FROM Uzduotis").list();
			t.commit();
			return uzduotys;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public Set<Kursas> getStudentoKursai(int id){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Studentas> studentas = s.createQuery("FROM Studentas WHERE id = " + id).list();
			@SuppressWarnings("unchecked")
			List<Grupe> list = s.createQuery("FROM Grupe WHERE grupes_kodas = '" + studentas.get(0).getGrupesKodas() + "'").list();
			t.commit();
			return list.get(0).getKursai();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public void pridetiKursa(String kodas, String pav, int destID) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Kursas naujas = new Kursas(kodas, pav, destID);
			s.save(naujas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		}
		s.close();
	}
	
	public List<Kursas> getKursai(){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Kursas> list = s.createQuery("FROM Kursas").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public List<Destytojas> getDestytojai() {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Destytojas> list = s.createQuery("FROM Destytojas").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
		
	}
	public Destytojas getDestytojasById(int id) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Destytojas> list = s.createQuery("FROM Destytojas WHERE id = " + id).list();
			t.commit();
			return list.get(0);
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	public void salintiDestytoja(int id){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.delete(getDestytojasById(id));
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		
	}

	public void atnaujintiDestytojoDuomenis(int id, String vardas, String pavarde) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Destytojas pakeistas = new Destytojas(id, vardas, pavarde);
			s.update(pakeistas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		
	}
	

	public void pridetiGrupe(int metai, String kodas, String kursoPav) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Grupe naujas = new Grupe(metai, kodas, kursoPav);
			s.save(naujas);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		}
		s.close();
		
		
	}
	public Grupe getGrupeById(String kodas) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Grupe> list = s.createQuery("FROM Grupe WHERE kodas = '" + kodas + "'").list();
			t.commit();
			return list.get(0);
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public List<Grupe> getGrupes() {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Grupe> list = s.createQuery("FROM Grupe").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
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
	
	public Uzduotis getUzduotisByPav(String pav) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Uzduotis> list = s.createQuery("FROM Uzduotis WHERE  PAV = '" + pav + "'").list();
			t.commit();
			return list.get(0);
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public IkeltasDarbas getDarbasByStudID(int id){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<IkeltasDarbas> list = s.createQuery("FROM IkeltasDarbas WHERE  STUD_ID = " + id).list();
			t.commit();
			return list.get(0);
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public void updateIkeltasDarbas(IkeltasDarbas tmp) {
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.update(tmp);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
	}
	
	public List<IkeltasDarbas> getIkeltiDarbai(){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<IkeltasDarbas> list = s.createQuery("FROM IkeltasDArbas").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public List<IkeltasDarbas> getIkeltiDarbaiByUzdPav(String uzdPav){
		Session s = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<IkeltasDarbas> list = s.createQuery("FROM IkeltasDarbas where UZD_PAV = '" + uzdPav + "'").list();
			t.commit();
			return list;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		s.close();
		return null;
	}
	
	public void saveToFile(String file, Object o) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.close();
	}


}
