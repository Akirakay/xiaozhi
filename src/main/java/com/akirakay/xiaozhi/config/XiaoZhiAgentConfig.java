package com.akirakay.xiaozhi.config;

import com.akirakay.xiaozhi.store.MongoDBChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.ClassPathDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi.config
 * @className: XiaoZhiAgentConfig
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 14:26
 * @version: 1.0
 */
@Configuration
public class XiaoZhiAgentConfig {

    @Autowired
    private MongoDBChatMemoryStore mongoDBChatMemoryStore;

    @Bean
    public ChatMemoryProvider xiaozhiAgentProvider() {
        return memoryId -> MessageWindowChatMemory.builder().chatMemoryStore(mongoDBChatMemoryStore).id(memoryId).maxMessages(20).build();
    }


    @Bean
    public ContentRetriever xiaozhiContentRetriever() {
        Document document = ClassPathDocumentLoader.loadDocument("introduce.txt");

        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        EmbeddingStoreIngestor.ingest(document, embeddingStore);
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
