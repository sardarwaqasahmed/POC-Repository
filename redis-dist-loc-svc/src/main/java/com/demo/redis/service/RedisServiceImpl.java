package com.demo.redis.service;

import com.demo.redis.repository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * @author Waqas Ahmed
 * @date   7/8/2023
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisRepository redisRepository;

    @Override
    @Cacheable(value = "GET_BY_ID", key = "#id")
    public String getById(Integer id) {
        RLock lock = redissonClient.getLock("update-stock-lock");
        try {
            boolean isLocked = lock.tryLock(1, 10, TimeUnit.SECONDS);
            if(isLocked){
                Thread.sleep(6000);
                // Do you processing
                log.info("redis lock acquired!!!!! now you can do whatever you want to do");

                if(lock.isLocked()){
                    lock.unlock();
                    log.info("Redis lock released successfully");
                }
            } else {
                log.warn("Some other process has already acquired the lock!!!!!!");
                // Give user friendly message
            }

        } catch (InterruptedException e) {
            log.error("exception while acquiring redis lock", e);
        }

        return redisRepository.getById(id);
    }
}
