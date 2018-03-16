package kr.ac.jejunu;

public class User {
    private Integer id;
    private String name;
    private String password;


    // set 은 DB에 연결해서 받아와서 변수에 넣어주는것
    // get 은 다른 클래스로 넘겨주는것


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
