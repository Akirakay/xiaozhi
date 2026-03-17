package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: AIServicesTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 10:50
 * @version: 1.0
 */
@SpringBootTest
public class AIServicesTest {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistantDemo() {
        Assistant assistant = AiServices.create(Assistant.class, chatLanguageModel);
        String resp = assistant.chat("介绍一下你自己");
        System.out.println(resp);
    }

    @Test
    public void testAssistantAnnotationDemo() {
        String resp = assistant.chat("介绍一下你自己");
        System.out.println(resp);
    }
}
