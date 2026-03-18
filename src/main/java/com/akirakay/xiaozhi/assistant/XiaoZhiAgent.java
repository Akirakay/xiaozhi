package com.akirakay.xiaozhi.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;


@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
//        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemoryProvider = "xiaozhiAgentProvider",
        tools = "appointmentTools",
        contentRetriever = "xiaozhiContentRetriever"
)
public interface XiaoZhiAgent {

//    @SystemMessage(value = "你是我的好助手，你擅长粤语，请你用粤语回答我的问题")
//    @SystemMessage(value = "你是我的好助手，你擅长陕西话，请你用陕西话回答我的问题")
    @SystemMessage(fromResource = "xiaozhi-prompt-template.md")
    Flux<String> chat(@MemoryId String memoryId, @UserMessage String userMessage);

}
