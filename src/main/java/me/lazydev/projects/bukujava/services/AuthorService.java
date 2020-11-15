package me.lazydev.projects.bukujava.services;

import me.lazydev.projects.bukujava.models.Author;
import me.lazydev.projects.bukujava.models.Book;

import javax.transaction.Transactional;
import java.util.List;

public class AuthorService {

    @Transactional
    public static List<Author> listAllAuthors() {
        return Author.listAll();
    }

    @Transactional
    public static Author getAuthorByName(String name) {
        return Author.findByName(name);
    }

    @Transactional
    public static List<Book> getBooksByAuthor(Long authorId) {
        Author author = Author.findById(authorId);
        return author.getBooks();
    }

    @Transactional
    public static Long addAuthor(Author author) {
        Author newAuthor = new Author();
        newAuthor.name = author.name;
        newAuthor.address = author.address;
        newAuthor.persist();
        return newAuthor.getId();
    }

    @Transactional
    public static Long updateAuthor(Author author) {
        Author oldAuthor = Author.findById(author.getId());
        oldAuthor.name = author.name;
        oldAuthor.address = author.address;
        oldAuthor.persist();
        return oldAuthor.getId();
    }

    @Transactional
    public static Long deleteAuthor(Long id) {
        Author author = Author.findById(id);
        author.delete();
        return id;
    }

    @Transactional
    public static boolean addAuthorBook(String name, List<Book> books) {
        books.forEach(book -> getAuthorByName(name).getBooks().add(book));
        return true;
    }
}
