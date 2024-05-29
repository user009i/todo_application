package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.persistence.EntityManager;
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
@WebServlet("/userLoginConfirm")
public class UserLoginConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginConfirmServlet() {
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
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // 該当のIDのメッセージ1件のみをデータベースから取得
            User u = em.find(User.class, request.getParameter("user_id"));

            em.close();

            String user_password = request.getParameter("user_password");

            try {
                MessageDigest sha3_256 = MessageDigest.getInstance("SHA3-256");
                byte[] user_password_enc = sha3_256.digest(user_password.getBytes());

                if(Arrays.equals(u.getUser_password(), user_password_enc)) {
                    request.getSession().setAttribute("user_id", u.getUser_id());
                    request.getSession().setAttribute("user_password", u.getUser_password());
                    request.getSession().setAttribute("user_name", u.getUser_name());
                    request.setAttribute("_token", request.getSession().getId());

                    response.sendRedirect(request.getContextPath() + "/index");
                }
                else {
                    request.getSession().setAttribute("flush", "ユーザID、パスワードが登録されたものと異なっています");
                    response.sendRedirect(request.getContextPath() + "/login");
                }
            }
            catch(NoSuchAlgorithmException e){
                request.getSession().setAttribute("flush", "エラーが発生しました");
                response.sendRedirect(request.getContextPath() + "/start");
            }

        }
        else {
            request.getSession().setAttribute("flush", "ログインページからアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
