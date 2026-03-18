package com.akirakay.xiaozhi.controller;

import com.akirakay.xiaozhi.assistant.XiaoZhiAgent;
import com.akirakay.xiaozhi.domain.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "小智医生")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {
    @Autowired
    private XiaoZhiAgent xiaozhiAgent;

//    @Operation(summary = "问诊")
//    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
//    public String chat(@RequestBody ChatForm chatForm) {
//        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
//    }

    @Operation(summary = "问诊")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}