package com.swa.demo.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 23 Nov 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
@Service
public class MailerServiceImpl implements MailerService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MailerServiceImpl.class);

    @Autowired
    private MailSender mailSender;
    
	@Override
	public void send(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String message) {
        if (!CollectionUtils.isEmpty(to)) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to.toArray(new String[] {}));
            simpleMailMessage.setCc(cc.toArray(new String[] {}));
            simpleMailMessage.setBcc(bcc.toArray(new String[] {}));
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);

            LOGGER.debug("Sending Mail For '{}'", simpleMailMessage.toString());

            mailSender.send(simpleMailMessage);
        } else {
            LOGGER.error("Minimum One Recipient Is Mandatory In The 'to' List.");
        }
	}
}
