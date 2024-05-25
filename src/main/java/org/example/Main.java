package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;


@Data
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello world");
        logger.error("Test error");

        User user1 = new User("Vasyl", 33);
        user1.getName();
        System.out.println(user1.getName());

        String user = "{\"name\":\"Kate\",\"age\":\"22\"}";

        ObjectMapper mapper = new ObjectMapper();
        User userObjc =  mapper.readValue(user, User.class);
        System.out.println(userObjc);

        System.out.println(userObjc.getName());
        System.out.println(userObjc.getAge());


    }
}