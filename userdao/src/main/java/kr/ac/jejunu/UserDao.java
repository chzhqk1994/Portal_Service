package kr.ac.jejunu;

import java.sql.SQLException;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM test WHERE id = ?";
        Object[] params = new Object[]{id};
        return jdbcContext.queryForObject(sql, params);
    }


    public Integer insert(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO test(name, password) VALUES (?, ?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        return jdbcContext.insert(sql, params);
    }


    public void update(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE test SET name = ?, password = ? WHERE id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);

    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM test WHERE id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }

}