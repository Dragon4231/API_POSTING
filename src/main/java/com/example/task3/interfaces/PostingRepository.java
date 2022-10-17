package com.example.task3.interfaces;

import com.example.task3.data.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Integer> {
}
