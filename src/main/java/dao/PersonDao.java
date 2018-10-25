package dao;

import model.Person;

public class PersonDao extends GenericDao<Person> {
	
	private static PersonDao dao;
	
	public PersonDao() {
		super(Person.class);
	}
	
	static public PersonDao instance() {
		if (dao == null) {
			dao = new PersonDao();
		}
		return dao;
	}
}
