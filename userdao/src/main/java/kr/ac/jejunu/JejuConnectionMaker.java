package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class JejuConnectionMaker implements ConnectionMaker {
    //    어노테이션 Value 로 환경변수 설정   Edit Configuration >> 환경변수 DB_CLASSNAME , com.jdbc.mysql.Driver 등등...
    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(className);
        return DriverManager.getConnection(url, // 인코딩을 추가해준다
                username, password);
    }
}
