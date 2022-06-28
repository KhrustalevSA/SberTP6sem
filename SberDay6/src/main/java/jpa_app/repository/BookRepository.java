package jpa_app.repository;

import jpa_app.entityes.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    ArrayList<BookEntity> findByTitle(String titel);
    ArrayList<BookEntity> findByAuthor(String author);
    ArrayList<BookEntity> findByDescription(String description);
}
