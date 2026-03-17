package com.akirakay.xiaozhi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.domain
 * @className: ChatMessages
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 15:50
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "chat_messages")
public class ChatMessages {

    @Id
    private ObjectId id;

    private String memoryId;

    private String messages;

}
