package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Todo;
import models.Todos_projects;
import utils.DBUtil;

/**
 * Servlet implementation class NewAccontServlet
 */
@WebServlet("/createTodo")
public class CreateTodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String _token = request.getParameter("_token");
        //if(_token != null && _token.equals(request.getSession().getId())) {
            try {
                EntityManager em = DBUtil.createEntityManager();

                Todo t = new Todo();

                String content = request.getParameter("content");
                t.setContent(content);

                int status = 0;
                t.setStatus(status);

                String creator = (String)request.getSession().getAttribute("user_id");
                t.setCreator(creator);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(request.getParameter("deadline_at"));
                Timestamp deadline_at = new Timestamp(date.getTime());
                t.setDeadline_at(deadline_at);

                Timestamp current_time= new Timestamp(System.currentTimeMillis());
                t.setCreate_at(current_time);

                em.getTransaction().begin();
                em.persist(t);
                em.getTransaction().commit();


                String project_id = request.getParameter("project_id");
                if(project_id != null && !(project_id.equals(""))) {
                   t.setIn_project(true);

                   em.getTransaction().begin();
                   em.persist(t);
                   em.getTransaction().commit();

                   Todos_projects tp = new Todos_projects();


                   Long todo_id = t.getTodo_id();
                   tp.setTodo_id(todo_id);

                   tp.setProject_id(project_id);

                   em.getTransaction().begin();
                   em.persist(tp);
                   em.getTransaction().commit();

                }
                else {
                    t.setIn_project(false);

                    em.getTransaction().begin();
                    em.persist(t);
                    em.getTransaction().commit();
                }


                request.getSession().setAttribute("flush", "Todoの登録が完了しました。");
                em.close();

                // indexのページにリダイレクト
                response.sendRedirect(request.getContextPath() + "/index");
            }
            catch(ParseException e){
                request.getSession().setAttribute("flush", "エラーが発生しました。");
                response.sendRedirect(request.getContextPath() + "/index");
            }

        //}
        /*else {
            request.getSession().setAttribute("flush", "Todo作成ボタンからアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/start");
        }*/
    }
}
