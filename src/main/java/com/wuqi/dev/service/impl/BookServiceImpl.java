package com.wuqi.dev.service.impl;

import com.wuqi.dev.entity.BookInfo;
import com.wuqi.dev.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public BookInfo getOne() {
        BookInfo book = new BookInfo();
        book.setBookId(1001L);
        book.setBookName("HeadFirst 设计模式");
        book.setAuthor("Freeman");
        book.setPublisher("中国电力出版社");
        return book;
    }
}
