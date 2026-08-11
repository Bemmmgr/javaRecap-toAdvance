package com.steven.springcore.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {
    @Override
    public void down() {
        System.out.println("Pacman down");
    }

    public void up() {
        System.out.println("Pacman up");
    }

    public void left() {
        System.out.println("Pacman left");
    }

    public void right() {
        System.out.println("Pacman right");
    }
}
