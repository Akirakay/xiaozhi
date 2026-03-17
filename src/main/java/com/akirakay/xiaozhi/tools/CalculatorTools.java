package com.akirakay.xiaozhi.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.tools
 * @className: CalculatorTools
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 18:35
 * @version: 1.0
 */
@Component
public class CalculatorTools {

    @Tool(name = "add_operation", value = "对参数num1和num2求和")
    public Integer sum(
            @ToolMemoryId String memoryId,
            @P(value = "num1", required = true) Integer num1,
            @P(value = "num2", required = true) Integer num2
    ) {
        System.out.printf("memoryId %s 调用sum\n", memoryId);
        return num1 + num2;
    }

    @Tool
    public Double squareRoot(Double root) {
        System.out.println("调用squareRoot");
        return Math.sqrt(root);
    }
}
