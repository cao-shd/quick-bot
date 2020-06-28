package xbot.quickbot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
// 开启Swagger2的自动配置
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    //配置docket以配置Swagger具体参数
    public Docket docket(Environment env) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())// 设置分组
                .groupName("security")
                // 配置是否启用Swagger 如果是 false 在浏览器将无法访问
                // 仅在开发和测试环境开启 swagger 页面访问 其他环境不可访问
                .enable(env.acceptsProfiles(Profiles.of("dev", "test")))
                .select()
                // 配置要扫描的类根路径
                .apis(RequestHandlerSelectors.basePackage("xbot.quickbot.security.controller"))
                // 配置如何通过path过滤,即这里只扫描请求以 /api/v1/public/ 开头的接口
                .paths(PathSelectors.ant("/api/v1/public/**"))
                .build();
    }

    /**
     * 配置文档信息
     *
     * @return 配置文档信息
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("cao.shd", "http://xxx.xxx.com/aaa", "cao-shd@outlook.com");
        return new ApiInfo(
                // 标题
                "快速启动项目",
                // 描述
                "用于快速启动一个后台项目",
                // 版本
                "v1.0",
                // 服务条款
                "http://terms.service.url/服务条款",
                // 联系人信息
                contact,
                // 许可
                "Apache 2.0 许可",
                // 许可链接
                "许可链接",
                // 扩展
                new ArrayList<>()
        );
    }

}