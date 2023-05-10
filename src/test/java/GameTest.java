import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Миша", 85);
    Player player2 = new Player(22, "Карина", 48);
    Player player3 = new Player(333, "Дима", 85);

    @Test
    public void secondPlayerWin() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int actual = game.round("Карина", "Дима");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWin() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int actual = game.round("Миша", "Карина");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenDraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int actual = game.round("Миша", "Дима");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotRegistred() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Олег", "Дима"));
    }

    @Test
    public void whenSecondPlayerNotRegistred() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Миша", "Таня"));
    }

    @Test
    public void whenBothPlayerNotRegistred() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Саша", "Петя"));
    }
}