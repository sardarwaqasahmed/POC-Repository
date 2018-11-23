package com.swa.demo.EmailSender;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swa.demo.service.MailerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderApplicationTests {

	@Autowired
	private MailerService mailer;
	
	@Test
	public void testSendEmail() {
		List<String> bcc = new ArrayList<>();
		List<String> cc = new ArrayList<>();
		List<String> to = new ArrayList<>();
		to.add("qasim@gmail.com");
		String from = "waqas@gmail.com";
		String message  = "Testing mail sending";
		String subject = "Hello world!";
		mailer.send(from, to, cc, bcc, subject, message);
	}

}
