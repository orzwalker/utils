package org.example;

import org.example.aspectLog.RankService;
import org.example.aspectLog.SaveRank;
import org.example.aspectLog.UpdateRank;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author walker
 * @since 2022/11/21 11:21
 */
@SpringBootApplication
public class UtilsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UtilsApplication.class, args);
    }

    @Resource
    private RankService rankService;

    @Override
    public void run(String... args) {

    }
}
