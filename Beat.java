import javax.sound.sampled.AudioFileFormat;

public class Beat {
  private int id;
  private String title;
  private Producer producer;
  private Genre genre;
  private int bpm;
  private String key;
  private String audioFile;
  private LicenseType licenseType;

  public Beat(int id,
      String title,
      Producer producer,
      Genre genre,
      int bpm,
      String key,
      String audioFile) {
    this.id = id;
    this.title = title;
    this.producer = producer;
    this.genre = genre;
    this.bpm = bpm;
    this.key = key;
    this.audioFile = audioFile;
  }
}
