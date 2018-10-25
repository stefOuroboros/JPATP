package main;
import java.time.LocalDate;

import dao.PersonDao;
import dao.ReservationsDao;
import dao.VolsDao;
import model.Menu;
import model.Person;
import model.PlaneType;
import model.Reservation;
import model.Vol;

public class Main {

	public static void main(String[] args) {
		
		Menu.menu();
		
		VolsDao volsDao = VolsDao.instance();
		Vol v1 = new Vol("0001", PlaneType.A330, 150L, "Montpellier", "Paris", LocalDate.now());
		volsDao.persist(v1);
		
		Vol v2 = new Vol("0002", PlaneType.A340, 200L, "Marseille", "Beijin", LocalDate.parse("2018-10-31"));
		volsDao.persist(v2);
		
		Vol v3 = new Vol("0003", PlaneType.B747, 80L, "Calais", "Londres", LocalDate.parse("2019-01-05"));
		volsDao.persist(v3);
		
		PersonDao personDao = PersonDao.instance();
		Person p1 = new Person("Stef", "Gallois", LocalDate.parse("1993-10-20"));
		personDao.persist(p1);
		
		Person p2 = new Person("Thomas", "Champetier", LocalDate.parse("1996-07-11"));
		personDao.persist(p2);
		
		Person p3 = new Person("Lola", "Canal", LocalDate.parse("1991-01-14"));
		personDao.persist(p3);
		
		ReservationsDao reservationDao = ReservationsDao.instance();
		Reservation r1 = new Reservation("1", p1, v1);
		reservationDao.persist(r1);
		
		Reservation r2 = new Reservation("2", p2, v2);
		reservationDao.persist(r2);
		
		Reservation r3 = new Reservation("3", p3, v3);
		reservationDao.persist(r3);
		
		v1.setArrivalCity("Bankok");
		volsDao.merge(v1);
//		reservationDao.remove(r1);
//		reservationDao.remove(r2);
//		reservationDao.remove(r3);
//		volsDao.remove(v2);
		
		System.out.println(volsDao.find(3));
		System.out.println(personDao.findAll());
		
	}

}
