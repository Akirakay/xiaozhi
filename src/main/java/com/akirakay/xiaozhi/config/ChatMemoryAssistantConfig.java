package com.akirakay.xiaozhi.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.config
 * @className: ChatMemoryAssistantConfig
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:26
 * @version: 1.0
 */
@Configuration
public class ChatMemoryAssistantConfig {

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
