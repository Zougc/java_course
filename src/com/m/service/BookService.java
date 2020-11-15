package com.m.service;

import com.m.entity.Books;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    public int insert(Books book) throws SQLException;
    public int update(Books book);
    public int delete(Books book);
    public List<Books> queryBypar(Books book);
}
