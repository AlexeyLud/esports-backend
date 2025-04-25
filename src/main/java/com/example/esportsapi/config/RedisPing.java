package com.example.esportsapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisPing {

    @Bean
    public CommandLineRunner pingRedis(StringRedisTemplate redisTemplate) {
        return args -> {
            try {
                String pong = redisTemplate.getConnectionFactory().getConnection().ping();
                System.out.println("✅ Redis ответил: " + pong);
            } catch (Exception e) {
                System.err.println("❌ Ошибка при подключении к Redis: " + e.getMessage());
            }
        };
    }
}