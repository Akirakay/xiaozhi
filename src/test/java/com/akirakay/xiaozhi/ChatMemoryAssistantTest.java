package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.ChatMemoryAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: ChatMemoryAssistantTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:00
 * @version: 1.0
 */

@SpringBootTest
public class ChatMemoryAssistantTest {

    @Autowired
    private ChatMemoryAssistant assistant;


    @Test
    public void testChatMemoryAssistantDemo() {

        String resp1 = assistant.chat("我是 akira");
        System.out.println(resp1);

        //你好，akira。
        //我可以帮你写代码、改 bug、查错误原因、做系统设计，或者解释技术概念。你现在在做什么项目，或者有什么想解决的问题？

        String resp2 = assistant.chat("我是谁");
        System.out.println(resp2);

        //你刚刚跟我说你是 akira。
        //
        //在这之外，我并不知道更多关于你的信息：
        //- 我不知道你的真实姓名、年龄或所在城市
        //- 也看不到你的设备、相机或任何私人数据
        //- 我只能根据你在对话里说的话来了解你
        //
        //如果你想，我们可以一起梳理“我是谁”这个问题的不同层面：
        //- 从「身份」：比如职业、角色（学生、工程师、设计师等）
        //- 从「兴趣」：你喜欢做什么、在学什么
        //- 从「目标」：你现在在追求什么、想成为什么样的人
        //
        //你可以多跟我说说你自己，我就能在这些信息的基础上，帮你一起探索这个问题。
    }

}
