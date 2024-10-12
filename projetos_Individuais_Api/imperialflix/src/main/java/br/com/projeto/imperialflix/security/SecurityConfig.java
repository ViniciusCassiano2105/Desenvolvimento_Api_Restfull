package br.com.projeto.imperialflix.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//anotação de configuração, permite que ela seja reconhecida como a class que habilita o serviçoweb
@Configuration
//classe inicializa o sistema de WebSecurity
@EnableWebSecurity
//todos os métodos ativam a segurança global no prepost
@EnableMethodSecurity(prePostEnabled = true)

public class SecurityConfig {


}
