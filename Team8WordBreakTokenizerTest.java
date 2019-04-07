package edu.uci.ics.cs221.analysis.wordbreak;

import edu.uci.ics.cs221.analysis.WordBreakTokenizer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Team8WordBreakTokenizerTest {


	//tests if the output is lower cased and stop words are removed
    @Test
    public void test1() {
        String text = "THISiswhATItoldyourI'llFRIendandI'llgoonlinecontactcan'tforget";
        List<String> expected = Arrays.asList("old", "i'll", "friend", "i'll","go","online","contact","can't","forget");

        WordBreakTokenizer tokenizer = new WordBreakTokenizer();

        assertEquals(expected, tokenizer.tokenize(text));

    }

    //tests the program can handle strings like "whatevergreen" and string consists of more than one frequently used words
    @Test
    public void test2(){
    	String text = "informationinforTHOUGHTFULLYcopyrightwhatevercontactablewhatevergreen";
    	List<String> expected = Arrays.asList("information", "thoughtfully", "copyright", "whatever", "contact", "able","whatever", "green" );
    	
        WordBreakTokenizer tokenizer = new WordBreakTokenizer();

        assertEquals(expected, tokenizer.tokenize(text));
    }


    //tests the exception part functions well and lower case the string
    @Test(expected = IllegalArgumentException.class)
    public void test3(){
    	String text = "$reLLL(  ghn)iog*";
        //throw exception
    	WordBreakTokenizer tokenizer = new WordBreakTokenizer();
        tokenizer.tokenize(text);

        //assertThrows(IllegalArgumentException.class, () -> tokenizer.tokenize(text));

    }

}
