package sg.edu.nuss.iss.d13workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class FunctionTest {

    private Logger logger = Logger.getLogger(FunctionTest.class.getName());

    @Autowired
    private ObjectMapper objectMapper;
    
    private Path workingDir;

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "c:/data");
        Path file = this.workingDir.resolve("58f4d22d");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
    }

    @Test
    public void saveContact() throws Exception {
        MultiValueMap<String, String> payload = new LinkedMultiValueMap<String, String>();
        payload.add("name", "Darren");
        payload.add("email", "darren@gmail.com");
        payload.add("phone", "12345678");

        logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));
    }


}
