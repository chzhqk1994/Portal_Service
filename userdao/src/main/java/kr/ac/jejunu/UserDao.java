package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User get(int id) throws ClassNotFoundException, SQLException{
        Connection connection = getConnection();

        // sql 작성하고
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);
        // sql 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        // 결과를 User에 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt( "id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        // 자원을 해지하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        // 결과를 리턴한다
        return user;
    }


    // Extract >> Method
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        //mysql driver load
        Class.forName("com.mysql.jdbc.Driver");
        // Connection 맺고
        return DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju?characterEncoding=utf-8", // 인코딩을 추가해준다
        "jeju", "jejupw");
    }


    public Integer insert(User user) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo(name, password) values (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();

        // 등록된 과정을 확인해주기 위한 코드
        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt(1);
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return id;
    }
}
