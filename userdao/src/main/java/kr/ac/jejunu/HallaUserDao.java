package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HallaUserDao extends UserDao {
    public Connection getConnection() throws ClassNotFoundException, SQLException {  // UserDao에서 추상화된 getconnection 함수를 불러옴
        //mysql driver load
        Class.forName("com.mysql.jdbc.Driver");
        // Connection 한다
        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", // 인코딩을 추가해준다
                "root", "thdgusdn");
    }
}
