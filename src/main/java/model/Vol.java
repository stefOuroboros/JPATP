package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vol {

	@GeneratedValue
	@Id
	private Long id;
	@Column(nullable = false, length = 4)
	private String flightNumber;
	@Enumerated(EnumType.STRING)
	private PlaneType planeType;
	@Column(nullable = false)
	private long passengersMax;
	@Column(nullable = false)
	private String departureCity;
	@Column(nullable = false)
	private String arrivalCity;
	@Column(nullable = false)
	private LocalDate departureDate;

	@Column(nullable = false)
	@OneToMany(mappedBy = "vol", fetch=FetchType.LAZY)
	List<Reservation> reservationList;
	
	public Vol() {
		super();
	}

	public Vol(String flightNumber, PlaneType planeType, long passengersMax, String departureCity, String arrivalCity,
			LocalDate departureDate) {
		super();
		this.flightNumber = flightNumber;
		this.planeType = planeType;
		this.passengersMax = passengersMax;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumVol() {
		return flightNumber;
	}

	public void setNumVol(String numVol) {
		this.flightNumber = numVol;
	}

	public PlaneType getPlaneType() {
		return planeType;
	}

	public void setPlaneType(PlaneType planeType) {
		this.planeType = planeType;
	}

	public Long getPassengersMax() {
		return passengersMax;
	}

	public void setPassengersMax(Long passengersMax) {
		this.passengersMax = passengersMax;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", numVol=" + flightNumber + ", planeType=" + planeType + ", passengersMax="
				+ passengersMax + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity
				+ ", departureDate=" + departureDate + "]\n";
	}

}
