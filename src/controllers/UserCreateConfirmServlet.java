package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UserConfirm
 */
@WebServlet("/userCreateConfirm")
public class UserCreateConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateConfirmServlet() {
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
            User u = em.find(User.class, request.getParameter("user_id"));

            if(u != null) {
                request.setAttribute("flush", "このユーザIDは既に使用されています");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/signup.jsp");
                rd.forward(request, response);
            }

            else {
                String user_name = request.getParameter("user_name");
                String user_id = request.getParameter("user_id");
                String user_password = request.getParameter("user_password");

                try {
                    MessageDigest sha3_256 = MessageDigest.getInstance("SHA3-256");
                    byte[] user_password_enc = sha3_256.digest(user_password.getBytes());

                    em.getTransaction().begin();

                    User us = new User();
                    us.setUser_name(user_name);
                    us.setUser_id(user_id);
                    us.setUser_password(user_password_enc);

                    em.persist(us);
                    em.getTransaction().commit();
                    em.close();

                }
                catch(NoSuchAlgorithmException e){
                    em.close();
                    request.setAttribute("flush", "エラーが発生しました");
                    response.sendRedirect(request.getContextPath() + "/start");
                }

                request.getSession().setAttribute("user_name", user_name);

                request.setAttribute("_token", request.getSession().getId());

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
                rd.forward(request, response);
            }


        //}
        /*else {
            request.getSession().setAttribute("flush", "アカウント作成ページからアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/start");
        }*/
    }

}
