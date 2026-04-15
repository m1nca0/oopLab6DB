public enum Genre {
  HIPHOP("Hip-Hop", "Хип-хоп"),
  LOFI("Lo-Fi", "Хип-хоп"),
  TRAP("Trap", "Хип-хоп"),
  EDM("EDM", "Хип-хоп"),
  DNB("Drum'n Bass", "Хип-хоп"),
  HOUSE("House", "Хип-хоп");

  private final String name;
  private final String description;

  Genre(String name, String description){
    this.name = name;
    this.description = description;
  }

  public String getName() { return name; }
  public String getDescription() { return description; }
}
