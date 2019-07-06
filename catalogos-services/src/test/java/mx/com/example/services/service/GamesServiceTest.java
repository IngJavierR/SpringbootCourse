package mx.com.example.services.service;

import mx.com.example.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GamesServiceTest extends BaseTest {

    @Autowired
    IGamesService gamesService;

    @Test
    public void shouldReturnChainComplete10() throws Exception {

        List<String> result = gamesService.fizzBuzz(10);

        Assert.assertEquals(10, result.size());
        Assert.assertEquals("Fizz", result.get(2));
        Assert.assertEquals("Buzz", result.get(4));
    }

    @Test
    public void shouldReturnChainComplete20() throws Exception {

        List<String> result = gamesService.fizzBuzz(20);

        Assert.assertEquals(20, result.size());
        Assert.assertEquals("Fizz", result.get(2));
        Assert.assertEquals("Buzz", result.get(4));
        Assert.assertEquals("FizzBuzz", result.get(14));
    }

    @Test
    public void shouldReturnOneElementWithEmptyWord() throws Exception {

        List<String> result = gamesService.fizzBuzz(0);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Empty", result.get(0));
    }

    @Test(expected = Exception.class)
    public void shouldReturnExceptionWithNegativeNumber() throws Exception {

        List<String> result = gamesService.fizzBuzz(-2);
    }
}
