package org.thoughtworkers.guessgame;

public class Game {
    private Answer correctAnswer;

    public Game(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String start() {
        return "Welcome to the game!";
    }

    public Response step(String trial) {
        return correctAnswer.guess(trial);
    }
}
