package org.thoughtworkers.guessgame;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

public class AnswerFactory {
    private final Random random = new Random(new Date().getTime());

    public Answer build() {
        List<Integer> answerNumbers = newArrayList();
        for (int i = 0; i < 4; i++) {
            while (true) {
                Integer number = generateRandomNumber();
                if (answerNumbers.indexOf(number) < 0) {
                    answerNumbers.add(number);
                    break;
                }
            }
        }

        String answerString = "";
        for (Integer answerNumber : answerNumbers) {
            answerString += answerNumber;
        }
        return new Answer(answerString);
    }

    private Integer generateRandomNumber() {
        return Math.abs(random.nextInt() % 10);
    }
}
