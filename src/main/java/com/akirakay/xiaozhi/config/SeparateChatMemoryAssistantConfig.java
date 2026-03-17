package com.akirakay.xiaozhi.config;

import com.akirakay.xiaozhi.store.MongoDBChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.config
 * @className: SeparateChatMemoryAssistantConfig
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:26
 * @version: 1.0
 */
@Configuration
public class SeparateChatMemoryAssistantConfig {

    @Autowired
    private MongoDBChatMemoryStore mongoDBChatMemoryStore;

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
//                .chatMemoryStore(new InMemoryChatMemoryStore()) // 底层使用的是map 更适合并发环境 需要记忆持久化的话 也是实现chatMemoryStore做自定义存储
                .chatMemoryStore(mongoDBChatMemoryStore)
                .build();
    }
}
