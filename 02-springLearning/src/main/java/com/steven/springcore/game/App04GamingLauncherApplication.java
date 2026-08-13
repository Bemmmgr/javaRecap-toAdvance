package com.steven.springcore.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.steven.springcore.game")
public class App04GamingLauncherApplication {
    /*  automatically done by spring
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        System.out.println("Current component game: " + game);
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }   */

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(App04GamingLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
