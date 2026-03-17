package com.akirakay.xiaozhi;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.ClassPathDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.onnx.HuggingFaceTokenizer;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * @projectName: xiaozhi
 * @package: com.akirakay.xiaozhi
 * @className: RAGTest
 * @author: tzk
 * @description: TODO
 * @date: 3/17/26 23:04
 * @version: 1.0
 */
@SpringBootTest
public class RAGTest {

    @Autowired
    private ResourceUrlProvider mvcResourceUrlProvider;

    @Test
    public void testFileLoader() {
        Document document = ClassPathDocumentLoader.loadDocument("introduce.txt");
        System.out.println(document.metadata());
        System.out.println(document.text());
    }

    @Test
    public void testFileSplitterAndEmbeddingStore() {
        Document document = ClassPathDocumentLoader.loadDocument("introduce.txt");
        InMemoryEmbeddingStore<TextSegment> embeddingStore= new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor.ingest(document, embeddingStore);
        System.out.println(
                embeddingStore
        );
    }

    @Test
    public void testDocumentSplitter() {
        //使用ClassPathDocumentLoader读取指定目录下的知识库文
        //并使用默认的文档解析器对文档进行解析(TextDocumentParser)
        Document document = ClassPathDocumentLoader.loadDocument("introduce.txt");
        //为了简单起见，我们暂时使用基于内存的向量存储
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        //自定义文档分割器
        //按段落分割文档：每个片段包含不超过 300个token，并且有 30个token的重叠部分保证连贯性
        //注意：当段落长度总和小于设定的最大长度时，就不会有重叠的必要。
        DocumentByParagraphSplitter documentSplitter = new DocumentByParagraphSplitter(
                50,
                30,
                //token分词器：按token计算
                new HuggingFaceTokenizer());
        //按字符计算
        //DocumentByParagraphSplitter documentSplitter = newDocumentByParagraphSplitter(300, 30);
        EmbeddingStoreIngestor
                .builder()
                .embeddingStore(embeddingStore)
                .documentSplitter(documentSplitter)
                .build()
                .ingest(document);
        System.out.println(embeddingStore);
    }

    @Test
    public void testTokenCount() {
        String text = "这是一个示例文本，用于测试 token 长度的计算。";
        UserMessage userMessage = UserMessage.userMessage(text);
        //计算 token 长度
        HuggingFaceTokenizer tokenizer = new HuggingFaceTokenizer();
        int count = tokenizer.estimateTokenCountInMessage(userMessage);
        System.out.println("token长度：" + count);
    }
}
