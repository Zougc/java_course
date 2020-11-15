package com.m.Dao.impl;

import com.m.Dao.baseDao.BaseDao;
import com.m.entity.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int insert(Books book)  {
        Connection conn = null;
        try {
             conn = super.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into books ('name','anther') values(?,?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setObject(1,book.getName());
           ps.setObject(2,book.getAnther());
          int i = ps.executeUpdate();
          conn.commit();
          return i;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn!=null){
                try {
                    conn.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }finally {
            super.closeConnection();
    }
    return 0;
}

    @Override
    public int update(Books book) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);
            String sql = "update books set name = ?,anther = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,book.getName());
            ps.setObject(2,book.getAnther());
            ps.setObject(3,book.getId());
            int i = ps.executeUpdate();
            conn.commit();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn!=null){
                try {
                    conn.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public int delete(Books book) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from books where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,book.getId());
            int i = ps.executeUpdate();
            conn.commit();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn!=null){
                try {
                    conn.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public List<Books> queryBypar(Books book) {
        List<Books> books= new ArrayList<Books>();
        Connection conn = null;
        try {
            conn = super.getConnection();
            StringBuffer sql = new StringBuffer("select id,name,anther,create_time from books where 1 = 1");
            if(book != null){
                if(book.getId()!=null){
                    sql.append(" and ");
                    sql.append( "id = ?" );
                }
                if(book.getName()!=null){
                    sql.append(" and ");
                    sql.append( "name like ?" );
                }
                if(book.getAnther()!=null){
                    sql.append(" and ");
                    sql.append( "anther like ?" );
                }
            }
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            int index = 0;
            if(book != null){
                if(book.getId()!=null){
                    ps.setObject(index,book.getId());
                }
                if(book.getName()!=null){
                    ps.setObject(index,book.getName());
                }
                if(book.getAnther()!=null){
                    ps.setObject(index,book.getAnther());
                }
            }
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (rs.next()){
                Books b = new Books();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String anther = rs.getString("anther");
                String createTime = rs.getString("create_time");
                b.setId(id);
                b.setName(name);
                b.setAnther(anther);
                b.setCreateTime(sdf.parse(createTime));
                books.add(b);
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            if(conn!=null){
                try {
                    conn.rollback();
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }finally {
            super.closeConnection();
        }
   return books;
    }
}
