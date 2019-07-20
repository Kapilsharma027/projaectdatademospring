package pacakge.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(apiInfo());
	}

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("THE project-data  API'S")
            .description("Below listed are the api's used for project-data application.")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("No terms.")
            .version("1.0.0")
            .contact(new Contact("Kapil sharma", "will give angular url here", "kapil123jpr@gmail.com"))
            .build();
    }

}
