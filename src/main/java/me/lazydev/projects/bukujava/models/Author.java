package me.lazydev.projects.bukujava.models;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import me.lazydev.projects.bukujava.models.interfaces.AuthorModel;
import me.lazydev.projects.bukujava.models.interfaces.BookModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends PanacheEntityBase implements AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator ="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    public String name;
    public String address;

    @OneToMany(
            targetEntity = Book.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Book> books;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public static Author findByName(String name) {
        return find("name", name).firstResult();
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }
}
