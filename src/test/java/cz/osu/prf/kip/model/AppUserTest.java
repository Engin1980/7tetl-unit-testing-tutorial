package cz.osu.prf.kip.model;

import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class AppUserTest {

  @Property
  public void ctorInitializingCorrectly(@ForAll String userName, @ForAll String password, @ForAll boolean isAdmin) {
    Assume.that(userName != null && !userName.trim().isEmpty());
    Assume.that(password != null);

    AppUser appUser = new AppUser(userName, password, isAdmin);

    Assertions.assertEquals(userName, appUser.getUserName());
    Assertions.assertEquals(password, appUser.getPassword());
    Assertions.assertEquals(isAdmin, appUser.isAdmin());
  }

}
