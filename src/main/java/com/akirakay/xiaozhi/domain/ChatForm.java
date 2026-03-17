package com.akirakay.xiaozhi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.domain
 * @className: ChatForm
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 18:00
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "chat_messages")
public class ChatForm {

    @Id
    private String memoryId;

    private String message;

}