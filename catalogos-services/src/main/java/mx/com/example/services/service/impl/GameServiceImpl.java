package mx.com.example.services.service.impl;

import mx.com.example.services.service.IGamesService;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GameServiceImpl implements IGamesService {

    @Override
    public List<String> fizzBuzz(int numberOfElements) throws Exception {

        if(numberOfElements < 0) {
            throw new Exception("Error");
        }
        if(numberOfElements == 0) {
            return Arrays.asList("Empty");
        }

        return IntStream.rangeClosed(1, numberOfElements)
                .mapToObj(i -> i % 5 == 0 ? (i % 3 == 0 ? "FizzBuzz" : "Buzz") : (i % 3 == 0 ? "Fizz" : ""+i))
                .collect(Collectors.toList());
    }
}
