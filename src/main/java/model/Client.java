package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private Integer id;
	private String lastname;
	private String firstname;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToMany
	private List<Book> books;
	@ManyToOne
	private Book bestBook;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Book getBestBook() {
		return bestBook;
	}
	public void setBestBook(Book bestBook) {
		this.bestBook = bestBook;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	public Gender getGender() {
		return gender;		
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
