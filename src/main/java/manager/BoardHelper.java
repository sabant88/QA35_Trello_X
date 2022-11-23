package manager;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }



    public void initBoardCreation() {
        click(By.xpath("//p[.='Create']"));
        click(By.xpath("//span[.='Create board']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), board.getTitle());
    }

    public void scrollDownForm() {

        Actions actions = new Actions(wd);

        WebElement container = wd.findElement(By.cssSelector("[data-test-id=\"header-create-menu-popover\"]"));
        Rectangle rectangle = container.getRect();
        int x = rectangle.getX()+20;
        int y = rectangle.getY()+rectangle.getHeight()/2;
        actions.moveByOffset(x,y).click().perform();
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void returnToHomePage() {
        click(By.cssSelector("[aria-label='Back to home']"));
    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size()-1-recentlyViewedBoards();
    }

    public int recentlyViewedBoards(){
        return wd.findElements(By.cssSelector(".icon-lg.icon-clock")).size();
    }
}
