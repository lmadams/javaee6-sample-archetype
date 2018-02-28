package org.agoncal.sample.cdi.inject.simple;

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

@Path("/items")
@ManagedBean
public class ItemRestService {

  @Inject
  private IsbnGenerator numberGenerator;

  @Inject
  private ItemEJB itemEJB;

  @GET
  @Path("/{bookKey}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Book getBook(@PathParam("bookKey") Long id) {
    return itemEJB.getBook(id);
  }

  @GET
  @Path("/isbn")
  @Produces(MediaType.TEXT_PLAIN)
  public String getISBN() {
    if (true) {
      throw new RuntimeException();
    }
    return numberGenerator.generateNumber();
  }

  @POST
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Book createBook(Book book) {
    book.setIsbn(numberGenerator.generateNumber());
    itemEJB.createBook(book);
    return book;
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Book> findAllBooks() {
    return itemEJB.findAllBooks();
  }
}