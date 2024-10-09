package br.com.projeto.imperialflix.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {

	@Autowired
	public JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;

	@Value("${spring.mail.host}")
	private String emailServeHost;

	@Value("${spring.mail.port}")
	private Integer emailServePort;

	@Value("${spring.mail.password}")
	private String emailPassword;

	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername(emailRemetente);
		mailSender.setHost(emailServeHost);
		mailSender.setPort(emailServePort);
		mailSender.setPassword(emailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		return mailSender;
	}

	public String writerTeste() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("diogoportelladantas1234@gmail.com");
		message.setSubject("hmmmm..pensando aqui");
		message.setText("veganismo vibes e afins e talz" + dateTime.format(dateForm));

		try {
			javaMailSender.send(message);
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			return "Erro ao enviar o Email" + e.getMessage();
		}
	}

	public String writerTeste2() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Teste email2");
			helper.setTo("diogoportelladantas1234@gmail.com");

			String emailText = "<h1>Faça sentido</h1>" + "<p>Diogo é meu amigo!</p>" + "<p>Diogo é meu amigo!</p>"
					+ "<p>na relíquia do Julio Braz " + dateTime.format(dateForm) + "</p>" + "<br>";
			helper.setText(emailText, true);
			javaMailSender.send(message);
			return "email enviado com sucesso!";
		} catch (MessagingException e) {
			return "Erro ao enviar o e-mail" + e.getMessage();
		}

	}
}
