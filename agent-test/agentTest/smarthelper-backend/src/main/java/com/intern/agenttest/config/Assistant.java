package com.intern.agenttest.config;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;


import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;
@AiService(wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider")
public interface Assistant {
    //    @SystemMessage("使用中文回复我的问题，今天是{{current_date}}")
    @SystemMessage (fromResource = "user-message-template.txt")
    String chat(@MemoryId String memoryId,@UserMessage String message );
}
