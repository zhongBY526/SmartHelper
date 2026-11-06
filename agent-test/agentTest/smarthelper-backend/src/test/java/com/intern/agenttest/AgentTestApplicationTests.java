package com.intern.agenttest;

import com.intern.agenttest.config.Assistant;
import dev.langchain4j.service.UserMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
class AgentTestApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private Assistant assistant;

    @Test
    void testmongodb() {
        String result = assistant.chat("1","今天的日期是？");

        System.out.println(result);

    }

}
