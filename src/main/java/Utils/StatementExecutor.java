package Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementExecutor {
    private final SingletonDBConnection postgresConnection;

    public StatementExecutor() {
        this.postgresConnection = SingletonDBConnection.getInstance();
    }

    public ResultSet executeSQLCommand(String command, String... args) throws SQLException {
        PreparedStatement statementExec = postgresConnection.getConnection().prepareStatement(command);
        try {
            for (int i = 0; i < args.length; i++) {
                statementExec.setString(i + 1, args[i]);
            }
            System.out.println("Command prepared");
            return statementExec.executeQuery();
        } catch (SQLException e) {
            System.out.println("Command failed");
        }
//        finally {
//            statementExec.close();
//        }
        return null;
    }
}
