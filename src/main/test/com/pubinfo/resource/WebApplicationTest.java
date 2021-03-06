//package com.pubinfo.resource;
//
//import com.pubinfo.resource.service.common.K8sApiService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//import io.github.swagger2markup.GroupBy;
//import io.github.swagger2markup.Language;
//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
//import lombok.SneakyThrows;
//import org.apache.commons.lang.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.URL;
//import java.nio.file.Paths;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(SpringRunner.class)
//public class WebApplicationTest {
//  @Autowired
//  K8sApiService k8sApiService;
//  @Test
//  public   void test3() {
//    String cookies ="envId=2;aaa=fff";
//    String key ="envId";
//    String value=null;
//    if (StringUtils.isNotBlank(cookies)) {
//      String[]  stringEnumeration = cookies.split(";");
//      if (stringEnumeration.length > 0) {
//        for (int i = 0; i < stringEnumeration.length; i++) {
//          String str = stringEnumeration[i];
//          if(str.contains(key)){
//            value =str.substring(key.length()+1 );
//          }
//        }
//      }
//
//    }
//    System.out.println(value);
//  }
//  public   String getStr(String cookies,String key){
//    String value=null;
//    if (StringUtils.isNotBlank(cookies)) {
//      String[]  stringEnumeration = cookies.split(";");
//      if (stringEnumeration.length > 0) {
//        for (int i = 0; i < stringEnumeration.length; i++) {
//          String str = stringEnumeration[i];
//          if(str.contains(key)){
//            value =str.substring(key.length()+1 );
//          }
//        }
//      }
//
//    }
//    return value;
//  }
//  @Test
//  public void testYaml() {
//    String yaml = k8sApiService.getK8sConfig();
//    System.out.println("yaml:" + yaml);
//    String json = convertYamlToJson(yaml);
//    System.out.println("json:" + json);
//  }
//
//  @SneakyThrows
//  String convertYamlToJson(String yaml) {
//    ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
//    Object obj = null;
//    try {
//      obj = yamlReader.readValue(yaml, Object.class);
//    } catch (JsonProcessingException e) {
//      e.printStackTrace();
//    }
//
//    ObjectMapper jsonWriter = new ObjectMapper();
//    return jsonWriter.writeValueAsString(obj);
//  }
//
//  /**
//   * ??????AsciiDocs????????????,????????????????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateAsciiDocsToFile() throws Exception {
//    //    ??????Ascii????????????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://localhost:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFile(Paths.get("src/main/webapp/swagger-ui/generated/all"));
//  }
//
//  /**
//   * ??????AsciiDocs????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateAsciiDocs() throws Exception {
//    //    ??????Ascii??????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://127.0.0.1:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFolder(Paths.get("./docs/asciidoc/generated"));
//  }
//
//  /**
//   * ??????Markdown????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateMarkdownDocs() throws Exception {
//    //    ??????Markdown??????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://localhost:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFolder(Paths.get("src/docs/asciidoc/generated/all"));
//  }
//
//  /**
//   * ??????Markdown????????????,????????????????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateMarkdownDocsToFile() throws Exception {
//    //    ??????Markdown????????????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://localhost:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFile(Paths.get("src/docs/asciidoc/generated/all"));
//  }
//
//  /**
//   * ??????Confluence????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateConfluenceDocs() throws Exception {
//    //    ??????Confluence???????????????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://localhost:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFolder(Paths.get("./docs/confluence/generated"));
//  }
//
//  /**
//   * ??????Markdown????????????,????????????????????????
//   *
//   * @throws Exception
//   */
//  @Test
//  public void generateHtmlDocsToFile() throws Exception {
//    //    ??????Markdown????????????
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//        .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//        .withOutputLanguage(Language.ZH)
//        .withPathsGroupedBy(GroupBy.TAGS)
//        .withGeneratedExamples()
//        .withoutInlineSchema()
//        .build();
//
//    Swagger2MarkupConverter.from(new URL("http://localhost:9000/v2/api-docs"))
//        .withConfig(config)
//        .build()
//        .toFile(Paths.get("src/docs/asciidoc/generated/all"));
//  }
//
//}
