package org.thoughtworkers.guessgame;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AnswerTest {
    @Test
    public void should_return_xAxB_for_valid_inputs() throws Exception {
        Answer answer = new Answer("1234");

        assertThat(answer.guess("0000").toString(), equalTo("0A0B"));
        assertThat(answer.guess("1000").toString(), equalTo("1A0B"));
        assertThat(answer.guess("4321").toString(), equalTo("0A4B"));

        Response guessResult = answer.guess("1243");
        assertThat(guessResult.toString(), equalTo("2A2B"));
        assertThat(guessResult.isSuccess(), is(true));
        assertThat(answer.guess("1234").toString(), equalTo("4A0B"));
    }
}
