package services.impl;

import models.Book;
import repositories.BookRepository;
import services.interfaces.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.lang.String.format;

@Slf4j
@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        log.info("In BookServiceImpl getById {}", id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new NoSuchElementException(format("No book with id %s", id));
        }
    }

    @Override
    public void delete(Long id) {
        log.info("In BookServiceImpl delete {}", id);
        bookRepository.deleteById(id);
    }

    @Override
    public void save(Book book) {
        log.info("In BookServiceImpl save {}", book);
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("In BookServiceImpl getAllBooks");
        return bookRepository.findAll();
    }
}
