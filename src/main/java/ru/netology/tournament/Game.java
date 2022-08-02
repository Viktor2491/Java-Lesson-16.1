package ru.netology.tournament;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();


    public List<Player> findAll() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player_1 = findByName(playerName1);
        Player player_2 = findByName(playerName2);

        if (player_1 == null) {
            throw new NotRegisteredException(
                    "Игрок с именем" + playerName1 + "не зарегистрирован."
            );
        }
        if (player_2 == null) {
            throw new NotRegisteredException(
                    "Игрок с именем" + playerName2 + "не зарегистрирован."
            );
        }

        if (player_1.getStrength() == player_2.getStrength()) {
            return 0;
        }
        if (player_1.getStrength() > player_2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}


