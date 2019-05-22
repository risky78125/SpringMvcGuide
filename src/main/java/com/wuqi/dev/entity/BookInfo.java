package com.wuqi.dev.entity;

import com.fasterxml.jackson.annotation.JsonView;

public class BookInfo {

    public interface SimpleView {}

    public interface DetailView extends SimpleView {}

    @JsonView(SimpleView.class)
    private Long bookId;

    @JsonView(SimpleView.class)
    private String bookName;

    @JsonView(DetailView.class)
    private String author;

    @JsonView(DetailView.class)
    private String publisher;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
