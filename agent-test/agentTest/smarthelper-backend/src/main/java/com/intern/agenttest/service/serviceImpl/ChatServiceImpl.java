package com.intern.agenttest.service.serviceImpl;

import com.intern.agenttest.config.Assistant;
import com.intern.agenttest.dto.ChatRequest;
import com.intern.agenttest.service.ChatService;
import dev.langchain4j.data.message.AiMessage;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private static final String DEFAULT_MEMORY_ID = "default";

    /** 注入 @AiService 生成的代理 Bean：已自动装配 ChatMemoryProvider，按 memoryId 读写会话记忆 */
    private final Assistant assistant;

    public ChatServiceImpl(Assistant assistant) {
        this.assistant = assistant;
    }


    @Override
    public String getResponse(String memoryId, String message) {

        String aiMessage=assistant.chat(memoryId,message);
        System.out.println(aiMessage);
        return aiMessage;
    }

}
