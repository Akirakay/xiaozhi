package com.akirakay.xiaozhi;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: LLMTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 09:21
 * @version: 1.0
 */
@SpringBootTest
public class LLMTest {

    @Autowired
    private OpenAiChatModel model;

    @Test
    public void testDemo() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String resp = model.chat("介绍一下你自己!");
        System.out.println(resp);
    }


    @Test
    public void testDemo2() {
        String resp = model.chat("你是谁？");
        System.out.println(resp);
    }
}
