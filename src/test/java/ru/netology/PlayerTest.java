package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 3);

        int expected = 6;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfGamesGenreDifferent() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Call of Duty: Modern Warfare", "Шутер");
        Game game3 = store.publishGame("Counter-Strike 1.6", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 2);
        player.installGame(game3);
        player.play(game3, 3);

        int expected = 5;
        int actual = player.sumGenre("Шутер");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenre0Hours() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Duty: Modern Warfare", "Шутер");
        Game game2 = store.publishGame("Counter-Strike 1.6", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 0);
        player.installGame(game2);
        player.play(game1, 1);

        int expected = 1;
        int actual = player.sumGenre("Шутер");
        assertEquals(expected, actual);
    }


    @Test
    public void shouldSumHoursIfGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 3;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMostPlayedGameByGenre1Genre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 8);
        player.installGame(game2);
        player.play(game2, 3);

        assertEquals(game1, player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldReturnMostPlayedGameByGenre2Genre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл", "Аркады");
        Game game3 = store.publishGame("Call of Duty: Modern Warfare", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 8);
        player.installGame(game2);
        player.play(game2, 3);
        player.installGame(game3);
        player.play(game3, 10);

        assertEquals(game1, player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldReturnNullIfGenreNotUsed() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty: Modern Warfare", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        assertNull(player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldSumGenreGamePlayedTwice() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty: Modern Warfare", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 6;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);
    }
}