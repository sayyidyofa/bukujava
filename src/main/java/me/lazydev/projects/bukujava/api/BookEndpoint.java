package me.lazydev.projects.bukujava.api;

import me.lazydev.projects.bukujava.models.Book;
import me.lazydev.projects.bukujava.services.BookService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookEndpoint {

    @GET
    public List<Book> list() {
        return BookService.getAllBooks();
    }

    @Path("/{title}")
    @GET
    public Book find(@PathParam String title) {
        return BookService.findBookByTitle(title);
    }

    @PUT
    public Long update(Book book) {
        return BookService.updateBook(book);
    }

    @DELETE
    public boolean delete(Long bookId) {
        return BookService.deleteBook(bookId);
    }
}
