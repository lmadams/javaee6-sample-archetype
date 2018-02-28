package org.adams.zattoni.javaee.sample.resource;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.adams.zattoni.javaee.sample.domain.SbEntity;
import org.adams.zattoni.javaee.sample.service.IsbnGenerator;
import org.adams.zattoni.javaee.sample.service.ItemEJB;
import org.adams.zattoni.javaee.sample.domain.Book;
import org.adams.zattoni.javaee.sample.service.SbEJB;

@Path("/items")
@ManagedBean
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemRestService {

  @Inject
  private IsbnGenerator numberGenerator;

  @Inject
  private ItemEJB itemEJB;

  @Inject
  private SbEJB sbEJB;

  @GET
  @Path("/{bookKey}")
  public Book getBook(@PathParam("bookKey") Long id) {
    return itemEJB.getBook(id);
  }

  @GET
  @Path("/isbn")
  @Produces(MediaType.TEXT_PLAIN)
  public String getISBN() {
    return numberGenerator.generateNumber();
  }

  @POST
  public Book createBook(Book book) {
    book.setIsbn(numberGenerator.generateNumber());
    itemEJB.createBook(book);
    return book;
  }

  @POST()
  @Path("/sb")
  public SbEntity createSb(final SbEntity sbEntity) {
    return sbEJB.create(sbEntity);
  }

  @GET
  public List<Book> findAllBooks() {
    return itemEJB.findAllBooks();
  }
}