package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.Assistant;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: ChatMemoryTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:00
 * @version: 1.0
 */

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    @Autowired
    private OpenAiChatModel model;
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testDefaultMemoryDemo() {
        String resp1 = assistant.chat("我是akira");
        System.out.println(resp1);
        //你好，akira！👋
        //有什么想一起聊的或需要我帮忙的吗？比如编程、学习、翻译、写作，或者随便聊聊都可以。

        String resp2 = assistant.chat("我是谁？");
        System.out.println(resp2);
        //我不知道你具体是谁，也无法根据这段对话识别你的真实身份或个人信息。
        //在这个环境里，我只知道你是一个向我提问的用户，有可能是想测试我，或者只是随口一问。
    }

    @Test
    public void testCombineMsgMemoryDemo() {
        UserMessage msg1 = new UserMessage("我是akira");
        ChatResponse resp = model.chat(msg1);
        System.out.println(resp.aiMessage().text());
        //你好，akira！
        //有什么想一起做的吗？可以是写代码、调 bug、查资料、聊技术方向，或者其他任何问题。

        //第二轮对话
        UserMessage msg2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse resp2 = model.chat(Arrays.asList(msg1, resp.aiMessage(), msg2));
        System.out.println(resp2.aiMessage().text());
        //我只知道你在这边用的名字是 “akira”，除此之外我不了解你的真实身份、背景或任何个人信息。
        //
        //每次对话对我来说都是新的，我不会自动记住跨会话的个人信息，除非是在同一轮对话里你告诉我、并且基于这些信息来继续聊。
        //
        //如果你愿意，你可以简单介绍一下自己：
        //- 你现在在做什么（学生 / 上班 / 自己折腾项目）
        //- 你对什么方向感兴趣（比如前端、后端、算法、游戏开发、硬件等）
        //
        //我就可以更有针对性地帮你。
    }

    @Test
    public void testAssistantMemoryDemo() {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(new MessageWindowChatMemory.Builder().maxMessages(10).build())
                .build();

        String resp1 = assistant.chat("我是 akira");
        System.out.println(resp1);

        //你好，akira！
        //
        //有什么想一起解决或讨论的编程 / 技术问题吗？

        String resp2 = assistant.chat("我是谁");
        System.out.println(resp2);

        //从你在对话里提供的信息来看，你是：
        //
        //- 名字/昵称：akira
        //
        //除此之外，我并不了解你的真实身份、背景或其他个人信息，除非你自己告诉我。
        //如果你是在哲学意义上问“我是谁”，也可以告诉我你在想些什么，我可以陪你一起聊聊这个问题。
    }

}
