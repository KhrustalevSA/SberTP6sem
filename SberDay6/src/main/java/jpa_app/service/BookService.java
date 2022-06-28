package jpa_app.service;

import jpa_app.entityes.BookEntity;
import jpa_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public List<BookEntity> getAllBooks(){return new ArrayList<>(repository.findAll());}

    public ArrayList<BookEntity> getBookById(long id) {
        if (repository.findById(id).isPresent()) {
            return new ArrayList<BookEntity>(List.of(repository.findById(id).get()));
        }
        return null;
    }

    public ArrayList<BookEntity> getBookByTitle(String title) {
        return repository.findByTitle(title);
    }

    public ArrayList<BookEntity> getBookByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public ArrayList<BookEntity> getBookByDescription(String description) {
        return repository.findByDescription(description);
    }
    public void saveOrUpdate(BookEntity book){repository.save(book);}

    public void delete(long id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
