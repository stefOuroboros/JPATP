package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;
import model.Client;
import model.Gender;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Book book = new Book();
		book.setTitle("UML For Java Programmers");
		book.setAuthor("Robert Cecil Martin");
		em.persist(book);
		
		Book book2 = new Book();
		book2.setTitle("Twilight");
		book2.setAuthor("Stéphanie Meyer");
		em.persist(book2);
		

		Client client = new Client();
		client.setFirstname("Bob");
		client.setLastname("Obo");
		client.setGender(Gender.M);
		ArrayList<Book> clientListBooks = new ArrayList<Book>();
		clientListBooks.add(book);
		clientListBooks.add(book2);
		client.setBestBook(book);
		client.setBooks(clientListBooks);
		em.persist(client);

		
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		Client findClient = em.find(Client.class, client.getId());
		System.out.println(findClient.getFirstname()
				+ " " + findClient.getLastname()
				+ " a acheté les livres " + client.getBooks());
		em.close();

		em = emf.createEntityManager();
		TypedQuery<Client> query = em.createQuery(
			       "SELECT DISTINCT c " +
			               "FROM Client c " +
			               "INNER JOIN FETCH c.books b " +
			               "WHERE b.id=:id ", Client.class);
			query.setParameter("id", book.getId());
			List<Client> listClient = query.getResultList();
			
			for (Client cli : listClient) {
				System.out.println(cli);
			}
		em.close();

	}

}
