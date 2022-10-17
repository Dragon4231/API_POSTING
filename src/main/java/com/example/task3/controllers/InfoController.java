package com.example.task3.controllers;

import com.example.task3.data.LoginUser;
import com.example.task3.data.Posting;
import com.example.task3.interfaces.PostingRepository;
import com.example.task3.service.PostingService;
import lombok.Builder;
import lombok.extern.java.Log;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.task3.service.LoginUserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InfoController {

    @Autowired
    PostingService postingService;

    @GetMapping("/findByYear/{year}")
    public List<Posting> getPostingByYear(@PathVariable int year, @RequestParam(value = "isAuthority", required = false) boolean isAuthority){
        return postingService.getByYear(year,isAuthority);
    }

    @GetMapping("/findByMonth/{month}")
    public List<Posting> getPostingByMonth(@PathVariable int month,@RequestParam(value = "isAuthority", required = false) boolean isAuthority){
        return postingService.getByMonth(month,isAuthority);
    }

    @GetMapping("/findByDay/{day}")
    public List<Posting> getPostingByDay(@PathVariable int day,@RequestParam(value = "isAuthority", required = false) boolean isAuthority){
        return postingService.getByDay(day,isAuthority);
    }

    @GetMapping("/findByQuarter/{quarter}")
    public List<Posting> getPostingByQuarter(@PathVariable int quarter,@RequestParam(value = "isAuthority", required = false) boolean isAuthority){
        return postingService.getByQuarter(quarter,isAuthority);
    }

}
