package com.intern.agenttest.store;

import com.intern.agenttest.bean.Mongodb;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    /** 与 Mongodb 实体字段名保持一致的查询键 */
    private static final String MEMORY_ID_FIELD = "memoryId";
    private static final String CONTENT_FIELD = "content";

    private final MongoTemplate mongoTemplate;

    public MongoChatMemoryStore(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        // 不显式传 collectionName，以 @Document(collection = Mongodb.COLLECTION_NAME) 为准
        Mongodb chatMemory = mongoTemplate.findOne(
                Query.query(Criteria.where(MEMORY_ID_FIELD).is(memoryId)), Mongodb.class);
        // 首次会话在集合里还没有文档，findOne 返回 null，必须先判空再取 content
        if (chatMemory == null || chatMemory.getContent() == null) {
            return new ArrayList<>();
        }
        return ChatMessageDeserializer.messagesFromJson(chatMemory.getContent());
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        Query query = Query.query(Criteria.where(MEMORY_ID_FIELD).is(memoryId));
        Update update = new Update().set(CONTENT_FIELD, ChatMessageSerializer.messagesToJson(messages));
        // upsert：文档不存在时按查询条件新建，memoryId 会自动写入
        mongoTemplate.upsert(query, update, Mongodb.class);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        mongoTemplate.remove(Query.query(Criteria.where(MEMORY_ID_FIELD).is(memoryId)), Mongodb.class);
    }
}
