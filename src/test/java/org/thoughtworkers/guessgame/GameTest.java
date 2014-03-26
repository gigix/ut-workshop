package org.thoughtworkers.guessgame;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GameTest {
    @Test
    public void should_start_with_a_guess() throws Exception {
        Game game = new Game(new Answer("1234"));
        String welcome = game.start();
        assertThat(welcome, equalTo("Welcome to the game!"));
    }

    @Test
    public void should_return_guess_result_for_each_step() throws Exception {
        Game game = new Game(new Answer("1234"));
        game.start();

        assertThat(game.step("4321").toString(), equalTo("0A4B"));
        assertThat(game.step("1243").toString(), equalTo("2A2B"));
    }
}
