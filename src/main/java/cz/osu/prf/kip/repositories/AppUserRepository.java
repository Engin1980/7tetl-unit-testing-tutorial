package cz.osu.prf.kip.repositories;
import cz.osu.prf.kip.model.AppUser;
import java.util.List;

public interface AppUserRepository {
  void addUser(AppUser user);

  void deleteUser(String userName);

  List<AppUser> getUsers();

  boolean isUserNameTaken(String userName);
}
