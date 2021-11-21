package com.doris.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doris.domain.Book;

public interface IBookService extends IService<Book> {
    public Boolean saveBook(Book book);
    public Boolean modify(Book book);
    public Boolean delete(Integer id);
    public IPage<Book> getPage(int currentPage, int pageSize, Book book);
    public IPage<Book> getPage(int currentPage, int pageSize);
}
