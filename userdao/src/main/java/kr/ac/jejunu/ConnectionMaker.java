package kr.ac.jejunu;

import java.sql.*;

public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}