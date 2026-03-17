package com.akirakay.xiaozhi;

import com.akirakay.xiaozhi.domain.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: MongoDBTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 15:52
 * @version: 1.0
 */
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testInsertMsg() {
//        mongoTemplate.insert(new ChatMessages(11L, "who r u"));
//        ChatMessages chatMessages = new ChatMessages();
//        chatMessages.setMessages("akira");
//        mongoTemplate.insert(chatMessages);
    }
    @Test
    public void testFindMsg() {
        Criteria criteria = Criteria.where("_id").is(11L);
        Query query = new Query(criteria);
        List<ChatMessages> chatMessages = mongoTemplate.find(query, ChatMessages.class);
        System.out.println(chatMessages.get(0));
    }

}
