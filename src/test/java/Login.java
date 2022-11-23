import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeTest
    public void preCond() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logOut();
        }
    }


    @Test
    public void loginPositive() {

      //  User user = new User().withEmail("sabant88@mail.ru").withPassword("Miledi88");
        User user = User.builder()
                .email("sabant88@mail.ru")
                .password("Miledi88")
                .build();

        app.getUserHelper().initLogin();
        app.getUserHelper().pause(2000);
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);


        Assert.assertTrue(app.getUserHelper().isLogged());


    }
}
