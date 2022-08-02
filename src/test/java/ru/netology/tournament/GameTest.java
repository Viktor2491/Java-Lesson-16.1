package ru.netology.tournament;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Игрок1", 10);
    Player player2 = new Player(2, "Игрок2", 15);
    Player player3 = new Player(3, "Игрок3", 5);
    Player player4 = new Player(4, "Игрок4", 10);

//Сделал не активным, т.к мы проверяем зарегистрирован ли пользователь в рамках раунда

//    @BeforeEach
//    public void setUp() {
//        game.register(player1);
//        game.register(player2);
//        game.register(player3);
//        game.register(player4);
//    }

    @Test
    //найти всех игроков
    public void shouldFindRegisteredPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        List<Player> expected = List.of(player1, player2, player3, player4);
        List<Player> actual = game.findAll();
        assertEquals(expected, actual);
    }

    @Test
    //найти игрока по имени
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Player expected = player3;
        Player actual = game.findByName("Игрок3");
        assertEquals(expected, actual);
    }

    @Test
    //не искать игрока по несуществующему имени
    public void shouldNotFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Player expected = null;
        Player actual = game.findByName("Бобр");
        assertEquals(expected, actual);
    }

    @Test
    //победитель 1-ый
    public void shouldWinTheFirstOne() {
        game.register(player1);
        game.register(player3);
        int expected = 1;
        int actual = game.round(player1.getName(), player3.getName());
        assertEquals(expected, actual);
    }


    @Test
    //победитель 2-ой
    public void shouldWinTheSecondOne() {
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round(player1.getName(), player2.getName());
        assertEquals(expected, actual);
    }

    @Test
    //ничья
    public void shouldBeDraw() {
        game.register(player1);
        game.register(player4);
        int expected = 0;
        int actual = game.round(player1.getName(), player4.getName());
        assertEquals(expected, actual);
    }

    @Test
    //1-ый незареистрированный игрок
    public void shouldThrowExceptionWhenPlayer1Unreg() {
        game.register(player1);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player2.getName(), player4.getName());
        });
    }

    @Test
    // два незареистрированных игрока
    public void shouldThrowExceptionWhen2PlayersUnreg() {
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player4.getName());
        });
    }

    @Test
    //2-ой незареистрированный игрок
    public void shouldThrowExceptionWhenPlayer2Unreg() {
        game.register(player1);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player3.getName());
        });
    }

}

