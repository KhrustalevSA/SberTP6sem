package jpa_app.controllers;

import jpa_app.entityes.BookEntity;
import jpa_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    BookService bookService;

    @GetMapping("/allbooks")
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book")
    public List<BookEntity> getBook(@RequestParam(value = "id") Optional<Long> id,
                                    @RequestParam(value = "title") Optional<String> title,
                                    @RequestParam(value = "author") Optional<String> author,
                                    @RequestParam(value = "description") Optional<String> description){
        if (id.isPresent()) {
            return bookService.getBookById(id.get());
        } else if (title.isPresent()) {
            return bookService.getBookByTitle(title.get());
        } else if (author.isPresent()) {
            return bookService.getBookByAuthor(author.get());
        } else if (description.isPresent()) {
            return bookService.getBookByDescription(description.get());
        }
        return null;
    }

    @GetMapping("deletebook")
    public void deleteBook(@RequestParam(value = "id") long id) {
        bookService.delete(id);
    }

    @GetMapping("addbook")
    public long saveBook(@RequestParam(value = "title") String title,
                         @RequestParam(value = "author") String author,
                         @RequestParam(value = "description") String description){
        BookEntity book = new BookEntity(title,author,description);
        bookService.saveOrUpdate(book);
        return book.getUid();
    }
}
