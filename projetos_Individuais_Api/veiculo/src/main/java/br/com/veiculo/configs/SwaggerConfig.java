package br.com.veiculo.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(name="Bearer Auth", type=SecuritySchemeType.HTTP, bearerFormat="JWT", scheme="bearer")
public class SwaggerConfig {

    @Value("${prop.swagger.enabled}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(devUrl);
        server.setDescription("Servidor de desenvolvimento");

        Contact contact = new Contact();
        contact.setEmail("viniciuscassiano2105lv@gmail.com");
        contact.setName("Vinicius");

        License license = new License();
        license.setName("Apache 2.0");
        license.setUrl("http://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info();
        info.setTitle("Veículo");
        info.setVersion("1.0.0");
        info.setDescription("Gerenciamento de Veículos");
        info.setContact(contact);
        info.setLicense(license);
        info.termsOfService("http://swagger.io/terms/");


        return new OpenAPI().info(info).servers(List.of(server));


    }
}