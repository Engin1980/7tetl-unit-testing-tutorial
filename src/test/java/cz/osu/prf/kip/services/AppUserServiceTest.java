package cz.osu.prf.kip.services;

import cz.osu.prf.kip.model.AppUser;
import cz.osu.prf.kip.repositories.AppUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

  //@Mock
  private AppUserRepository appUserRepository;

  private AppUserService appUserService = null;

  private List<AppUser> users;


  @BeforeEach
  public void setup() {
    users = new ArrayList<>();
    users.add(new AppUser("marek", "1234", true));
    users.add(new AppUser("tereza", "5678", false));
    users.add(new AppUser("petr", "7890", false));

    appUserRepository = org.mockito.Mockito.mock(AppUserRepository.class, invocation -> {
      throw new UnsupportedOperationException(
          "Method without stub invoked: AppUserRepository." + invocation.getMethod().getName() + "(...)"
      );
    });

    // alternative way:
    //    org.mockito.Mockito.when(appUserRepository.getUsers())
    //        .thenReturn(users);
    org.mockito.Mockito
        .lenient()
        .doReturn(users)
        .when(appUserRepository).getUsers();

    org.mockito.Mockito
        .lenient()
        .doNothing()
        .when(appUserRepository).addUser(org.mockito.Mockito.any(AppUser.class));

    org.mockito.Mockito
        .lenient()
        .doAnswer(invocation -> {
          String userName = invocation.getArgument(0);
          boolean ret = users.stream().anyMatch(u -> u.getUserName().equals(userName));
          return ret;
        })
        .when(appUserRepository).isUserNameTaken(org.mockito.Mockito.any(String.class));

    this.appUserService = new AppUserService(appUserRepository);
  }

  @Test
  void tryGetUserByCredentials_success() {
    Optional<AppUser> user = appUserService.tryGetUserByCredentials("marek", "1234");
    Assertions.assertTrue(user.isPresent());
  }

  @Test
  void createUser_success() {
    appUserService.createUser("john", "1234");
  }

  @ParameterizedTest
  @CsvSource({
      "honza, 1234, False",
      "marek, 4543, True",
      "tereza, 1234, True",
      "petr, 2172, True",
      "jonatan, 1141, False"
  })
  void createUser_multiple(String username, String password, boolean shouldFail) {
    if (shouldFail) {
      Assertions.assertThrows(IllegalArgumentException.class, () -> appUserService.createUser(username, password));
    } else {
      appUserService.createUser(username, password);
    }
  }
}
