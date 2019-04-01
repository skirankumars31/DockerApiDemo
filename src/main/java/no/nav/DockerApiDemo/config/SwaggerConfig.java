package no.nav.DockerApiDemo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.nio.file.Path;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("no.nav.DockerApiDemo"))
                .paths(PathSelectors.regex("/rest.*"))
                .build();
    }
}
