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
 * @className: XiaoZhiAgentConfig
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:26
 * @version: 1.0
 */
@Configuration
public class XiaoZhiAgentConfig {

    @Autowired
    private MongoDBChatMemoryStore mongoDBChatMemoryStore;

    @Bean
    public ChatMemoryProvider xiaozhiAgentProvider() {
        return memoryId -> MessageWindowChatMemory.builder().chatMemoryStore(mongoDBChatMemoryStore).id(memoryId).maxMessages(20).build();
    }
}
