package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.SeparateChatMemoryAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: SeparateChatMemoryAssistantTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:00
 * @version: 1.0
 */

@SpringBootTest
public class SeparateChatMemoryAssistantTest {

    @Autowired
    private SeparateChatMemoryAssistant assistant;


    @Test
    public void testChatMemoryAssistantDemo() {

        String resp1 = assistant.chat("memoryId", "我是 akira");
        System.out.println(resp1);

        //你好，akira。
        //需要我帮你做什么？

        String resp2 = assistant.chat("memoryId", "我是谁");
        System.out.println(resp2);

        //你刚才告诉我，你是 **akira**。
        //
        //如果你想做一个更“哲学”的版本，比如“我是谁、我从哪里来、要到哪里去”这种问题，也可以跟我说你在想什么，我可以陪你一起梳理和思考。

        String resp3 = assistant.chat("newMemoryId", "我是谁");
        System.out.println(resp3);

        //我不知道你现实中的身份或姓名，只能根据你在对话中提供的信息来了解你。
        //
        //从当前对话里，我只知道：
        //- 你在用中文和我沟通
        //- 你提出了“我是谁”这个问题
        //
        //如果你是想从“哲学”或“自我认知”的角度探讨“我是谁”，我可以陪你一起梳理，比如：
        //- 从角色角度（学生、程序员、家长等）
        //- 从兴趣与价值观角度
        //- 从经历与目标角度
        //
        //你是更想问技术层面的（比如账号、隐私）、还是想聊“自我认知/人生意义”这一类？
    }

}
