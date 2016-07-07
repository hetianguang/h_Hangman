
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Tiger on 2016/7/6.
 */
public class HangmanTest {
    @Test
    public void should_get_attribute_when_the_word_is_apple(){
        Hangman hangman = new Hangman("apple");
        assertThat(hangman.count(),is(5));
        assertThat(hangman.showword(),is("apple"));
        assertThat(hangman.incompleter_word(),is("a___e"));
        assertThat(hangman.Times(),is(6));
    }
    @Test
    public void should_get_attribute_when_the_word_is_orange(){
        Hangman hangman = new Hangman("orange");
        assertThat(hangman.count(),is(6));
        assertThat(hangman.showword(),is("orange"));
        assertThat(hangman.incompleter_word(),is("o_a__e"));
        assertThat(hangman.Times(),is(7));
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_p(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        assertThat(hangman.exist_word(),is("aeioup"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.current_word(),is("app_e"));
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_e(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('e');
        assertThat(hangman.exist_word(),is("aeioup"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.current_word(),is("app_e"));
        assertThat(hangman.Game_Status(),is("you need to continue"));
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_l(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('l');
        assertThat(hangman.exist_word(),is("aeioul"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.current_word(),is("a__le"));
        assertThat(hangman.Game_Status(),is("you need to continue"));
    }

    @Test
    public void shuold_get_successful_status_when_guess_the_word_is_p_and_l(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('l');
        assertThat(hangman.exist_word(),is("aeioupl"));
        assertThat(hangman.Times(),is(4));
        assertThat(hangman.current_word(),is("apple"));
        assertThat(hangman.Game_Status(),is("you are successful"));
    }
    @Test
    public void shuold_get_failed_status(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('f');
        hangman.guess('k');
        hangman.guess('m');
        hangman.guess('c');
        hangman.guess('s');
        assertThat(hangman.exist_word(),is("aeioup"));
        assertThat(hangman.Times(),is(0));
        assertThat(hangman.current_word(),is("app_e"));
        assertThat(hangman.Game_Status(),is("you have failed"));
    }
}