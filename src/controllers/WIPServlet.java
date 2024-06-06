package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Todo;
import utils.DBUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/WIP")
public class WIPServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WIPServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        Todo t = em.find(Todo.class, Long.parseLong(request.getParameter("todo_id")));

        int status = 1;
        t.setStatus(status);

        em.getTransaction().commit();
        request.setAttribute("flush", "Todoの着手を開始しました");
        em.close();

        response.sendRedirect(request.getContextPath() + "/index");
    }
}