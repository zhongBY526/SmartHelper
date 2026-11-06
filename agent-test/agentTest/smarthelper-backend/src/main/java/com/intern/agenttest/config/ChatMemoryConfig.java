package com.intern.agenttest.config;

import com.intern.agenttest.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 会话记忆配置：@AiService 会自动装配容器里的 ChatMemoryProvider，
 * 按 memoryId 隔离不同会话，每个会话保留最近 20 条消息，并持久化到 MongoDB。
 */
@Configuration
public class ChatMemoryConfig {

    private final MongoChatMemoryStore mongoChatMemoryStore;

    public ChatMemoryConfig(MongoChatMemoryStore mongoChatMemoryStore) {
        this.mongoChatMemoryStore = mongoChatMemoryStore;
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
