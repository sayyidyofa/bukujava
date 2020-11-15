package me.lazydev.projects.bukujava.models.interfaces;

import java.util.List;

public interface AuthorModel {
    Long getId();

    String getName();

    String getAddress();

    static AuthorModel findByName(String name) {
        return null;
    }

    List<? extends BookModel> getBooks();

}
