import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      BDmarket.connectionBDmarket();
      BDmarket.newTable();
      // BDmarket.writeBeats(null, null, null, 0, null, null, null);
      // BDmarket.writeDefBeats();
      
    }
}