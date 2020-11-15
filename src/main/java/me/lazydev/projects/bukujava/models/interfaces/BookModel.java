package me.lazydev.projects.bukujava.models.interfaces;

public interface BookModel {
    Long getId();

    String getTitle();

    static BookModel findByTitle() {
        return null;
    }

    AuthorModel getAuthor();
}
