package techniques;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ons Ben Othmen
 */


public class DataSource 
{
    private String url;
    private String login;
    private String password;
    private static DataSource dataSource;
    private Connection connection;

    private DataSource() 
    {
        url = "jdbc:mysql://localhost:3306/bonsplansjava";
        login = "root";
        password = "";
        try 
        {
            connection = DriverManager.getConnection(url, login, password);
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() 
    {
        return connection;
    }

    public static DataSource getInstance() 
    {
        if (dataSource == null) 
        {
            dataSource = new DataSource();
        }
        return dataSource;
    }
}
