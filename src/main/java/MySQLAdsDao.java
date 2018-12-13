import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection conn;

    public MySQLAdsDao(Config config) {
        Connection conn;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> output = new ArrayList<>();
        String showAllQuery = "SELECT * FROM ADS";
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(showAllQuery);
            while (rs.next()) {
                Ad buildAd = new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description"));
                output.add(buildAd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public Long insert(Ad ad){
        String insertQuery = String.format(
                "INSERT INTO ads (id, user_id, title, description) VALUES (%d, %d, '%s', '%s')",
                    ad.getId(),
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription());
        long lastInsertId = 0;
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet keysResultSet = stmt.getGeneratedKeys();
            long lastInsertedId = keysResultSet.getLong(1);
                System.out.println(lastInsertedId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastInsertId;
    }

}


//Create a class named MySQLAdsDao that implements the Ads interface
//
//  -This class should have a private instance property named connection of type Connection that is initialized
//  in the constructor. Define your constructor so that it accepts an instance of your Config class so that it
//  can obtain the database credentials.
//
//  -Implement the methods in the Ads interface
//
//  -Your methods should retrieve ads from the database and insert new ads into the database
//
//The connection object will be created just once, in this class' constructor, and the individual
//methods that query the database should use the connection object to create statements.

