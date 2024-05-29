package models;

import java.sql.Timestamp;

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
            name = "getAllOnlyMyTodos",
            query = "SELECT t FROM Todo AS t WHERE t.creator = :user_id AND t.in_project = false"
    )
})

@Table(name = "Todos")
public class Todo {
    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Integer status;

    @Column(name = "creator")
    private String creator;

    @Column(name = "deadline_at")
    private Timestamp deadline_at;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "done_at")
    private Timestamp done_at;

    @Column(name = "in_project")
    private Boolean in_project;

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Timestamp getDeadline_at() {
        return deadline_at;
    }

    public void setDeadline_at(Timestamp deadline_at) {
        this.deadline_at = deadline_at;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getDone_at() {
        return done_at;
    }

    public void setDone_at(Timestamp done_at) {
        this.done_at = done_at;
    }

    public Boolean getIn_project() {
        return in_project;
    }

    public void setIn_project(Boolean in_project) {
        this.in_project = in_project;
    }



}