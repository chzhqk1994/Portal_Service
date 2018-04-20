package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetUserStatementStrategy implements StatementStrategy {
    private Integer id;

    public GetUserStatementStrategy(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        // sql 작성하고
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test WHERE id = ?");
        preparedStatement.setInt(1, id);

        return preparedStatement;
    }
}
