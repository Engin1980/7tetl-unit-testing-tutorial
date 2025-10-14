package cz.osu.prf.kip.model;

import cz.osu.prf.kip.validators.ArgumentAsserts;

public class AppUser {
  private final String userName;
  private final String password;
  private final boolean isAdmin;

  public AppUser(String userName, String password, boolean isAdmin) {
    ArgumentAsserts.isNotNullOrWhitespace(userName, "userName");
    ArgumentAsserts.isNotNull(password, "password");

    this.userName = userName;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public boolean isAdmin() {
    return isAdmin;
  }
}
