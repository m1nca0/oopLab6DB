import java.time.LocalDateTime;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;

public class Beat {
  private int id;
  private String title;
  private List<Producer> producer;
  private List<Genre> genre;
  private int bpm;
  private String key;
  private LocalDateTime uploadDate;
  private AudioFile audioFile;

  public Beat(int id,
      String title,
      List<Producer> producer,
      List<Genre> genre,
      int bpm,
      String key,
      LocalDateTime uploadDate,
      AudioFile audioFile) {
    this.id = id;
    this.title = title;
    this.producer = producer;
    this.genre = genre;
    this.bpm = bpm;
    this.key = key;
    this.uploadDate = uploadDate;
    this.audioFile = audioFile;
  }
}
