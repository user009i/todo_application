package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQueries({
    @NamedQuery(
            name = "getAllInTheProjectTodos",
            query = "SELECT t FROM Todos_projects AS t WHERE t.project_id = :project_id"
    ),
    @NamedQuery(
            name = "getAllProjects",
            query = "SELECT p FROM Todos_projects AS p WHERE p.todo_id = :todo_id"
    )
})
@Table(name = "Todos_projects")
public class Todos_projects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo_id")
    private Long todo_id;

    @Column(name = "project_id")
    private String project_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

}