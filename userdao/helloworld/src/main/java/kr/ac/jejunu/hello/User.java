package kr.ac.jejunu.hello;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
