package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.model.SimpleModel;

import java.io.File;

public class ParsingJsonTest {

    @Test
    void parsingJsonTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/simple.json");
        SimpleModel simple = mapper.readValue(file, SimpleModel.class);
        Assertions.assertEquals("Peter", simple.getName());
        Assertions.assertEquals(18, simple.getAge());
        Assertions.assertEquals("Football", simple.getHobby().getSport());
        Assertions.assertEquals("Art", simple.getHobby().getCreation());
        Assertions.assertFalse(simple.isStudent());


    }
}
