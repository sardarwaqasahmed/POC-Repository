package com.swa.demo.service;

import java.util.List;

/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 23 Nov 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
public interface MailerService {
    public void send(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String message);
}
