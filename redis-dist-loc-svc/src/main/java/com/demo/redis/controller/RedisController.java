package com.demo.redis.controller;
/*
 * @author Waqas Ahmed
 * @date   7/8/2023
 */

import com.demo.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("cache/{id}")
    public ResponseEntity<String> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(redisService.getById(id));
    }

    @PostMapping("cache")
    public ResponseEntity<Object> add(@RequestBody Object data) {
        return null;
    }

    @DeleteMapping("cache/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        return null;
    }
}
