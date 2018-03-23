package kr.ac.jejunu;

import java.sql.*;

public abstract class UserDao {
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


    public Integer insert(User user) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO userinfo(name, password) values (?, ?)");
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

    // Extract >> Method
    abstract public Connection getConnection() throws ClassNotFoundException, SQLException;
    // 제주대와 한라대에서 비슷한 내용의 요청이 들어와서 각 학교의 getConnection을 만들지 않고 추상화를 하려고 한다.
    // 제주대와 한라대에서 getConnection 에 뭐가 있는지 모르므로 추상화를 하고 UserDaoTest 에서 JejuUserDao와 HallaUserDao를 만들고 UserDao를 참조
    // 메소드가 abstract되면 클래스도 abstract 되어야 한다
    // 추상화를 했는데 private 이면 외부에서 사용 못하므로 private 에서 public 으로 바꿔준다
    // 추상화 하면 body를 가질수가 없어 내용물을 모두 없애고 선언만 해준다.

}
