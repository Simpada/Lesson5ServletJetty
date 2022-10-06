package no.kristiania.library;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ListBooksServlet extends HttpServlet {

    private final BookRepository bookRepository;
    public ListBooksServlet(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        res.getWriter().write("<html>");
        res.getWriter().write("Here are the books in the category of " + req.getPathInfo());
        res.getWriter().write("<ul>");
        for (Book book : bookRepository.listAll()) {
            res.getWriter().write("<li>" + book + "</li>");
        }
        res.getWriter().write("</ul>");
        res.getWriter().write("</html>");
    }

}
