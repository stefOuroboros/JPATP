package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String author;
	
	@ManyToMany(mappedBy="books")
	private List<Client> clients;
	
	@OneToMany(mappedBy="bestBook")
	private List<Client> clientsIsBestBook;
	
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return "Titre du livre : " +this.getTitle() + " de l'auteur : " + this.getAuthor();
	}
}
