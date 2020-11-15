package me.lazydev.projects.bukujava.api;

import me.lazydev.projects.bukujava.models.Author;
import me.lazydev.projects.bukujava.models.Book;
import me.lazydev.projects.bukujava.services.AuthorService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorEndpoint {

    @GET
    public List<Author> list() {
        return AuthorService.listAllAuthors();
    }

    @Path("/{name}")
    @GET
    public Author find(@PathParam String name) {
        return AuthorService.getAuthorByName(name);
    }

    @POST
    public Long add(Author author) {
        return AuthorService.addAuthor(author);
    }

    @PUT
    public Long update(Author author) {
        return AuthorService.updateAuthor(author);
    }

    @DELETE
    public Long delete(Long authorId) {
        return AuthorService.deleteAuthor(authorId);
    }

    @Path("/{name}/books")
    @POST
    public boolean addBooks(@PathParam String name, List<Book> books) {
        return AuthorService.addAuthorBook(name, books);
    }

    @Path("/{name}/books")
    @GET
    public List<Book> books(@PathParam String name) {
        return AuthorService.getAuthorByName(name).getBooks();
    }
}
