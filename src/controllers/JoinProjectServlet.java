package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Project;
import models.Projects_users;
import utils.DBUtil;

/**
 * Servlet implementation class UserConfirm
 */
@WebServlet("/joinProject")
public class JoinProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String _token = request.getParameter("_token");
        //if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // 該当のIDのメッセージ1件のみをデータベースから取得
            Project p = em.find(Project.class, request.getParameter("project_id"));

            if(p != null) {
                Projects_users pj = new Projects_users();
                String project_id = request.getParameter("project_id");
                String user_id = request.getParameter("user_id");

                pj.setProject_id(project_id);
                pj.setUser_id(user_id);

                em.getTransaction().begin();
                em.persist(pj);
                em.getTransaction().commit();

                request.getSession().setAttribute("flush", "Projectへの参加が完了しました");
                em.close();

                request.setAttribute("_token", request.getSession().getId());

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
                rd.forward(request, response);

            }

            else {
                request.setAttribute("flush", "このユーザIDは既に使用されています");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/project.jsp");
                rd.forward(request, response);
            }


        //}
        /*else {
            request.getSession().setAttribute("flush", "アカウント作成ページからアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/start");
        }*/
    }

}
