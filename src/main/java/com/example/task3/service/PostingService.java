package com.example.task3.service;

import com.example.task3.data.LoginUser;
import com.example.task3.data.Posting;
import com.example.task3.interfaces.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PostingService {
    @Autowired
    private final PostingRepository postingRepository;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public void savePosting(Posting posting){
        postingRepository.save(posting);
    }

    public List<Posting> getByYear(int year, boolean isAuthority){
        return postingRepository
                .findAll()
                .stream()
                .filter(new Predicate<Posting>() {
                    @Override
                    public boolean test(Posting posting) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(posting.getDate());
                        if(calendar.get(Calendar.YEAR) == year && isAuthority?(posting.isAuthorityPosting()):true) return true;
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Posting> getByMonth(int month, boolean isAuthority){
        return postingRepository
                .findAll()
                .stream()
                .filter(new Predicate<Posting>() {
                    @Override
                    public boolean test(Posting posting) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(posting.getDate());
                        if(calendar.get(Calendar.MONTH) == month && isAuthority?(posting.isAuthorityPosting()):true) return true;
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Posting> getByDay(int day, boolean isAuthority){
        return postingRepository
                .findAll()
                .stream()
                .filter(new Predicate<Posting>() {
                    @Override
                    public boolean test(Posting posting) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(posting.getDate());
                        if(calendar.get(Calendar.DAY_OF_MONTH) == day  && isAuthority?(posting.isAuthorityPosting()):true) return true;
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Posting> getByQuarter(int quarter, boolean isAuthority){
        return postingRepository
                .findAll()
                .stream()
                .filter(new Predicate<Posting>() {
                    @Override
                    public boolean test(Posting posting) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(posting.getDate());
                        if((calendar.get(Calendar.MONTH) + 2) / 3 == quarter  && isAuthority?(posting.isAuthorityPosting()):true) return true;
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public void clear(){
        postingRepository.deleteAll();
    }
}
