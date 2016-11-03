package pl.mps.userUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UsersRepository {

    static private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static private final String DB_URL = "jdbc:mysql://localhost/TEST?serverTimezone=UTC";
    static private final String USER = "root";
    static private final String PASS = "root";

    public Collection<User> findAllUsers() {

        Collection<User> foundUsers = new ArrayList<>();


        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String company = rs.getString("company");
                User user = new UserBuilder().setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setCompany(company)
                        .build();
                foundUsers.add(user);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return foundUsers;
    }
}
