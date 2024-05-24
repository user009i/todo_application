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
@WebServlet("/wip")
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
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
                EntityManager em = DBUtil.createEntityManager();
                em.getTransaction().begin();

                Todo t = em.find(Todo.class, request.getParameter("todo_id"));


                int status = 1;
                t.setStatus(status);


                // indexのページにリダイレクト
                response.sendRedirect(request.getContextPath() + "/index");

                em.getTransaction().begin();
                em.getTransaction().commit();
                request.setAttribute("flush", "Todoの登録が完了しました。");
                em.close();

                response.sendRedirect(request.getContextPath() + "/index");

        }
        else {
            request.setAttribute("flush", "Todo作成ボタンからアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/start");
        }
    }
}