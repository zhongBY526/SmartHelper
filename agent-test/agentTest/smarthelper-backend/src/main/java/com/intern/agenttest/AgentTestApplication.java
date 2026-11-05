package com.intern.agenttest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AgentTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentTestApplication.class, args);

        log.info("启动springapplication");
    }

}
