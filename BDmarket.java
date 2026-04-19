import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  private static List<Customer> customers = new ArrayList<>();
  private static List<Beat> beats = new ArrayList<>();

  public static void connectionBDmarket() throws ClassNotFoundException, SQLException {
    market = null;
    Class.forName("org.postgresql.Driver");
    market = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beat_market", "mihailvasilev", "095147");
    System.out.println("БД подключена!");
  }

  public static void newTable() throws SQLException {
    stab = market.createStatement();
    stab.execute(
        "CREATE TABLE IF NOT EXISTS producers (id SERIAL PRIMARY KEY, username VARCHAR(50), email VARCHAR(50), password VARCHAR(50), registrationDate DATE, balance DECIMAL(10,2), rating DECIMAL(3,2));");
    System.out.println("Таблица Битмейкеры существует");
    stab.execute(
        "CREATE TABLE IF NOT EXISTS customers (id SERIAL PRIMARY KEY, username VARCHAR(50), email VARCHAR(50), password VARCHAR(50), registrationDate DATE, balance DECIMAL(10,2), artistName VARCHAR(50));");
    System.out.println("Таблица Артисты существует");
    stab.execute(
        "CREATE TABLE IF NOT EXISTS beats (id SERIAL PRIMARY KEY, title VARCHAR(50), producer VARCHAR(50), genre VARCHAR(50), bpm SMALLINT, key VARCHAR(50), audioFile VARCHAR(200), licenseType VARCHAR(100));");
    System.out.println("Таблица Биты существует");
  }

  public static void writeProducers(
      String username,
      String email,
      String password,
      LocalDateTime registrationDate,
      double balance,
      double rating) throws SQLException {
    stab.executeUpdate(String.format(
        "INSERT INTO producers(username, email, password, registrationDate, balance, rating) VALUES(%s, %s, %s, %s, %.2f, %.2f)",
        username, email, password, registrationDate, balance, rating));
    System.out.println("Продюссер " + username + " успешно добавлен в базу данных!");
  }

  public static void writeCustomers(
      String username,
      String email,
      String password,
      LocalDateTime registrationDate,
      double balance,
      String artistName) throws SQLException {
    stab.executeUpdate(String.format(
        "INSERT INTO customers(username, email, password, registrationDate, balance, artistName) VALUES(%s, %s, %s, %s, %.2f, %s)",
        username, email, password, registrationDate, balance, artistName));
    System.out.println("Артист " + username + " успешно добавлен в базу данных!");
  }

  public static void writeBeats(
      String title,
      Producer producer,
      Genre genre,
      int bpm,
      String key,
      String audioFile,
      LicenseType licenseType) throws SQLException {
    stab.executeUpdate(String.format(
        "INSERT INTO beats(title, producer, genre, bpm, key, audioFile, licenseType) VALUES(%s, %s, %s, %i, %s, %s, %s)",
        title, producer.getUsername(), genre.getName(), bpm, key, audioFile, licenseType.getFormat()));
    System.out.println("Бит " + title + " успешно добавлен в базу данных!");
  }

  public static void writeDB() throws SQLException {
    stab.execute("INSERT INTO producers (username, email, password, registrationDate, balance, rating) " +
        "VALUES ('Palaze', 'palaze@beats.com', 'pass123', '2024-01-15', 1500.50, 4.95);");
    stab.execute("INSERT INTO producers (username, email, password, registrationDate, balance, rating) " +
        "VALUES ('MurdaBeatz', 'murda@producer.com', 'topsecret', '2023-11-20', 12500.00, 5.00);");
    System.out.println("Таблица Битмейкеры заполнена");

    stab.execute("INSERT INTO customers (username, email, password, registrationDate, balance, artistName) " +
        "VALUES ('young_star', 'star@mail.com', 'qwerty', '2024-03-01', 300.00, 'Lil Star');");
    stab.execute("INSERT INTO customers (username, email, password, registrationDate, balance, artistName) " +
        "VALUES ('og_rapper', 'og@label.com', '123456', '2024-02-10', 50.75, 'OG Flow');");
    System.out.println("Таблица Артисты заполнена");

    stab.execute("INSERT INTO beats (title, producer, genre, bpm, key, audioFile, licenseType) " +
        "VALUES ('Midnight Vibe', 'Palaze', 'Trap', 140, 'Cm', '/audio/beats/midnight.mp3', 'Lease');");
    stab.execute("INSERT INTO beats (title, producer, genre, bpm, key, audioFile, licenseType) " +
        "VALUES ('Street Anthem', 'MurdaBeatz', 'Hip-Hop', 95, 'Am', '/audio/beats/street.mp3', 'Exclusive');");
    System.out.println("Таблица Биты заполнена");
  }

  public static void readBeatDB() throws SQLException {
    result = stab.executeQuery("SELECT * FROM beats;");
    while (result.next()) {
      Beat beat = new Beat(
          result.getInt("id"),
          result.getString("title"),
          result.getString("producer"),
          Genre.HIPHOP,
          result.getInt("bpm"),
          result.getString("key"),
          result.getString("audiofile"));
      beats.add(beat);
    }
    System.out.println("Таблица битов выгружена");
    for (int i = 0; i < beats.size(); i++) {
      System.out.println(beats.get(i).toString());
    }
  }

  public static void readProducersDB() throws SQLException {
    result = stab.executeQuery("SELECT * FROM producers;");
    while (result.next()) {
      Producer producer = new Producer(
          result.getInt("id"),
          result.getString("username"),
          result.getString("email"),
          result.getString("password"),
          result.getObject("registrationDate", LocalDate.class),
          result.getDouble("balance"),
          result.getDouble("rating"));
      producers.add(producer);
    }
    System.out.println("Таблица продюсеров выгружена");
    for (int i = 0; i < producers.size(); i++) {
      System.out.println(producers.get(i).toString());
    }
  }

  public static void readCustomersDB() throws SQLException {
    result = stab.executeQuery("SELECT * FROM customers;");
    while (result.next()) {
      Customer customer = new Customer(
          result.getInt("id"),
          result.getString("username"),
          result.getString("email"),
          result.getString("password"),
          result.getObject("registrationDate", LocalDate.class),
          result.getDouble("balance"),
          result.getString("artistName"));
      customers.add(customer);
    }
    System.out.println("Таблица артистов выгружена");
    for (int i = 0; i < customers.size(); i++) {
      System.out.println(customers.get(i).toString());
    }
  }

  public static void writeDefBeats() throws SQLException {
    stab.executeUpdate(
        "INSERT INTO beats(title, producer, genre, bpm, key, audioFile, licenseType) VALUES('trapchik', 'miha', 'trap', '145', 'C#-minor', 'etc', 'WAW')");
    System.out.println("Таблица заполнена");
  }
  public static void closeDB() throws SQLException {
        if (result != null) result.close();
        if (stab != null) stab.close();
        if (market != null) market.close();
        System.out.println("Соединения закрыты");
    }
}
