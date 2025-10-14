package cz.osu.prf.kip.services;

import cz.osu.prf.kip.model.AppUser;
import cz.osu.prf.kip.repositories.AppUserRepository;
import cz.osu.prf.kip.validators.ArgumentAsserts;

import java.util.Optional;

public class AppUserService {
  private final AppUserRepository appUserRepository;

  public AppUserService(AppUserRepository appUserRepository) {
    ArgumentAsserts.isNotNull(appUserRepository, "appUserRepository");
    this.appUserRepository = appUserRepository;
  }

  Optional<AppUser> tryGetUserByCredentials(String username, String password) {
    Optional<AppUser> ret = appUserRepository.getUsers().stream()
        .filter(q -> q.getUserName().equals(username) && q.getPassword().equals(password))
        .findFirst();
    return ret;
  }

  public void createUser(String username, String password) {
    AppUser appUser = new AppUser(username, password, false);
    if (appUserRepository.isUserNameTaken(username)) {
      throw new IllegalArgumentException("Username is already taken");
    }
    appUserRepository.addUser(appUser);
  }
}
