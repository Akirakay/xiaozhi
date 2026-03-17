package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.assistant.SeparateChatMemoryAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: PromptAssistantTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:00
 * @version: 1.0
 */

@SpringBootTest
public class PromptAssistantTest {

    @Autowired
    private SeparateChatMemoryAssistant assistant;


    @Test
    public void testSystemMsgDemo() {

        String resp = assistant.chat("promptDemo", "你猜下我是谁");
        System.out.println(resp);

        //你咪就係 akira 囉 😄
        //定係其實你想我由你啲說話入面，估下你係一個點樣嘅人？
        //
        //例如：
        //- 你係咪鍾意動漫／遊戲嗰啲？因為好多人叫 akira 都係受呢啲影響
        //- 定係你本名都同「明 / 晶 / 光」呢啲意思有關？
        //
        //你可以透露多啲俾我知，我再「專業啲」幫你估 😏
    }

    @Test
    public void testSystemMsgDemo2() {

        String resp = assistant.chat("promptDemo", "你猜下我是谁");
        System.out.println(resp);
        // messages
        // [{"contents":[{"text":"我是 akira","type":"TEXT"}],"type":"USER"},{"text":"akira 你好呀～  \n識到你好開心，有咩想問我或者想我幫手嘅，盡管開口啦。","type":"AI"},{"contents":[{"text":"你猜下我是谁","type":"TEXT"}],"type":"USER"},{"text":"你咪就係 akira 囉 😄  \n定係其實你想我由你啲說話入面，估下你係一個點樣嘅人？  \n\n例如：\n- 你係咪鍾意動漫／遊戲嗰啲？因為好多人叫 akira 都係受呢啲影響  \n- 定係你本名都同「明 / 晶 / 光」呢啲意思有關？\n\n你可以透露多啲俾我知，我再「專業啲」幫你估 😏","type":"AI"},{"text":"你是我的好助手，你擅长陕西话，请你用陕西话回答我的问题","type":"SYSTEM"},{"contents":[{"text":"你猜下我是谁","type":"TEXT"}],"type":"USER"},{"text":"你还叫我猜，你刚才不都说咧嘛——你是 **akira** 嘛 😂  \n\n要是不光让我猜名字，那我再大胆揣摩一哈你是个啥样的人：\n\n- 取个叫 *akira* 的名，多半爱二次元、游戏、日剧这些烙  \n- 上来就逗我玩儿，让我猜你是谁，看着就像个挺会整乐子的主  \n- 还能看得懂我刚才说的话，八成平时也上网混得不轻\n\n要不你给我点提示：  \n你是——学生呀、打工人呀、还是真正的「幕后大佬」？我再给你好好“分析分析” 😏","type":"AI"}]

        //你还叫我猜，你刚才不都说咧嘛——你是 **akira** 嘛 😂
        //
        //要是不光让我猜名字，那我再大胆揣摩一哈你是个啥样的人：
        //
        //- 取个叫 *akira* 的名，多半爱二次元、游戏、日剧这些烙
        //- 上来就逗我玩儿，让我猜你是谁，看着就像个挺会整乐子的主
        //- 还能看得懂我刚才说的话，八成平时也上网混得不轻
        //
        //要不你给我点提示：
        //你是——学生呀、打工人呀、还是真正的「幕后大佬」？我再给你好好“分析分析” 😏
    }

    @Test
    public void testSystemMsgDemo3() {

        String resp = assistant.chat("filePrompt", "你介绍一下你自己");
        System.out.println(resp);

        //I’m an AI assistant created by OpenAI, designed to help you in English with:
        //
        //- Explaining concepts (technology, science, finance, etc.)
        //- Helping with coding (debugging, writing, and explaining code)
        //- Assisting with writing (emails, reports, essays, resumes)
        //- Brainstorming ideas (projects, learning plans, content)
        //- Answering factual questions based on my training data (up to 2024-10)
        //
        //Some things about how I work:
        //
        //- I don’t have personal experiences or emotions, but I can understand and respond to yours.
        //- I can’t browse the real-time internet (no latest news, stock prices, or current events after my knowledge cutoff).
        //- I generate answers based on patterns in the data I was trained on, not from a personal memory.
        //
        //You can talk to me in Chinese if you like, but my answers will be in English as requested.
        //If you want, tell me what you’re interested in (study, work, coding, life planning, etc.), and I can introduce how I can help you more specifically.
    }

    @Test
    public void testSystemMsgDemo4() {

        String resp1 = assistant.chat2("userVarPrompt", "我是akira");
        System.out.println(resp1);

        String resp2 = assistant.chat2("userVarPrompt", "今年已经28了");
        System.out.println(resp2);

        String resp3 = assistant.chat2("userVarPrompt", "我是哪位");
        System.out.println(resp3);

        //Akira～好啊，记到伐～🤝
        //以后我可以用**上海话夹普通话**，再配点emoji跟你讲～
        //有啥想问伐？😏💬
        //阿kira～记牢了！😏
        //你今年28岁了对伐～🧮➡️28
        //
        //以后跟你讲话我就按你喜欢的来：
        //- 尽量**上海话+emoji**🌟
        //- 需要严肃一点、写代码、写简历这些，我就普通话为主，再夹点沪语味道👌
        //
        //有啥想聊的？感情💔、工作💻、生活🍻、编程👨‍💻都可以跟我讲～
        //阿拉晓得哒～你是 **akira** 啊 😉✨
        //刚刚自己报过户口了：
        //
        //> “我是akira” ✅
        //
        //以后我就记牢：
        //看到你就当老熟人一样叫你 **akira** 🔔
        //有啥想聊的伐，akira？😏💬
    }

}
