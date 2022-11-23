package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));

    }

    public boolean isLogged() {

        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }

    public void login(User user) {
        initLogin();
        fillLoginForm(user);
        submitLogin();
        pause(2000);
    }


    public void initLogin() {
        click(By.xpath("//a[@href='/login']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#user"), user.getEmail());
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }
}
