import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        Config config = new Config();
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}

//    In the DaoFactory class, switch out the ListAdsDao for your MySQLAdsDao.
//
//        -You should have to make little, if any, changes to the existing code
//
//        -When you create an instance of MySQLAdsDao, create an instance of your Config class to pass to the
//         MySQLAdsDao constructor
//
//        -Verify that your application still functions as before, but that now information is being pulled from
//         and saved to your database
//
//    In order to test the above functionality, you will need to make a couple changes to your application.
//    We defined a one to many relationship between ads and users, so in order to create an add, we will need
//    to tie it to an existing user record. For now, manually insert a record into the users table and note
//    the id of the newly created record. In your controller when an ad is being created, hardcode this id
//    into the ad.