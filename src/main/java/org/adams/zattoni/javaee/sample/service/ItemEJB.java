package org.adams.zattoni.javaee.sample.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.adams.zattoni.javaee.sample.domain.Book;

@Stateless
public class ItemEJB {

  @PersistenceContext(unitName = "sampleCdiInjectDefaultPU")
  private EntityManager em;

  public Book getBook(Long id) {
    return em.find(Book.class, id);
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public List<Book> findAllBooks() {
    return em.createNamedQuery("findAllBooks", Book.class).getResultList();
  }

  public List<Book> findAllScifiBooks() {
    return em.createNamedQuery("findAllScifiBooks", Book.class).getResultList();
  }
}