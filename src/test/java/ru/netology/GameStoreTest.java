package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test  //Тест 1
    public void shouldAddGame() {
        //Проверяет наличие одной добавленной игры

        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test  //Тест 2
    public void shouldFindLastAddGame() {
        // Найти последнюю игру, которая была добавлена
        GameStore store = new GameStore();
        store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология2", "Аркады2");

        assertTrue(store.containsGame(game2));

    }

    @Test  //Тест 3
    public void shouldFindValueInAbsenceOfGame() { //Найти значение при отсутствии игры


        assertTrue(store.containsGame(null));
    }

    @Test  //Тест 4
    public void shouldFindTotalAmountTimePlayerSpentOnCertainGame() {// Найти полное количество времени,
        // потраченного игроком на определенную игру


        store.publishGame("Нетология2", "Аркады2");
        new Player("Super");

        store.addPlayTime("Super", 1);

        Integer expected = 3;
        Integer actual = store.addPlayTime("Super", 2);

        assertEquals(expected, actual);
    }

    @Test//Тест 5
    public void findAmountOfTimeIfNoOnePlayedInCatalog() {//Найти количество времени, если в каталоге никто не играл
        Integer expected = 0;
        Integer actual = store.addPlayTime("null", 0);

        assertEquals(expected, actual);

    }

    @Test//Тест 6
    public void findPlayerSpentMostTimePlayingInThisCatalog() {
        //Найти игрока, который играл в игру дольше всего

        store.publishGame("Нетология Баттл Онлайн", "Аркады");

        new Player("Игрок1");
        new Player("Игрок2");

        store.addPlayTime("Игрок1", 4);//Время каждого игрока, которые играли в данную игру
        store.addPlayTime("Игрок2", 6);


        String expected = "Игрок2";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test//Тест 7

    public void findOnePlayerWithMoreTimeIfSameAmountOfTime() {
        //Найти первого игрока с большим количеством времени, если есть одинаковое количество времени

        store.publishGame("Нетология Баттл Онлайн", "Аркады");
        new Player("Игрок1");
        new Player("Игрок2");
        new Player("Игрок3");
        new Player("Игрок4");
        new Player("Игрок5");

        store.addPlayTime("Игрок1", 4);//Время каждого игрока, которые играли в данную игру
        store.addPlayTime("Игрок2", 6);
        store.addPlayTime("Игрок3", 7);
        store.addPlayTime("Игрок4", 5);
        store.addPlayTime("Игрок5", 7);

        String expected = "Игрок3";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test//Тест 8
    public void shouldFindTotalAmountTimeAllPlayersSpentPlayingGamesInCatalog() {
        //Найти общее количество времени всех игроков, проведённого за играми этого каталога
        GameStore store = new GameStore();
        store.publishGame("Нетология Баттл Онлайн", "Аркады");
        new Player("Игрок1");
        new Player("Игрок2");
        new Player("Игрок3");
        new Player("Игрок4");
        new Player("Игрок5");

        store.addPlayTime("Игрок1", 4);//Время каждого игрока, которые играли в данную игру
        store.addPlayTime("Игрок2", 6);
        store.addPlayTime("Игрок3", 7);
        store.addPlayTime("Игрок4", 5);
        store.addPlayTime("Игрок5", 7);

        int expected = 29;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);


    }

    @Test
    public void shouldFindTotalAmountOfTimeNoOneHasPlayed() {
        //Найти общее(сумму)количество времени игры, если никто не играл в игру

        store.publishGame("Нетология Баттл Онлайн", "Аркады");

        int expected = 0;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
}



