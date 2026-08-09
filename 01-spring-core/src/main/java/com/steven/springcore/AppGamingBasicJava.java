package com.steven.springcore;

import com.steven.springcore.game.GameRunner;
import com.steven.springcore.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
