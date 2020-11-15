package com.m.service;

import com.m.Dao.impl.BookDao;
import com.m.Dao.impl.BookDaoImpl;
import com.m.entity.Books;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public int insert(Books book) throws SQLException {
        return dao.insert(book);
    }

    @Override
    public int update(Books book) {
        return dao.update(book);
    }

    @Override
    public int delete(Books book) {
        return dao.delete(book);
    }

    @Override
    public List<Books> queryBypar(Books book) {
        return dao.queryBypar(book);
    }
}
