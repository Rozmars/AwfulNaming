package services.interfaces;

import models.Book;

import java.util.List;


public interface IBookService {

    Book getBookById(final Long id);

    void delete(final Long id);

    void save(Book book);

    List<Book> getAllBooks();

}
