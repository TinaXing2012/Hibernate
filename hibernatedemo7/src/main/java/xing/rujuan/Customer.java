package xing.rujuan;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    //    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Book> books = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Movie> movies = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private SalesRep salesRep;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean addMovie(Movie m) {
        return movies.add(m);
    }

}
