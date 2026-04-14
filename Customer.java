import java.time.LocalDateTime;

public class Customer extends User {
  private String artistName;
  private double rating;

  public Customer(
      String id,
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
      this.rating = rating;
  }
  
  private String getArtistName() {return artistName;};
  private double getRating() {return rating;};
}
