package org.thoughtworkers.guessgame;

import java.util.List;

import static com.google.common.primitives.Bytes.asList;
import static java.lang.String.format;

public class Answer {
    private String correctAnswer;

    public Answer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Response guess(String trial) {
        int countOfA = 0, countOfB = 0, countOfError = 0;
        List<Byte> charsInCorrectAnswer = asList(correctAnswer.getBytes());
        for (Byte aCharInCorrectAnswer : charsInCorrectAnswer) {
            if (positionOf(trial, aCharInCorrectAnswer) < 0) {
                countOfError += 1;
                continue;
            }
            if(positionOf(correctAnswer, aCharInCorrectAnswer) == positionOf(trial, aCharInCorrectAnswer)) {
                countOfA += 1;
            } else {
                countOfB += 1;
            }
        }
        return new Response(countOfA, countOfB, countOfError);
    }

    @Override
    public String toString() {
        return correctAnswer;
    }

    private int positionOf(String string, Byte aChar) {
        List<Byte> charsInTrial = asList(string.getBytes());
        return charsInTrial.indexOf(aChar);
    }
}
