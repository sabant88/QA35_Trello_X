import model.Board;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @BeforeTest
    public void preCond() {
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().withPassword("Miledi88").withEmail("sabant88@mail.ru"));
        }
    }

    @Test
    public void boardCreationSuccess1() {

      //  Board board = new Board().withTitle("QA-35");

        Board board = Board.builder().title("QA-35").build();

        int boardCountBefore = app.getBoardHelper().getBoardCount();

        app.getBoardHelper().initBoardCreation();
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().scrollDownForm();
        app.getBoardHelper().pause(2000);
        app.getBoardHelper().submitBoardCreation();
        app.getBoardHelper().pause(2000);
        app.getBoardHelper().returnToHomePage();


        int boardCountAfter = app.getBoardHelper().getBoardCount();


        Assert.assertEquals(boardCountAfter, boardCountBefore + 1);


    }
}
