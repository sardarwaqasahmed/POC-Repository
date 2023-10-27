package com.zenith.poc.controller;

import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 *
 * @author Sajjad
 *
 */
@RestController
public class LoremController {

    private static final Logger LOG = getLogger(LoremController.class.getName());

    public static final String MESSAGE_KEY = "message";

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> logLorem() throws UnknownHostException {
        return prepareResponse();
    }

    private Map<String, String> prepareResponse() throws UnknownHostException {
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "lorem");
        LOG.info("Api Response with random id: {}, Api Response: {}", UUID.randomUUID().toString(), response);
        return response;
    }

}
