import java.time.LocalDateTime;

public abstract class User {
  private String id;
  private String username;
  private String email;
  private String password;
  private LocalDateTime registrationDate;
  private double balance;

  public User(
      String id,
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

  private String getId() {
    return id;
  }

  private String getUsername() {
    return username;
  }

  private String getEmail() {
    return email;
  }

  private String getPassword() {
    return password;
  }

  private LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  private double getBalance() {
    return balance;
  }

}
