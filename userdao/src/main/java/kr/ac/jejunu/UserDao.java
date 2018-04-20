package kr.ac.jejunu;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(int id) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }


    public Integer insert(User user) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new InserstUserStatementStrategy(user);
        return jdbcContext.jdbcContextForInsert(statementStrategy);
    }


    public void update(User user) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new UpdateUserStatementStrategy(user);
        jdbcContext.jdbcContextForUpdate(statementStrategy);

    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

}