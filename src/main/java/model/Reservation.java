package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@GeneratedValue
	@Id
	private long id;
	@Column(nullable = false)
	private String reservationNumber;
	@ManyToOne(fetch = FetchType.LAZY)
	Person person;
	@ManyToOne(fetch = FetchType.LAZY)
	Vol vol;

	public Reservation() {
		super();
	}

	public Reservation(String reservationNumber, Person person, Vol vol) {
		super();
		this.reservationNumber = reservationNumber;
		this.person = person;
		this.vol = vol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationNumber=" + reservationNumber + ", person=" + person.getId()
				+ ", vol=" + vol.getId() + "]";
	}
}
