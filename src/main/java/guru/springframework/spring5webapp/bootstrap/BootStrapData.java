package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher publisher = new Publisher();
        publisher.setAddress("228 Rajaram Nagar");
        publisher.setName("Sahyog House");
        publisher.setCity("Dewas");
        publisher.setState("M.P.");
        publisher.setZip("455001");

        // store in publisher repo
        publisherRepository.save(publisher);
        System.out.println("Publisher count --- "+publisherRepository.count());


        Author Shiva = new Author("Shiva","Shukla");
        Book book_Shiva = new Book("Book of Radisys","123321");

        // Add book to author
        // Add author to book
        Shiva.getBooks().add(book_Shiva);
        book_Shiva.getAuthors().add(Shiva);
        book_Shiva.setPublisher(publisher);
        publisher.getBooks().add(book_Shiva);

        authorRepository.save(Shiva);
        bookRepository.save(book_Shiva);

        System.out.println("Hi Pritesh !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("No of Books" + bookRepository.count());

        Author Pritesh =new Author("Pritesh","Gethewale");
        Book book_Pritesh = new Book("Book of truth","456987");
        Pritesh.getBooks().add(book_Pritesh);
        Pritesh.getBooks().add(book_Shiva);

        book_Pritesh.getAuthors().add(Pritesh);
        book_Shiva.getAuthors().add(Pritesh);

        authorRepository.save(Pritesh);
        bookRepository.save(book_Pritesh);

        //publisher.getBooks().add(book_Pritesh);
        //book_Pritesh.setPublisher(publisher);
        //publisher.getBooks().add(book_Pritesh);

        System.out.println("Today is 28th !!!!!");
        System.out.println("No of Books"+bookRepository.count());

        System.out.println("Books"+book_Shiva.getTitle());

    }
}
