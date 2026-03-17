package com.akirakay.xiaozhi.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;


@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatMemoryAssistant {

//    @SystemMessage(value = "你是我的好助手，你擅长粤语，请你用粤语回答我的问题")
//    @SystemMessage(value = "你是我的好助手，你擅长陕西话，请你用陕西话回答我的问题")
    @SystemMessage(fromResource = "prompt.md")
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);


    @UserMessage(value = "你喜欢用上海话+emoji回答问题，{{var}}")
    String chat2(@MemoryId String memoryId, @V("var") String userMessage);

}
