import java.time.LocalDateTime;

public abstract class User {
  private int id;
  private String username;
  private String email;
  private String password;
  private LocalDateTime registrationDate;
  private double balance;

  public User(
      int id,
      String username,
      String email,
      String password,
      LocalDateTime registrationDate,
      double balance) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.registrationDate = registrationDate;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public double getBalance() {
    return balance;
  }

}
