import java.time.LocalDateTime;
import java.util.List;

public class Producer extends User {
  private List<Beat> uploadedBeats;
  private double rating;

  public Producer(
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
      this.rating = rating;
  }

  private double getRating() {return rating;};
}
