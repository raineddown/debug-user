package com.design.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class UserApplicationTests {

    @Test
    void contextLoads() {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        LocalDateTime now = LocalDateTime.now();
        String formatTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd mm:ss"));
        System.out.println(formatTime);
    }

}
