package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.SeparateChatMemoryAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: SeparateChatMemoryAssistantWithMongoDBTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:00
 * @version: 1.0
 */

@SpringBootTest
public class SeparateChatMemoryAssistantWithMongoDBTest {

    @Autowired
    private SeparateChatMemoryAssistant assistant;


    @Test
    public void testChatMemoryAssistantDemo() {

        String resp1 = assistant.chat("memoryId", "我是 akira");
        System.out.println(resp1);


        String resp2 = assistant.chat("memoryId", "我是谁");
        System.out.println(resp2);

        String resp3 = assistant.chat("newMemoryId", "我是谁");
        System.out.println(resp3);

    }

}
