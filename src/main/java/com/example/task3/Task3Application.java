package com.example.task3;

import com.example.task3.interfaces.LoginUserRepository;
import com.example.task3.interfaces.PostingRepository;
import com.example.task3.readers.ReadCsv;
import com.example.task3.service.LoginUserService;
import com.example.task3.service.PostingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task3Application {

    public static void main(String[] args){
        SpringApplication.run(Task3Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(LoginUserService loginUserService, PostingService postingService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                loginUserService.clear();
                postingService.clear();
                ReadCsv readCsv = new ReadCsv();
                readCsv.getLoginsFromCsv().forEach(x -> loginUserService.saveLoginUser(x));
                readCsv.getPostingsFromCsv().forEach(x -> postingService.savePosting(x));
            }
        };
    }
}
