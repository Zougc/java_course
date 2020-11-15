package com.m.controller;


import com.m.controller.base.BaseController;
import com.m.entity.Books;
import com.m.entity.Page;
import com.m.service.BookService;
import com.m.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

public class BookController extends BaseController {
    private BookService service = new BookServiceImpl();
    //暂时列表
    public void list() throws Exception {
    Books book = new Books();
    Page page = new Page();
    List<Books> bookList = service.queryBypar(book);
    super.getRequest().setAttribute("bookList",bookList);
        super.getRequest().setAttribute("page",page);
        super.getRequest().getRequestDispatcher("bookList.jsp").forward(getRequest(), (ServletResponse) getRequest());
        service.queryBypar(book);
    }
    //删除
    public void del() throws Exception {
        String id = super.getRequest().getParameter("id");
        Books book = new Books();
        if (id != null) {
            book.setId(Integer.valueOf(id));
            int i = service.delete(book);
            if (i == 1) {
                //删除成功返回一个success
                super.getRequest().setAttribute("result", "success");
            } else {
               // 删除失败返回一个error
                super.getRequest().setAttribute("result", "error");
            }
        } else {
            //没有返回一个error
            super.getRequest().setAttribute("result", "error");
        }
         //最终返回bookList.jsp页面
        //重定向到列表列
        super.getResponse().sendRedirect("/javaWeb/book/toList.do");
        }

    //去修改页面
    public void toUpdate() throws Exception{
        String id = super.getRequest().getParameter("id");
        Books book = new Books();
        if (id != null) {
            book.setId(Integer.valueOf(id));
            int i = service.delete(book);
            if (id != null) {
                book.setId(Integer.valueOf(id));
                List<Books> bookList = service.queryBypar(book);
                if (bookList.size()==1) {
                    book = bookList.get(0);
                    super.getRequest().setAttribute("result", book);
                    super.getRequest().setAttribute("result", "success");
                    super.getRequest().getRequestDispatcher("insertOrUpdateBook.jsp").forward(getRequest(), (ServletResponse) getRequest());
                    return;//防止重复转发
                }

            } else {
                // 查询失败返回一个error
                super.getRequest().setAttribute("result", "error");
            }}else {
                // 查询失败返回一个error
                super.getRequest().setAttribute("result", "error");
            }
        //重定向到列表列
        super.getResponse().sendRedirect("/javaWeb/book/toList.do");
    }
    //新增或修改
    public void insertOrUpdate() throws Exception{
    //如果有id提交
        String id = super.getRequest().getParameter("id");
        String name = super.getRequest().getParameter("name");
        String anther = super.getRequest().getParameter("anther");
        Books book = new Books();
        int i = 0;
        book.setName(name);
        book.setAnther(anther);
        if (id != null && !"".equals(id)) {//修改
            book.setId(Integer.valueOf(id));
          i =  service.update(book);
        } else {//新增
            i=service.update(book);
        }
        //重定向到列表列
        super.getResponse().sendRedirect("/javaWeb/book/toList.do");
    }


}
