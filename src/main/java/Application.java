import Utils.StatementExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static StatementExecutor statementExecutor = new StatementExecutor();

    public static void main(String[] args) throws SQLException {
        String INSERT = "INSERT INTO books (name, author) VALUES (?, ?)";
        String name = "Batman Apollo";
        String author = "V. Pelevin";
        String SELECT = "SELECT * FROM books WHERE author = ?";
        ResultSet resultSet = statementExecutor.executeSQLCommand(SELECT, author);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("author"));
        }
    }
}
