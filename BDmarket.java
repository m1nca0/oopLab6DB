import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class BDmarket {
  public static Connection market;
  public static Statement stab;
  public static ResultSet result;

  private static List<Producer> producers = new ArrayList<>();
  private static List<Customer> customer = new ArrayList<>();
  private static List<User> beats = new ArrayList<>();

  public static void connectionBDmarket() throws ClassNotFoundException, SQLException {
    market = null;
    Class.forName("org.postgresql.Driver");
    market = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beat_market", "mihailvasilev", "095147");
    System.out.println("БД подключена!");
  }

  public static void newTable() throws SQLException {
    stab = market.createStatement();
    stab.execute(
        "CREATE TABLE IF NOT EXISTS producers (id SERIAL PRIMARY KEY, username VARCHAR(50), email VARCHAR(50), password VARCHAR(50), registrationDate TIMESTAMP, balance DECIMAL(10,2), rating DECIMAL(3,2));");
    System.out.println("Таблица Битмейкеры существует");
    stab.execute(
        "CREATE TABLE IF NOT EXISTS customers (id SERIAL PRIMARY KEY, username VARCHAR(50), email VARCHAR(50), password VARCHAR(50), registrationDate TIMESTAMP, balance DECIMAL(10,2), artistName VARCHAR(50));");
    System.out.println("Таблица Артисты существует");
    stab.execute(
        "CREATE TABLE IF NOT EXISTS beats (id SERIAL PRIMARY KEY, title VARCHAR(50), producer VARCHAR(50), genre VARCHAR(50), bpm SMALLINT, key VARCHAR(50), audioFile VARCHAR(200), licenseType VARCHAR(100));");
    System.out.println("Таблица Биты существует");
  }

}
