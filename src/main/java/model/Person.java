package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@GeneratedValue
	@Id
	private Long id;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private LocalDate birthdate;

	@OneToMany(mappedBy = "person", fetch=FetchType.LAZY)
	List<Reservation> reservation;
	
	public Person() {
		super();
	}

	public Person(String lastname, String firstname, LocalDate birthdate) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthdate = birthdate;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Person [lastname=" + lastname + ", firstname=" + firstname + ", birthdate=" + birthdate
				+ ", reservation=" + reservation.size() + "]";
	}
}
