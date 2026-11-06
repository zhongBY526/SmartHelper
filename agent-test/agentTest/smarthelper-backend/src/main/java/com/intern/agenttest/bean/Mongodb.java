package com.intern.agenttest.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Mongodb.COLLECTION_NAME)
public class Mongodb {
    /** 会话记忆集合名：唯一来源，Store 与实体注解都引用这里，避免多处硬编码不一致 */
    public static final String COLLECTION_NAME = "mongodb";
    @Id
    private ObjectId id;
    private String memoryId;
    private String content;
}
