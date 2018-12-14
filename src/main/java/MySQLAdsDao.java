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
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(showAllQuery);
            while (rs.next()) {
                Ad buildAd = new Ad(
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
                output.add(buildAd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public Long insert(Ad ad){
        long lastInsertId = 0;
        try {
            String insertQuery = "INSERT INTO ads (id, user_id, title, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getId());
            stmt.setLong(2, ad.getUserId());
            stmt.setString(3, ad.getTitle());
            stmt.setString(4, ad.getDescription());
            stmt.executeUpdate();
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

