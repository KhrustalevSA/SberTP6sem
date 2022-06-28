package jpa_app.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private Long uid;

    private String title;

    private String author;

    private String description;

    public BookEntity(){}

    public BookEntity(String title, String author, String description){
        this.title = title;
        this.author = title;
        this.description = description;
    }

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
