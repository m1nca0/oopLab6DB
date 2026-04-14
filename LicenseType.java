public enum LicenseType {
  BASIC(29.99, "WAV"),
  PREMIUM(99.99, "WAV + STEMS"),
  EXCLUSIVE(499.99, "WAV + STEMS + TRACKOUT");

  private final double price;
  private final String format;

  LicenseType(double price, String format){
    this.price = price;
    this.format = format;
  }

  public double getPrice(){return price;}
  public String getFormat(){return format;}
}
