package me.lazydev.projects.bukujava.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import me.lazydev.projects.bukujava.models.interfaces.BookModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends PanacheEntityBase implements BookModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    public String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    public Author author;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public Author getAuthor() {
        return this.author;
    }
}
