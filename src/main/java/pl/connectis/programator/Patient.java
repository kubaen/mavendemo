package pl.connectis.programator;

import java.util.Objects;

public class Patient {

  private String name;
  private int yob;

  public Patient(String name, int yob) {
    this.name = name;
    this.yob = yob;
  }

  public Patient() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYob() {
    return yob;
  }

  public void setYob(int yob) {
    this.yob = yob;
  }
}