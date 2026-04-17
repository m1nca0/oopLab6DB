import javax.sound.sampled.AudioFileFormat;

public class Beat {
  private int id;
  private String title;
  private String userNameProducer;
  private Genre genre;
  private int bpm;
  private String key;
  private String audioFile;
  private LicenseType licenseType = null;

  public Beat(int id,
      String title,
      String userNameProducer,
      Genre genre,
      int bpm,
      String key,
      String audioFile) {
    this.id = id;
    this.title = title;
    this.userNameProducer = userNameProducer;
    this.genre = genre;
    this.bpm = bpm;
    this.key = key;
    this.audioFile = audioFile;
  }
}
