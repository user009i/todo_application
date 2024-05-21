package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllTodos",
        query = "SELECT m FROM Todo AS m ORDER BY m.create_at DESC"
    )
})
@Table(name = "Todos")
public class Todo {
    @Id
    @Column(name = "todo_id")
    private String todo_id;

    @Column(name = "content")
    private String content;

    @Column(name = "done")
    private Boolean done;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "done_at")
    private Timestamp done_at;

    public String getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(String todo_id) {
        this.todo_id = todo_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

}