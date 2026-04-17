import java.time.LocalDate;
import java.util.List;

public class Producer extends User {
  private List<Beat> uploadedBeats;
  private double rating;

  public Producer(
      int id,
      String username,
      String email,
      String password,
      LocalDate registrationDate,
      double balance,
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

  private double getRating() {
    return rating;
  };
}
