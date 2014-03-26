package org.thoughtworkers.guessgame;

import com.google.common.base.Function;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static com.google.common.primitives.Bytes.asList;
import static java.lang.String.format;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class AnswerFactoryTest {
    @Test
    public void should_generate_guess_without_duplication() throws Exception {
        AnswerFactory answerFactory = new AnswerFactory();
        Answer answer = answerFactory.build();

        String correctAnswer = answer.toString();
        assertThat(correctAnswer.length(), equalTo(4));
        List<Byte> charsInCorrectAnswer = asList(correctAnswer.getBytes());

        assertNoDuplication(charsInCorrectAnswer);
    }

    @Test
    public void should_generate_random_guesses() throws Exception {
        final AnswerFactory answerFactory = new AnswerFactory();
        Function<Integer, Answer> toGuess = new Function<Integer, Answer>() {
            @Override
            public Answer apply(Integer integer) {
                return answerFactory.build();
            }
        };
        Function<Answer, String> toAnswer = new Function<Answer, String>() {
            @Override
            public String apply(Answer guess) {
                return guess.toString();
            }
        };

        List<String> allGuessAnswers = transform(transform(newArrayList(1, 2, 3, 4, 5), toGuess), toAnswer);
        assertNoDuplication(allGuessAnswers);
        for (String guessAnswer : allGuessAnswers) {
            List<Byte> charsInAnswer = asList(guessAnswer.getBytes());
            assertNoDuplication(charsInAnswer);
        }
    }

    private void assertNoDuplication(List<?> list) {
        for (Object item : list) {
            int firstIndex = list.indexOf(item);
            int lastIndex = list.lastIndexOf(item);
            if(firstIndex != lastIndex) {
                fail(format("Item [%s] appears at position %d and %d", item, firstIndex, lastIndex));
            }
        }
    }
}
