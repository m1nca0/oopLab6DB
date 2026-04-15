import java.time.LocalDateTime;
import java.util.List;

public class Customer extends User {
  private String artistName;
  private List<Beat> purchasedBeats;

  public Customer(
      int id,
      String username,
      String email,
      String password,
      LocalDateTime registrationDate,
      double balance,
      String artistName,
      double rating) {
    super(
        id,
        username,
        email,
        password,
        registrationDate,
        balance);
      this.artistName = artistName;      
  }
  
  private String getArtistName() {return artistName;};
}
