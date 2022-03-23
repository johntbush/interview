package godaddy;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *  Bulk import records into a database.
 *
 */
public class UserRegistrationBulkManager
{
    static Logger log = Logger.getLogger(UserRegistrationBulkManager.class.getName());

    public void insertRegistrations(List<UserRegistration> list) {
        for (UserRegistration x : list) {
            insertRegistration(x);
        }
    }

    /**
     * CREATE TABLE `Registration` (
     *  `id` int NOT NULL,
     *  `first` varchar(255) DEFAULT NULL,
     *  `last` varchar(255) DEFAULT NULL,
     *  `age` int DEFAULT NULL,
     *  PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     * @param x
     */
    public void insertRegistration(UserRegistration x) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/interview", "root", "");
            Statement stmt = conn.createStatement();
        ) {
            log.info("Inserting record into the table...");
            String sql = String.format("INSERT INTO Registration (ID, FIRST, LAST, AGE) VALUES (%d, '%s', '%s', %d)", x.getId(), x.getFirstName(), x.getLastName(), x.getAge());
            log.debug(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            log.error(String.format("SQL failed: %s", e.getMessage()));
        }
    }

    public static void main( String[] args )
    {
        BasicConfigurator.configure();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            log.error(String.format("Can't load driver: %s", ex.getMessage()));
        }
        List<UserRegistration> users = new ArrayList<>();
        UserRegistration user1 = new UserRegistration("Frank", "Zappa", 104, 80);
        users.add(user1);
        UserRegistrationBulkManager userRegistrationBulkManager = new UserRegistrationBulkManager();
        userRegistrationBulkManager.insertRegistrations(users);
    }
}
