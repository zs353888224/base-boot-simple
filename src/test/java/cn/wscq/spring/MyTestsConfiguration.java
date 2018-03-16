package cn.wscq.spring;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsRestAssuredConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentationConfigurer;
import org.springframework.restdocs.templates.TemplateFormats;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:17
 */
@TestConfiguration
public class MyTestsConfiguration implements RestDocsRestAssuredConfigurationCustomizer {

    @Override
    public void customize(RestAssuredRestDocumentationConfigurer configurer) {
        configurer.snippets().withTemplateFormat(TemplateFormats.markdown());
    }
}
