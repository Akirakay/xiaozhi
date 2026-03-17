package com.akirakay.xiaozhi.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.assistant
 * @className: Assistant
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 10:47
 * @version: 1.0
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "openAiChatModel")
public interface Assistant {

    String chat(String userMessage);

}
