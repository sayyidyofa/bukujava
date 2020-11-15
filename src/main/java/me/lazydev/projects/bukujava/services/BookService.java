package me.lazydev.projects.bukujava.services;

import me.lazydev.projects.bukujava.models.Author;
import me.lazydev.projects.bukujava.models.Book;

import javax.transaction.Transactional;
import java.util.List;

public class BookService {

    @Transactional
    public static List<Book> getAllBooks() {
        return Book.listAll();
    }

    @Transactional
    public static Book findBookByTitle(String title) {
        return Book.find("title", title).firstResult();
    }

    @Transactional
    public static Long updateBook(Book book) {
        return (long) Book.update("title = ?1 where id = ?2", book.getTitle(), book.getId());
    }

    @Transactional
    public static boolean deleteBook(Long bookId) {
        return Book.deleteById(bookId);
    }

    @Transactional
    public static Author getAuthor(Long bookId) {
        Book book = Book.findById(bookId);
        return book.getAuthor();
    }

}
