package dao;
import model.Vol;

public class VolsDao extends GenericDao<Vol> {
	
	private static VolsDao dao;

	public VolsDao() {
		super(Vol.class);
	}
	
	static public VolsDao instance() {
		if (dao == null) {
			dao = new VolsDao();
		}
		return dao;
	}
}
