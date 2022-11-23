package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;

    @BeforeTest
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.navigate().refresh();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        userHelper = new UserHelper(wd);
        boardHelper = new BoardHelper(wd);

    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public void stop(){
        wd.quit();
    }
}
