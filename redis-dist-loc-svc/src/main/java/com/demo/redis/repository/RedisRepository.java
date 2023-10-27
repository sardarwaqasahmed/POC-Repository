package com.demo.redis.repository;
/*
 * @author Waqas Ahmed
 * @date   7/8/2023
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisRepository {

    public String getById(Integer id) {
        log.info("repository hooked!!!!!!!!");
        return "Hello World!!!";
    }

}
