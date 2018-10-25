package dao;

import model.Reservation;

public class ReservationsDao extends GenericDao<Reservation> {

	private static ReservationsDao dao;
	
	public ReservationsDao() {
		super(Reservation.class);
	}
	
	static public ReservationsDao instance() {
		if (dao == null) {
			dao = new ReservationsDao();
		}
		return dao;
	}

}
