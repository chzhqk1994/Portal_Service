package kr.ac.jejunu;

import java.sql.*;

public class JejuConnectionMaker implements ConnectionMaker {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", // 인코딩을 추가해준다
                "root","thdgusdn");
    }
}
