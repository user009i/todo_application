package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Project;
import models.Projects_users;
import models.Todo;
import models.Todos_projects;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String _token = request.getParameter("_token");
        //if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            String user_id = (String)request.getSession().getAttribute("user_id");
            //自身が参加しているProjectのIDリスト
            List<Projects_users> all_projects_id = em.createNamedQuery("getAllMyProjects_id", Projects_users.class).setParameter("user_id", user_id).getResultList();

            //自身が参加しているProjectのIDリストから、Todoのリストを作成
            List<Todo> all_todos_in_project = new ArrayList<Todo>();
            for(Projects_users pid : all_projects_id) {
                List<Todos_projects> todos_in_project = em.createNamedQuery("getAllInTheProjectTodos", Todos_projects.class).setParameter("project_id", pid.getProject_id()).getResultList();

                for(Todos_projects tp : todos_in_project) {
                    Todo t = em.find(Todo.class, tp.getTodo_id());
                    all_todos_in_project.add(t);
                }
            }

            List<Todo> all_todos_not_in_project = em.createNamedQuery("getAllNotInProjectsTodos", Todo.class).getResultList();

            List<Todo> todos = new ArrayList<Todo>();
            List<String> creators = new ArrayList<String>();
            List<String> projects = new ArrayList<String>();

            for(Todo t : all_todos_in_project) {
                todos.add(t);
            }
            for(Todo t : all_todos_not_in_project) {
                todos.add(t);
            }

            //todosのソート実装
            todos.sort((Todo a, Todo b) -> a.getDeadline_at().compareTo(b.getDeadline_at()));
            for(Todo t : todos) {
                User us = em.find(User.class, t.getCreator());
                creators.add(us.getUser_name());
                if(t.getIn_project()) {
                    List<Todos_projects> p = em.createNamedQuery("getAllProjects", Todos_projects.class).setParameter("todo_id", t.getTodo_id()).getResultList();
                    if(p.size() == 1) {
                        Project pr= em.find(Project.class, p.get(0).getProject_id());
                        projects.add(pr.getProject_name());
                    }
                }
                else {
                    projects.add(null);
                }

            }


            em.close();

            request.getSession().setAttribute("todos", todos);
            request.getSession().setAttribute("creators", creators);
            request.getSession().setAttribute("projects", projects);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
            rd.forward(request, response);
        //}

        /*else {
            request.getSession().setAttribute("flush", "正しい手順でアクセスしてください");
            response.sendRedirect(request.getContextPath() + "/login");
        }*/
    }

}