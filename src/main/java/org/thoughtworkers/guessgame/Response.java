package org.thoughtworkers.guessgame;

import static java.lang.String.format;

public class Response {
    private int countOfA;
    private int countOfB;
    private int countOfError;

    public Response(int countOfA, int countOfB, int countOfError) {
        this.countOfA = countOfA;
        this.countOfB = countOfB;
        this.countOfError = countOfError;
    }

    @Override
    public String toString() {
        return format("%dA%dB", countOfA, countOfB);
    }

    public Boolean isSuccess() {
        return countOfError == 0;
    }
}
