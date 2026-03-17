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
public class ToolsTest {

    @Autowired
    private SeparateChatMemoryAssistant assistant;


    @Test
    public void testNoToolsDemo() {

        String resp1 = assistant.chat("tools", "你帮我算下1+1等于多少，34434234234325开根号是多少");
        System.out.println(resp1);
        //1 + 1 = 2
        //
        //现在算 \( \sqrt{34434234234325} \)：
        //
        //\(185\,494^2 = 34\,434\,299\,004\,036\)
        //\(185\,495^2 = 34\,434\,668\,994\,025\)
        //
        //而
        //\(34\,434\,234\,234\,325\) 介于这两个平方之间：
        //\(34\,434\,299\,004\,036 > 34\,434\,234\,234\,325 > 34\,434\,168\,? \)
        //
        //更精确计算得到：
        //\[
        //\sqrt{34\,434\,234\,234\,325} \approx 185\,494.7
        //\]
        //
        //所以
        //\[
        //\sqrt{34434234234325} \approx 185\,495
        //\]
        //（精确到整数是 185495，保留一位小数约为 185494.7）
    }

    @Test
    public void testToolsDemo() {

        String resp1 = assistant.chat("tools", "你帮我算下1+1等于多少，34434234234325开根号是多少");
        System.out.println(resp1);
        //调用sum
        //调用squareRoot
        //1 + 1 = 2
        //
        //\(\sqrt{34434234234325} \approx 5\,868\,069.037965129\)
    }

    @Test
    public void testToolsMemoryIdDemo() {

        String resp1 = assistant.chat("tools-annotation", "你帮我算下1+1等于多少，34434234234325开根号是多少");
        System.out.println(resp1);
        //memoryId tools-annotation 调用sum
        //调用squareRoot
        //1 + 1 = 2
        //
        //√34434234234325 ≈ 5,868,069.037965129
    }

}
