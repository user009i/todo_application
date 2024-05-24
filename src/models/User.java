package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_name", length = 255, nullable = false)
    private String user_name;

    @Column(name = "user_password", length = 255, nullable = false)
    private byte[] user_password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public byte[] getUser_password() {
        return user_password;
    }

    public void setUser_password(byte[] user_password) {
        this.user_password = user_password;
    }


}